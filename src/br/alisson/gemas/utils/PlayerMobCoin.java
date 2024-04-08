package br.alisson.gemas.utils;

import br.alisson.gemas.Principal;

public class PlayerMobCoin {
    private String name;
    private int mobcoin;
    private Principal plugin;

    public PlayerMobCoin(String name, int mobcoin, Principal plugin) {
        this.plugin = plugin;
        this.name = name;
        this.mobcoin = mobcoin;
    }

    public String getName() {
        return this.name;
    }

    public int getMobCoin() {
        return this.mobcoin;
    }

    public int withdrawMobCoin(int mobcoin) {
        return this.setMobCoin(this.mobcoin - mobcoin);
    }

    public int depositMobCoin(int mobcoin) {
        return this.mobcoin += mobcoin;
    }

    public int setMobCoin(int mobcoin) {
        return this.mobcoin = mobcoin;
    }

    public void save() {
        this.plugin.getSql().setMobCoin(this.name, this.mobcoin);
    }
}