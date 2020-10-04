package sorucoder.librocraft.main.inti;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sorucoder.librocraft.main.LibroCraft;
import sorucoder.librocraft.main.block.tileentity.ArmorStandTileEntity;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, LibroCraft.MOD_ID);

    public static final RegistryObject<TileEntityType<ArmorStandTileEntity>> ARMOR_STAND_TILE_ENTITY = TILE_ENTITY_TYPES.register("armor_stand_tile_entity", () -> TileEntityType.Builder.create(ArmorStandTileEntity::new, ModBlocks.ARMOR_STAND_BLOCK.get()).build(null));
}
