module waterworld {
    requires hanyaeger.api;

    exports com.github.hanyaeger.tutorial;

    opens audio;
    opens backgrounds;
    opens sprites;
}
