package br.alisson.gemas.utils;

public enum JSONChatFormat {
    BOLD("bold"),
    UNDERLINED("underlined"),
    STRIKETHROUGH("strikethrough"),
    ITALIC("italic"),
    OBFUSCATED("obfuscated");

    private final String format;

    private JSONChatFormat(String format) {
        this.format = format;
    }

    public String getFormatString() {
        return this.format;
    }
}