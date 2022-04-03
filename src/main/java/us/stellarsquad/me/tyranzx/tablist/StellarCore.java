package us.stellersquad.me.tyranzx.tablist;

import org.bukkit.plugin.java.JavaPlugin;

public final class StellarCore  extends JavaPlugin {

    @Override
    public void onEnable() {
        Packets p = new Packets(this);
        p.sendPacket(); // <- Packet sent to everyone
        this.getLogger().info("Plugin tablist ha sido activado correctamente.");
    }
}
