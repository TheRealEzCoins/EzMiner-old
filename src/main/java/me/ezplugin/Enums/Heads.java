package me.ezplugin.Enums;

public enum Heads {
    Gemstone("6260a56106c9ae5557a12d5cc291591f2eaf2677012d3beec58d458ddb92aeb9"),
    Refined_Gemstone("a772b3882e154c22588e801dfaf02937897c889e99ef0d92d8f5bfa3902ceb60"),
    Polished_Gemstone("7f92605eea46ea8488efc26b3f9fc99551705e9c0b5ebb2ff898468f277595a6"),
    Perfect_Gemstone("6a89b5236323d8f576e71cb4a12f28814dd32229479b9765dea710df6e391048"),
    Gemstone_Pot("9fd5f5a6cc552d237f7443f50b97b2ec033094cc08c59422b969f7a7e7048e06");



    private String URL;

    Heads(String URL) {
        this.URL = URL;

    }

    public String getURL() {
        return "http://textures.minecraft.net/texture/" + URL;
    }
}
