package sorucoder.librocraft.main;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sorucoder.librocraft.main.inti.ModBlocks;
import sorucoder.librocraft.main.inti.ModItems;
import sorucoder.librocraft.main.inti.ModTileEntities;
import sorucoder.librocraft.main.proxy.ClientProxy;
import sorucoder.librocraft.main.proxy.IProxy;
import sorucoder.librocraft.main.proxy.ServerProxy;
import sorucoder.librocraft.main.rendering.tileentity.ArmorStandTileEntityRenderer;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("librocraft")
public class LibroCraft
{
    public static final String MOD_ID = "librocraft";
    public static final String NAME = "LibroCraft";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public LibroCraft() {
        // Register the setup method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the enqueueIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        register(mod);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register ourselves for server and other game events we are interested in
        //MinecraftForge.EVENT_BUS.register(this);
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }


    private void register(IEventBus bus) {
        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        ModTileEntities.TILE_ENTITY_TYPES.register(bus);
    }


    //    private void setup(final FMLCommonSetupEvent event)
//    {
//        // some preinit code
//        LOGGER.info("HELLO FROM PREINIT");
//        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
//    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.ARMOR_STAND_TILE_ENTITY.get(),  ArmorStandTileEntityRenderer::new);
    }
//
//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//        // some example code to dispatch IMC to another mod
//        InterModComms.sendTo("librocraft", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
//    }
//
//    private void processIMC(final InterModProcessEvent event)
//    {
//        // some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.getMessageSupplier().get()).
//                collect(Collectors.toList()));
//    }
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent event) {
//        // do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }


}
