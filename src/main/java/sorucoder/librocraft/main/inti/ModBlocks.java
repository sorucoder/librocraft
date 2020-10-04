package sorucoder.librocraft.main.inti;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sorucoder.librocraft.main.LibroCraft;
import sorucoder.librocraft.main.block.ArmorStandBlock;

//@ObjectHolder(LibroCraft.MOD_ID)
//public class ModBlocks {
//
//    public static final Block ARMOR_STAND_BLOCK = null;
//
//    @ObjectHolder("armor_stand_block")
//    public static final TileEntityType<ArmorStandTileEntity> ARMOR_STAND_TILE_ENTITY = null;
//
//    @Mod.EventBusSubscriber(modid = LibroCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static final class Registry {
//
//        @SubscribeEvent
//        public static void onBlockRegister(final RegistryEvent.Register<Block> event) {
//            final IForgeRegistry<Block> blockRegistry = event.getRegistry();
//            blockRegistry.register(new ArmorStandBlock().setRegistryName(LibroCraft.MOD_ID, "armor_stand_block"));
//
//        }
//
//        @SubscribeEvent
//        public static void onTileEntityRegister(final RegistryEvent.Register<TileEntityType<?>> event) {
//            final IForgeRegistry<TileEntityType<?>> tileEntityRegistry = event.getRegistry();
//            tileEntityRegistry.register(TileEntityType.Builder.create(ArmorStandTileEntity::new, ARMOR_STAND_BLOCK).build(null).setRegistryName(LibroCraft.MOD_ID, "armor_stand_block"));
//        }
//    }
//}

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LibroCraft.MOD_ID);


    public static final RegistryObject<ArmorStandBlock> ARMOR_STAND_BLOCK = BLOCKS.register("armor_stand_block", ArmorStandBlock::new);


}