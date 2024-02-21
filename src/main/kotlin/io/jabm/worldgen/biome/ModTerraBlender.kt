package io.jabm.worldgen.biome

import io.jabm.JABM
import net.minecraft.resources.ResourceLocation
import terrablender.api.Regions

object ModTerraBlender: Regions() {
    fun registerBiomes() {
        register(ModOverworldRegion(ResourceLocation(JABM.ID, "overworld"), 4))
    }

}