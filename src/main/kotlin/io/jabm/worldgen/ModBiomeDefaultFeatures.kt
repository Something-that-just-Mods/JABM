package io.jabm.worldgen

import net.minecraft.data.worldgen.placement.VegetationPlacements
import net.minecraft.world.level.biome.BiomeGenerationSettings
import net.minecraft.world.level.levelgen.GenerationStep.Decoration

object ModBiomeDefaultFeatures {
    fun addBloodSwampVegetation(builder: BiomeGenerationSettings.Builder) {
        builder.addFeature(Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_SWAMP)
        builder.addFeature(Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_SWAMP)
        builder.addFeature(Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL)
        builder.addFeature(Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH)
        builder.addFeature(Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY)
        builder.addFeature(Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_SWAMP)
    }
}
