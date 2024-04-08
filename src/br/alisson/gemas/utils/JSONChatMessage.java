package br.alisson.gemas.utils;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONChatMessage {
    private JSONObject chatObject = new JSONObject();

    public JSONChatMessage(String text, JSONChatColor color, List<JSONChatFormat> formats) {
        this.chatObject.put("text", text);
        if (color != null) {
            this.chatObject.put("color", color.getColorString());
        }

        if (formats != null) {
            Iterator var5 = formats.iterator();

            while(var5.hasNext()) {
                JSONChatFormat format = (JSONChatFormat)var5.next();
                this.chatObject.put(format.getFormatString(), true);
            }
        }

    }

    public void addExtra(JSONChatExtra extraObject) {
        if (!this.chatObject.containsKey("extra")) {
            this.chatObject.put("extra", new JSONArray());
        }

        JSONArray extra = (JSONArray)this.chatObject.get("extra");
        extra.add(extraObject.toJSON());
        this.chatObject.put("extra", extra);
    }

    public void sendToPlayer(Player player) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(this.chatObject.toJSONString())));
    }

    public String toString() {
        return this.chatObject.toJSONString();
    }
}