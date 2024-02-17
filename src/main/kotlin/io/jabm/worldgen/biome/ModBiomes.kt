package io.jabm.worldgen.biome

import io.jabm.JABM
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.MobSpawnSettings

object ModBiomes {
    private val WHEAT_GRASS_SAVANNAH: ResourceKey<Biome> = ResourceKey.create(
        Registries.BIOME,
        ResourceLocation(JABM.ID, "wheat_grass_savannah_biome")
    )

    fun bootstrap(context: BootstapContext<Biome>) {
        context.register(WHEAT_GRASS_SAVANNAH, bloodSwampBiome(context))

    }

    private fun bloodSwampBiome(context: BootstapContext<Biome>): Biome {
        val spawnbuilder: MobSpawnSettings.Builder = MobSpawnSettings.Builder()


        return TODO("Provide the return value")
    }
}