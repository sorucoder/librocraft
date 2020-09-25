package sorucoder.librocraft.main.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import sorucoder.librocraft.main.block.tileentity.ArmorStandTileEntity;

import java.util.Collections;
import java.util.List;

public class ArmorStandBlock extends Block {

        public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

        public ArmorStandBlock() {
            super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0).notSolid());
            this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
        }

        @Override
        public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
            return false;
        }

        @Override
        public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
            return true;
        }

        @Override
        public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
            switch ((Direction) state.get(FACING)) {
                case UP:
                case DOWN:
                case SOUTH:
                default:
                    return VoxelShapes.create(1D, 0D, 1D, 0D, 2D, 0D);
                case NORTH:
                    return VoxelShapes.create(0D, 0D, 0D, 1D, 2D, 1D);
                case WEST:
                    return VoxelShapes.create(0D, 0D, 1D, 1D, 2D, 0D);
                case EAST:
                    return VoxelShapes.create(1D, 0D, 0D, 0D, 2D, 1D);
            }
        }

        @Override
        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
            builder.add(FACING);
        }

        public BlockState rotate(BlockState state, Rotation rot) {
            return state.with(FACING, rot.rotate(state.get(FACING)));
        }

        public BlockState mirror(BlockState state, Mirror mirrorIn) {
            return state.rotate(mirrorIn.toRotation(state.get(FACING)));
        }

        @Override
        public BlockState getStateForPlacement(BlockItemUseContext context) {
            return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
        }

        @Override
        public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
            return MaterialColor.WOOD;
        }

        @Override
        public PushReaction getPushReaction(BlockState state) {
            return PushReaction.DESTROY;
        }

        @Override
        public boolean canConnectRedstone(BlockState state, IBlockReader world, BlockPos pos, Direction side) {
            return true;
        }

        @Override
        public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
            List<ItemStack> dropsOriginal = super.getDrops(state, builder);
            if (!dropsOriginal.isEmpty())
                return dropsOriginal;
            return Collections.singletonList(new ItemStack(this, 1));
        }

        @Override
        public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            return tileEntity instanceof INamedContainerProvider ? (INamedContainerProvider) tileEntity : null;
        }



        @Override
        public boolean hasTileEntity(BlockState state) {
            return true;
        }

        @Override
        public TileEntity createTileEntity(BlockState state, IBlockReader world) {
            return new ArmorStandTileEntity();
        }

        @Override
        public boolean eventReceived(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
            super.eventReceived(state, world, pos, eventID, eventParam);
            TileEntity tileentity = world.getTileEntity(pos);
            return tileentity != null && tileentity.receiveClientEvent(eventID, eventParam);
        }

        @Override
        public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
            if (state.getBlock() != newState.getBlock()) {
                TileEntity tileentity = world.getTileEntity(pos);
                if (tileentity instanceof ArmorStandTileEntity) {
                    InventoryHelper.dropInventoryItems(world, pos, (ArmorStandTileEntity) tileentity);
                    world.updateComparatorOutputLevel(pos, this);
                }
                super.onReplaced(state, world, pos, newState, isMoving);
            }
        }

        @Override
        public boolean hasComparatorInputOverride(BlockState state) {
            return true;
        }

        @Override
        public int getComparatorInputOverride(BlockState blockState, World world, BlockPos pos) {
            TileEntity tileentity = world.getTileEntity(pos);
            if (tileentity instanceof ArmorStandTileEntity)
                return Container.calcRedstoneFromInventory((ArmorStandTileEntity) tileentity);
            else
                return 0;
        }
    }


