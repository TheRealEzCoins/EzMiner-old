package me.ezplugin.Enums;

public enum Stats {
    EXP(0),
    Level(0);

    private int Amount;

    Stats(int amount) {
        this.Amount = amount;
    }

    public int getAmount() {
        return this.Amount;
    }

}
