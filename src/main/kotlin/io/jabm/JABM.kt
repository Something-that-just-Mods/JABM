package io.jabm

import io.jabm.block.Blocks
import io.jabm.block.Tab
import io.jabm.item.Items
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
    private val logger : Logger = LogManager.getLogger(ID)
    init {
        logger.log(Level.INFO, "Ja-BM!")
        Blocks.blockRegistry.register(MOD_BUS)
        Items.itemRegistry.register(MOD_BUS)
        Tab.tabRegistry.register(MOD_BUS)
    }

    /* Apparently this is required for the game to start? */
    @SubscribeEvent
    private fun commonSetup(event: FMLCommonSetupEvent) {}
}