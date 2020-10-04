package sorucoder.librocraft.main.inti;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sorucoder.librocraft.main.LibroCraft;

//@ObjectHolder(LibroCraft.MOD_ID)
//public class ModItems {
//
//    @ObjectHolder("armor_stand")
//    public static final BlockItem ARMOR_STAND = null;
//
//    @Mod.EventBusSubscriber(modid = LibroCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static final class Registry {
//        @SubscribeEvent
//        public static void onItemRegister(final RegistryEvent.Register<Item> event) {
//            final IForgeRegistry<Item> itemRegistry = event.getRegistry();
//            itemRegistry.register(new BlockItem(ModBlocks.ARMOR_STAND_BLOCK, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(LibroCraft.MOD_ID, "armor_stand"));
//        }
//
//    }
//
//}



public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LibroCraft.MOD_ID);

    public static final RegistryObject<Item> ARMOR_STAND = ITEMS.register("armor_stand", () -> new BlockItem(ModBlocks.ARMOR_STAND_BLOCK.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

}