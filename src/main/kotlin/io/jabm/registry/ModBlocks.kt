package io.jabm.registry

import io.jabm.JABM
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Function


object ModBlocks {

    val blockRegistry: DeferredRegister.Blocks = DeferredRegister.createBlocks(JABM.ID) // Block Registry
    val allBlocks = mutableMapOf<String, Function<BlockBehaviour.Properties, out Block>>()

    private fun registerBlock(
        name: String,
        configureItemProperties: Item.Properties.() -> Unit = {},
        configureProperties: BlockBehaviour.Properties.() -> Unit = {}
    ): DeferredBlock<Block> {
        val b = blockRegistry.registerSimpleBlock(name, BlockBehaviour.Properties.of().apply(configureProperties))
        return b
    }

    val simpleBlock = registerBlock("simple_block") {
        sound(SoundType.AMETHYST_CLUSTER)
    }
}
