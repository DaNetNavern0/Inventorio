package me.lizardofoz.inventorio.mixin.client;

import me.lizardofoz.inventorio.packet.InventorioNetworking;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * This mixin sends player's list of ignored screens to the server, because Server Handler has a server-side component,
 * that acts differently if a user flagged a specific gui to be ignored by the mod
 */
@Mixin(ClientPlayNetworkHandler.class)
@Environment(EnvType.CLIENT)
public class ClientPlayNetworkHandlerMixin
{
    @Inject(method = "onGameJoin", at = @At(value = "RETURN"))
    private void sendIgnoredScreensC2S(GameJoinS2CPacket packet, CallbackInfo ci)
    {
        InventorioNetworking.INSTANCE.C2SSendIgnoredScreenHandlers();
    }
}