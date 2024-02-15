package io.jabm.block

import io.jabm.JABM
import io.jabm.item.Items
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister


object Blocks {
    val blockRegistry: DeferredRegister.Blocks = DeferredRegister.createBlocks(JABM.ID) // Block Registry

    private fun registerBlock(
        name: String,
        configureItemProperties: Item.Properties.() -> Unit = {},
        configureProperties: BlockBehaviour.Properties.() -> Unit = {
        }
    ): DeferredBlock<Block> {
        val b = blockRegistry.registerSimpleBlock(name, BlockBehaviour.Properties.of().apply(configureProperties))
        Items.registerBlockItem(b, configureItemProperties)
        return b
    }

    val simpleBlock = registerBlock("simple_block") {
        sound(SoundType.AMETHYST_CLUSTER)
    }
}