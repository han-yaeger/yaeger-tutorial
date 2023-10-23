module waterworld {
    requires hanyaeger;

    exports com.github.hanyaeger.FishingSimulator;

    opens audio;
    opens backgrounds;
    opens sprites;
}
