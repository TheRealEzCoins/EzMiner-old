package me.ezplugin.Enums;

public enum Heads {
    Nacrine("fa3bcc8c18fc3e4aa6b7b7d5c1b3632ecdb72eb62046e8cf83762319dd6cdf3e"),
    Uprum("b94181802c19e2812f53f56cf349f5dda27e6d0b0139da49c70cbe27bf8e0a"),
    Zaplium("5b34b4896e434ec4ef1669d6343b6da06cd830dc92927d61e3d883017683c422"),
    Slaginite("9115dc88e3214c38243d782d63edb0a6e06291eb6da8e600c7e2ea36e7f61b31"),
    Gryrium("7a8b87e46cfe8a2dc3525c1c67d8a69a25fd0a7f724a6fa911ad74adb6d82c2"),
    Kreisium("72ebea17c3235637a744887380609e38fae748a269c6758dd096986f2ab9f814"),
    Volcanium("8dcff1acc12f16d44aee1f7e84414cb2e8ea7eb4642e7d292d76f1c17b4b434a"),
    Flotine("d2e4ffc71c9fd445da6f25f78034106897a9aaaced539cf1cfbee4dcb98ac3f9"),
    Spawner_fragments("b8444224af2cd4a5d3909db772c7d0c95b1216c3ac019f4a0e7cdbb8f07f418f"),



    Gemstone("6260a56106c9ae5557a12d5cc291591f2eaf2677012d3beec58d458ddb92aeb9"),
    Refined_Gemstone("a772b3882e154c22588e801dfaf02937897c889e99ef0d92d8f5bfa3902ceb60"),
    Polished_Gemstone("7f92605eea46ea8488efc26b3f9fc99551705e9c0b5ebb2ff898468f277595a6"),
    Perfect_Gemstone("6a89b5236323d8f576e71cb4a12f28814dd32229479b9765dea710df6e391048"),
    Fortune("b73579575ca88b3a8afe1ed18907b3125fe0987b02a88ef0e8a01087c3d024c4"),

    Shop("91be4b5b592fee21a65e0f903038c5333be388234a43731d4adfe5d57d3644e5"),
    Ores("6c7628e897cb4c9312f802f28c2ec466d7e721ec37010378cc45dd2dc68810c3"),
    Materials("692d5df805c239022fe1b45f940882bf40b559671937dc71fbc96f630250ebc4"),
    Gemstone_Pot("9fd5f5a6cc552d237f7443f50b97b2ec033094cc08c59422b969f7a7e7048e06");



    private String URL;

    Heads(String URL) {
        this.URL = URL;

    }

    public String getURL() {
        return "http://textures.minecraft.net/texture/" + URL;
    }
}
