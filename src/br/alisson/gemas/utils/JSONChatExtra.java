package br.alisson.gemas.utils;

import org.json.simple.JSONObject;

public class JSONChatExtra {
    private JSONObject chatExtra = new JSONObject();

    public JSONChatExtra(String text) {
        this.chatExtra.put("text", text);
    }

    public void setClickEvent(JSONChatClickEventType action, String value) {
        JSONObject clickEvent = new JSONObject();
        clickEvent.put("action", action.getTypeString());
        clickEvent.put("value", value);
        this.chatExtra.put("clickEvent", clickEvent);
    }

    public void setHoverEvent(JSONChatHoverEventType action, String value) {
        JSONObject hoverEvent = new JSONObject();
        hoverEvent.put("action", action.getTypeString());
        hoverEvent.put("value", value);
        this.chatExtra.put("hoverEvent", hoverEvent);
    }

    public JSONObject toJSON() {
        return this.chatExtra;
    }
}