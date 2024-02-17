package io.jabm.registry

import io.jabm.JABM
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object ModTabs {
    val tabRegistry: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JABM.ID)

    val jabmTab : Supplier<CreativeModeTab> = tabRegistry.register("jabm_tab") { -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup." + JABM.ID))
        .icon { -> ItemStack(Items.OAK_SAPLING) }
        .displayItems { params, output ->
            ModItems.allItems.values.forEach { item ->
                output.accept(ItemStack((item as DeferredItem<*>).get()))
            }
        }
        .build()
    }

    init {
        jabmTab
    }
}