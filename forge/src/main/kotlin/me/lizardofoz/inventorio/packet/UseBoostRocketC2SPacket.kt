package me.lizardofoz.inventorio.packet

import me.lizardofoz.inventorio.player.PlayerInventoryAddon.Companion.inventoryAddon
import net.minecraftforge.fml.network.NetworkEvent
import java.util.function.Supplier

class UseBoostRocketC2SPacket
{
    constructor()
    {
    }

    fun consume(supplier: Supplier<NetworkEvent.Context>)
    {
        val sender = supplier.get().sender
        supplier.get().enqueueWork {
            sender?.inventoryAddon?.fireRocketFromInventory()
        }
        supplier.get().packetHandled = true
    }
}