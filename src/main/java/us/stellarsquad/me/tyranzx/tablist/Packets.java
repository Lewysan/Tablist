package us.stellersquad.me.tyranzx.tablist;

import net.minecraft.server.v1_8_R1.ChatComponentText;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.lang.reflect.Field;

public class Packets extends StellarSource implements Listener {

    private boolean titlechange = true;
    protected final StellarCore core;

    public Packets(StellarCore core) {
        this.core = core;
    }

    public void sendPacket() {
        int taskID = sh.scheduleSyncRepeatingTask(core, () -> {
            PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
            try {
                Field a = packet.getClass().getDeclaredField("a");
                Field b = packet.getClass().getDeclaredField("b");
                a.setAccessible(true);
                b.setAccessible(true);

                Object header1 = new ChatComponentText("§7 \n§d Mi servidor de Bukkit Coding \n§7play.stellarsquad.fr");
                Object header2 = new ChatComponentText("§7\n§e§lSTELLAR SQUAD\n §7us.stellarsquad.com\n§7");
                Object footer = new ChatComponentText("§7\n§6Sígueme en github:\n§bhttps://github.com/Lewysan/\n§dCoding x Tyranzx\n");

                if (titlechange) {
                    a.set(packet, header1);
                    titlechange = false;
                }
                a.set(packet, header2);
                titlechange = true;
                b.set(packet, footer);
                if (server.getOnlinePlayers().size() == 0) return;
                for (Player p : server.getOnlinePlayers()) {
                    ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
                core.getLogger().info("Error en la syntax del codigo.");
            }
        }, 0, 20);
    }
}
