package io.jabm.block

import io.jabm.JABM
import io.jabm.item.ModItems.allBlocks
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.RegisterEvent

object ModTabs {
    val tabRegistry: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JABM.ID)

    private val tabIcon: Item = BuiltInRegistries.ITEM.get(ResourceLocation("minecraft:amethyst_cluster"))

    fun jabmTab(helper: RegisterEvent.RegisterHelper<CreativeModeTab>) {
        helper.register(ResourceLocation(JABM.ID, "jabm"), CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + JABM.ID + "jabm"))
            .icon { ItemStack(tabIcon) }
            .displayItems { params, output ->
                allBlocks.values.forEach { output.accept(it) }
            }
            .build()
        )
    }
}