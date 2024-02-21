package io.jabm.worldgen.biome

import io.jabm.JABM
import io.jabm.worldgen.ModBiomeDefaultFeatures
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BiomeDefaultFeatures
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.placement.AquaticPlacements
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.BiomeGenerationSettings
import net.minecraft.world.level.biome.BiomeSpecialEffects
import net.minecraft.world.level.biome.MobSpawnSettings
import net.minecraft.world.level.levelgen.GenerationStep.Decoration

object ModBiomes {
     val BLOOD_SWAMP: ResourceKey<Biome> = ResourceKey.create(Registries.BIOME, ResourceLocation(JABM.ID, "blood_swamp_biome"))
    fun globalOverworldGeneration(builder: BiomeGenerationSettings.Builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder)
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder)
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder)
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder)
        BiomeDefaultFeatures.addDefaultSprings(builder)
        BiomeDefaultFeatures.addSurfaceFreezing(builder)
    }

    fun bootstrap(context: BootstapContext<Biome>) {
        context.register(BLOOD_SWAMP, bloodSwamp(context))
    }

     fun bloodSwamp(context: BootstapContext<Biome>): Biome {
        val spawnBuilder: MobSpawnSettings.Builder = MobSpawnSettings.Builder()
        val biomeBuilder: BiomeGenerationSettings.Builder = BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER))
        spawnBuilder.addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.SLIME, 2, 3, 5))
        spawnBuilder.addSpawn(MobCategory.CREATURE, MobSpawnSettings.SpawnerData(EntityType.FROG, 3, 1, 7))
        BiomeDefaultFeatures.farmAnimals(spawnBuilder)
        BiomeDefaultFeatures.commonSpawns(spawnBuilder)
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder)
        globalOverworldGeneration(biomeBuilder)
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder)
        BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder)
        ModBiomeDefaultFeatures.addBloodSwampVegetation(biomeBuilder)
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder)
        BiomeDefaultFeatures.addSwampExtraVegetation(biomeBuilder)
        biomeBuilder.addFeature(Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP)
        return Biome.BiomeBuilder()
            .hasPrecipitation(true)
            .downfall(0.9F)
            .temperature(0.8F)
            .specialEffects((BiomeSpecialEffects.Builder()).waterColor(0xFFFF6E6B.toInt()).waterFogColor(0xFF823C39.toInt()).grassColorOverride(0xFFFF6E6B.toInt())
            .build())
            .build()
    }
}