package me.ezplugin.Enums;

public enum Heads {
    Gemstone("6260a56106c9ae5557a12d5cc291591f2eaf2677012d3beec58d458ddb92aeb9"),
    Refined_Gemstone_1("a772b3882e154c22588e801dfaf02937897c889e99ef0d92d8f5bfa3902ceb60");



    private String URL;

    Heads(String URL) {
        this.URL = URL;

    }

    public String getURL() {
        return "http://textures.minecraft.net/texture/" + URL;
    }
}
