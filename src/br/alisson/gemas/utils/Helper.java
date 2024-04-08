package br.alisson.gemas.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Map.Entry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;

public class Helper {
    private Helper() {
    }

    public static <K, V extends Comparable<? super V>> SortedSet<Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Entry<K, V>> sortedEntries = new TreeSet(new Comparator<Entry<K, V>>() {
            public int compare(Entry<K, V> e1, Entry<K, V> e2) {
                int res = ((Comparable)e2.getValue()).compareTo(e1.getValue());
                return res != 0 ? res : 1;
            }
        });
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    public static boolean isInteger(Object o) {
        return o instanceof Integer;
    }

    public static String format(double coins) {
        boolean isWholeNumber = coins == (double)Math.round(coins);
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        formatSymbols.setDecimalSeparator('.');
        String pattern = isWholeNumber ? "###,###.###" : "###,##0.00";
        DecimalFormat df = new DecimalFormat(pattern, formatSymbols);
        return df.format(coins);
    }

    public static boolean isDouble(String o) {
        try {
            double d = Double.parseDouble(o);
            return true;
        } catch (Exception var3) {
            var3.printStackTrace();
            return false;
        }
    }

    public static boolean isByte(String input) {
        try {
            Byte.parseByte(input);
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean isShort(String input) {
        try {
            Short.parseShort(input);
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean isFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean isString(Object o) {
        return o instanceof String;
    }

    public static boolean isBoolean(Object o) {
        return o instanceof Boolean;
    }

    public static String removeChar(String s, char c) {
        String r = "";

        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != c) {
                r = r + s.charAt(i);
            }
        }

        return r;
    }

    public static String removeFirstChar(String s, char c) {
        String r = "";

        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != c) {
                r = r + s.charAt(i);
                break;
            }
        }

        return r;
    }

    public static String capitalize(String content) {
        if (content.length() < 2) {
            return content;
        } else {
            String first = content.substring(0, 1).toUpperCase();
            return first + content.substring(1);
        }
    }

    public static String plural(int count, String word, String ending) {
        return count == 1 ? word : word + ending;
    }

    public static String toColor(String hexValue) {
        return hexValue == null ? "" : ChatColor.getByChar(hexValue).toString();
    }

    public static List<String> fromArray(String... values) {
        List<String> results = new ArrayList();
        Collections.addAll(results, values);
        results.remove("");
        return results;
    }

    public static Set<String> fromArray2(String... values) {
        HashSet<String> results = new HashSet();
        Collections.addAll(results, values);
        results.remove("");
        return results;
    }

    public static List<Player> fromPlayerArray(Player... values) {
        List<Player> results = new ArrayList();
        Collections.addAll(results, values);
        return results;
    }

    public static String[] toArray(List<String> list) {
        return (String[])list.toArray(new String[list.size()]);
    }

    public static String[] removeFirst(String[] args) {
        List<String> out = fromArray(args);
        if (!out.isEmpty()) {
            out.remove(0);
        }

        return toArray(out);
    }

    public static String toMessage(String[] args) {
        String out = "";
        String[] var5 = args;
        int var4 = args.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            String arg = var5[var3];
            out = out + arg + " ";
        }

        return out.trim();
    }

    public static String toMessage(String[] args, String sep) {
        String out = "";
        String[] var6 = args;
        int var5 = args.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            String arg = var6[var4];
            out = out + arg + ", ";
        }

        return stripTrailing(out, ", ");
    }

    public static String toMessage(List<String> args, String sep) {
        String out = "";

        String arg;
        for(Iterator var4 = args.iterator(); var4.hasNext(); out = out + arg + sep) {
            arg = (String)var4.next();
        }

        return stripTrailing(out, sep);
    }

    public static String parseColors(String msg) {
        return msg.replace("&", "§");
    }

    public static String stripColors(String msg) {
        String out = msg.replaceAll("[&][0-9a-f]", "");
        out = out.replaceAll(String.valueOf('Â'), "");
        return out.replaceAll("[§][0-9a-f]", "");
    }

    public static String getLastColorCode(String msg) {
        msg = msg.replaceAll(String.valueOf('Â'), "").trim();
        if (msg.length() < 2) {
            return "";
        } else {
            String one = msg.substring(msg.length() - 2, msg.length() - 1);
            String two = msg.substring(msg.length() - 1);
            if (one.equals("§")) {
                return one + two;
            } else {
                return one.equals("&") ? toColor(two) : "";
            }
        }
    }

    public static String cleanTag(String tag) {
        return stripColors(tag).toLowerCase();
    }

    public static String stripTrailing(String msg, String sep) {
        if (msg.length() < sep.length()) {
            return msg;
        } else {
            String out = msg;
            String first = msg.substring(0, sep.length());
            String last = msg.substring(msg.length() - sep.length(), msg.length());
            if (first.equals(sep)) {
                out = msg.substring(sep.length());
            }

            if (last.equals(sep)) {
                out = msg.substring(0, msg.length() - sep.length());
            }

            return out;
        }
    }

    public static String generatePageSeparator(String sep) {
        String out = "";

        for(int i = 0; i < 320; ++i) {
            out = out + sep;
        }

        return out;
    }

    /** @deprecated */
    @Deprecated
    public static boolean isOnline(String playerName) {
        Collection<Player> online = getOnlinePlayers();
        Iterator var3 = online.iterator();

        while(var3.hasNext()) {
            Player o = (Player)var3.next();
            if (o.getName().equalsIgnoreCase(playerName)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isOnline(UUID playerUniqueId) {
        Collection<Player> online = getOnlinePlayers();
        Iterator var3 = online.iterator();

        while(var3.hasNext()) {
            Player o = (Player)var3.next();
            if (o.getUniqueId().equals(playerUniqueId)) {
                return true;
            }
        }

        return false;
    }

    public static boolean testURL(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
            urlConn.connect();
            return urlConn.getResponseCode() == 200;
        } catch (IOException var3) {
            return false;
        }
    }

    public static String escapeQuotes(String str) {
        return str == null ? "" : str.replace("'", "''");
    }

    public static String toLocationString(Location loc) {
        return loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ() + " " + loc.getWorld().getName();
    }

    public static boolean isSameBlock(Location loc, Location loc2) {
        return loc.getBlockX() == loc2.getBlockX() && loc.getBlockY() == loc2.getBlockY() && loc.getBlockZ() == loc2.getBlockZ();
    }

    public static boolean isSameLocation(Location loc, Location loc2) {
        return loc.getX() == loc2.getX() && loc.getY() == loc2.getY() && loc.getZ() == loc2.getZ();
    }

    public static Map sortByValue(Map map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable)((Entry)o2).getValue()).compareTo(((Entry)o1).getValue());
            }
        });
        Map result = new LinkedHashMap();
        Iterator it = list.iterator();

        while(it.hasNext()) {
            Entry entry = (Entry)it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static boolean isVanished(Player player) {
        return player != null && player.hasMetadata("vanished") && !player.getMetadata("vanished").isEmpty() ? ((MetadataValue)player.getMetadata("vanished").get(0)).asBoolean() : false;
    }

    public static Collection<Player> getOnlinePlayers() {
        try {
            Method method = Bukkit.class.getDeclaredMethod("getOnlinePlayers");
            Object players = method.invoke((Object)null);
            return (Collection)(players instanceof Player[] ? new ArrayList(Arrays.asList((Player[])players)) : (Collection)players);
        } catch (Exception var2) {
            var2.printStackTrace();
            return new ArrayList();
        }
    }
}