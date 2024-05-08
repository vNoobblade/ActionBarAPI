package net.noobblade.actionbarapi;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class ActionBar {

    private final PacketPlayOutChat packet;
    private final int durationTicks; // Duration in ticks (20 ticks = 1 second)

    public ActionBar(String text, int durationSeconds) {
        this.packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + text + "\"}"), (byte) 2);
        this.durationTicks = (durationSeconds == -1) ? -1 : durationSeconds * 20; // convert seconds to ticks if duration is -1 it will last forever
    }

    public void sendToPlayer(Player p) {
        if (p.isOnline()) { // player could be offline
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public void sendToAll() {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            sendToPlayer(p);
        }
    }

    public int getDurationTicks() {
        return durationTicks;
    }
}
