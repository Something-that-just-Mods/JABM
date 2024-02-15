package io.jabm.item

import io.jabm.JABM.ID
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister


object Items {
    val itemRegistry: DeferredRegister.Items = DeferredRegister.createItems(ID)
    var allBlocks = mutableMapOf<String, BlockItem>()

    fun registerBlockItem(
        block: DeferredBlock<Block>,
        configureItemProperties: Item.Properties.() -> Unit = {}
    ): DeferredItem<BlockItem>? {
        val b = itemRegistry.registerSimpleBlockItem(block.id.path, block, Item.Properties().apply(configureItemProperties))
        val item = b.get()
        allBlocks[b.id.path] = item

        return b
    }
}