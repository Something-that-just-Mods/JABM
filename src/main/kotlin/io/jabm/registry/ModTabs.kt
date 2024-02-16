package io.jabm.registry

import io.jabm.JABM
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object ModTabs {
    val tabRegistry: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JABM.ID)

    private val tabIcon: Item = BuiltInRegistries.ITEM.get(ResourceLocation("minecraft:amethyst_cluster"))

    val jabmTab : Supplier<CreativeModeTab> = tabRegistry.register("jabm_tab") { -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup." + JABM.ID))
        .icon { -> ItemStack(tabIcon) }
        .displayItems { params, output ->
            output.accept(ModBlocks.simpleBlock)
        }
        .build()
    }
}