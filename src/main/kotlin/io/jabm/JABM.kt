package io.jabm

import io.jabm.block.ModBlocks
import net.neoforged.fml.common.Mod
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(JABM.ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
object JABM {
    const val ID = "jabm"

    init {
        val LOGGER: Logger = LogManager.getLogger(ID)
        LOGGER.log(Level.INFO, "JABM!")

        ModBlocks.REGISTRY.register(MOD_BUS)
    }
}