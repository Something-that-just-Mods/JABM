package io.jabm.worldgen.biome

import com.mojang.datafixers.util.Pair
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.biome.Climate.ParameterPoint
import terrablender.api.Region
import terrablender.api.RegionType
import terrablender.api.Regions
import java.util.function.Consumer


class ModOverworldRegion(name: ResourceLocation?, weight: Int) :
    Region(name, RegionType.OVERWORLD, weight) {
    override fun addBiomes(biomeRegistry: Registry<Biome>, mapper: Consumer<Pair<ParameterPoint, ResourceKey<Biome>>>) {
        this.addModifiedVanillaOverworldBiomes(Biomes.MANGROVE_SWAMP, ModBiomes.BLOOD_SWAMP)
    }
}