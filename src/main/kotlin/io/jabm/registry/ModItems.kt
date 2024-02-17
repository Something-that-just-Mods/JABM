package io.jabm.registry

import io.jabm.JABM.ID
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister


object ModItems {
    val itemRegistry: DeferredRegister.Items = DeferredRegister.createItems(ID)
    val allItems = mutableMapOf<String, DeferredItem<out Item>>()

    fun registerBlockItem(
        block: DeferredBlock<Block>,
        configureItemProperties: Item.Properties.() -> Unit = {}
    ): DeferredItem<BlockItem> {
        val i = itemRegistry.registerSimpleBlockItem(block.id.path, block, Item.Properties().apply(configureItemProperties))
        return i
    }
}