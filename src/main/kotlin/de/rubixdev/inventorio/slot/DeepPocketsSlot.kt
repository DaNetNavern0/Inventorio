package de.rubixdev.inventorio.slot

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.slot.Slot

open class DeepPocketsSlot(inventory: Inventory, index: Int, x: Int, y: Int) : Slot(inventory, index, x, y) {
    @JvmField var canTakeItems = true

    override fun canTakeItems(playerEntity: PlayerEntity): Boolean {
        return canTakeItems
    }

    override fun canInsert(stack: ItemStack): Boolean {
        return canTakeItems
    }

    override fun isEnabled(): Boolean {
        return canTakeItems
    }
}
