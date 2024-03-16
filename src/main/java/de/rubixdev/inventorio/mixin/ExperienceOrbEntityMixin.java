package de.rubixdev.inventorio.mixin;

import de.rubixdev.inventorio.util.MixinHelpers;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {
    @Shadow
    private int amount;

    /**
     * This inject allows items in the ToolBelt to be Mended
     */
    @Inject(
        method = "onPlayerCollision",
        at = @At(value = "FIELD", target = "Lnet/minecraft/entity/ExperienceOrbEntity;amount:I"),
        require = 0
    )
    private void inventorioMendToolBeltItems(PlayerEntity player, CallbackInfo ci) {
        MixinHelpers.withInventoryAddon(player, addon -> this.amount = addon.mendToolBeltItems(this.amount));
    }
}
