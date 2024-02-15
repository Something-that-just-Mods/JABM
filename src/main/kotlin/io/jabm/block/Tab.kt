package io.jabm.block

import io.jabm.JABM
import io.jabm.item.Items.allBlocks
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object Tab {
    val tabRegistry: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JABM.ID)

    private val tabIcon: Item = BuiltInRegistries.ITEM.get(ResourceLocation("minecraft:amethyst_cluster"))
    val tab : Supplier<CreativeModeTab> = tabRegistry.register("jabm") { _ ->
        val creativeModeTab = CreativeModeTab.builder().apply {
            icon { ItemStack(tabIcon) }
            title(Component.translatable("itemGroup." + JABM.ID + "jabm"))
            displayItems { _, output ->
                allBlocks.values.forEach { output.accept(it) }
            }
        }.build()
        creativeModeTab
    }
}