package surocoder.librocraft.main.inti;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import surocoder.librocraft.main.LibroCraft;

@ObjectHolder(LibroCraft.MOD_ID)
public class ModItems {

    @ObjectHolder("armor_stand")
    public static final BlockItem ARMOR_STAND = null;

    @Mod.EventBusSubscriber(modid = LibroCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static final class Registry {
        @SubscribeEvent
        public static void onItemRegister(final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> itemRegistry = event.getRegistry();
            itemRegistry.register(new BlockItem(ModBlocks.ARMOR_STAND_BLOCK, new Item.Properties().group(ItemGroup.DECORATIONS)));
        }

    }

}
