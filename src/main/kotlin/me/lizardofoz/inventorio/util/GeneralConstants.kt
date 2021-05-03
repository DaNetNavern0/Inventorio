package me.lizardofoz.inventorio.util

import net.minecraft.item.ItemStack

const val DEEP_POCKETS_MAX_LEVEL = 3
const val VANILLA_ROW_LENGTH = 9
const val INVENTORIO_ROW_LENGTH = 12

const val INVENTORY_SLOT_SIZE = 18

const val MAIN_INVENTORY_SIZE = INVENTORIO_ROW_LENGTH * 3
const val EXTENSION_SIZE = DEEP_POCKETS_MAX_LEVEL * INVENTORIO_ROW_LENGTH
const val ARMOR_SIZE = 4
const val TOOL_BELT_SIZE = 5
const val UTILITY_BELT_SIZE = 8


val MAIN_INVENTORY_RANGE = 0 until MAIN_INVENTORY_SIZE
val ARMOR_RANGE = MAIN_INVENTORY_RANGE.last + 1 until (MAIN_INVENTORY_RANGE.last + 1) + ARMOR_SIZE
val DUD_OFFHAND_RANGE = ARMOR_RANGE.last + 1 .. ARMOR_RANGE.last + 1
val EXTENSION_RANGE = DUD_OFFHAND_RANGE.last + 1 until (DUD_OFFHAND_RANGE.last + 1) + EXTENSION_SIZE
val TOOL_BELT_RANGE = EXTENSION_RANGE.last + 1 until (EXTENSION_RANGE.last + 1) + TOOL_BELT_SIZE
val UTILITY_BELT_RANGE = TOOL_BELT_RANGE.last + 1 until (TOOL_BELT_RANGE.last + 1) + UTILITY_BELT_SIZE
val QUICK_BAR_RANGE = UTILITY_BELT_RANGE.last + 1 until (UTILITY_BELT_RANGE.last + 1) + INVENTORIO_ROW_LENGTH
val CRAFTING_GRID_RANGE = QUICK_BAR_RANGE.last + 1 until (QUICK_BAR_RANGE.last + 1) + 5
val UTILITY_BELT_EXTENSION_RANGE = UTILITY_BELT_RANGE.first + 4 .. UTILITY_BELT_RANGE.last

val ItemStack.isNotEmpty: Boolean
    get() = !this.isEmpty