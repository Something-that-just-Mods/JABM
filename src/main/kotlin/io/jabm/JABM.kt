package io.jabm

import io.jabm.registry.ModBlocks
import io.jabm.registry.ModItems
import io.jabm.registry.ModTabs
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(JABM.ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
object JABM {
    const val ID = "jabm"
    val logger : Logger = LogManager.getLogger(ID)
    init {
        logger.log(Level.INFO, "Ja-BM!")
        ModBlocks.blockRegistry.register(MOD_BUS)
        ModItems.itemRegistry.register(MOD_BUS)
        ModTabs.tabRegistry.register(MOD_BUS)
    }

    /* Apparently this is required for the game to start? */
    @SubscribeEvent
    private fun commonSetup(event: FMLCommonSetupEvent) {}
}