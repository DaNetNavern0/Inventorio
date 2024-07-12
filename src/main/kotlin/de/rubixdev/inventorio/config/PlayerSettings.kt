package de.rubixdev.inventorio.config

import com.google.gson.JsonPrimitive
import de.rubixdev.inventorio.player.PlayerInventoryAddon.Companion.inventoryAddon
import de.rubixdev.inventorio.util.ScrollWheelUtilityBeltMode
import de.rubixdev.inventorio.util.SegmentedHotbar
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.MinecraftClient

@Environment(EnvType.CLIENT)
object PlayerSettings : AbstractSettings() {
    @JvmField
    val swappedHands = SettingsEntryBoolean(
        false,
        "SwappedHands",
        "inventorio.settings.player.swapped_hands",
        "inventorio.settings.player.swapped_hands.tooltip",
    ) { MinecraftClient.getInstance().player?.inventoryAddon?.swappedHands = it == true }

    @JvmField
    val segmentedHotbar = SettingsEntry(
        SegmentedHotbar.OFF,
        "SegmentedHotbar",
        "inventorio.settings.player.segmented_hotbar_mode",
        null,
        { JsonPrimitive((it as SegmentedHotbar).name) },
        { if (it != null) SegmentedHotbar.valueOf(it.asString) else SegmentedHotbar.OFF },
    )

    @JvmField
    val scrollWheelUtilityBelt =
        SettingsEntry(
            ScrollWheelUtilityBeltMode.OFF,
            "ScrollWheelUtilityBelt",
            "inventorio.settings.player.scroll_wheel_utility_belt_mode",
            null,
            { JsonPrimitive((it as ScrollWheelUtilityBeltMode).name) },
            { ScrollWheelUtilityBeltMode.valueOf(it!!.asString) },
        )

    @JvmField
    val skipEmptyUtilitySlots = SettingsEntryBoolean(
        true,
        "SkipEmptyUtilitySlots",
        "inventorio.settings.player.skip_empty_utility_slots",
    )

    @JvmField
    val useItemAppliesToOffhand = SettingsEntryBoolean(
        false,
        "UseItemAppliesToOffhand",
        "inventorio.settings.player.use_item_applies_to_offhand",
        "inventorio.settings.player.use_item_applies_to_offhand.tooltip",
    )

    @JvmField
    val disableAttackSwap = SettingsEntryBoolean(
        false,
        "DisableAttackSwap",
        "inventorio.settings.player.disable_attack_swap",
        "inventorio.settings.player.disable_attack_swap.tooltip",
    )

    @JvmField
    val canThrowUnloyalTrident = SettingsEntryBoolean(
        false,
        "CanThrowUnloyalTrident",
        "inventorio.settings.player.can_throw_unloyal_trident",
    )

    @JvmField
    val darkTheme = SettingsEntryBoolean(
        false,
        "DarkTheme",
        "inventorio.settings.player.dark_theme",
        "inventorio.settings.player.dark_theme.tooltip",
    )

    @JvmField
    val aggressiveButtonRemoval = SettingsEntryBoolean(
        false,
        "AggressiveButtonRemoval",
        "inventorio.settings.player.aggressive_button_removal",
        "inventorio.settings.player.aggressive_button_removal.tooltip",
    )

    @JvmField
    val toggleButton = SettingsEntryBoolean(
        true,
        "ToggleButton",
        "inventorio.settings.player.toggle_button",
    )

    @JvmField
    val centeredScreen = SettingsEntryBoolean(
        false,
        "CenteredScreen",
        "inventorio.settings.player.centered_screen",
        "inventorio.settings.player.centered_screen.tooltip",
    )

    //#if FORGELIKE
    @JvmField
    val curiosOpenByDefault = SettingsEntryBoolean(
        false,
        "CuriosOpenByDefault",
        "inventorio.settings.player.curios_open_by_default",
        "inventorio.settings.player.curios_open_by_default.tooltip",
    )
    //#endif

    init {
        entries = listOf(
            segmentedHotbar,
            scrollWheelUtilityBelt,
            canThrowUnloyalTrident,
            darkTheme,
            useItemAppliesToOffhand,
            disableAttackSwap,
            skipEmptyUtilitySlots,
            swappedHands,
            aggressiveButtonRemoval,
            toggleButton,
            centeredScreen,
            //#if FORGELIKE
            curiosOpenByDefault,
            //#endif
        )
    }
}
