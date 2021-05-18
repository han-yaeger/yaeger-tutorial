module waterworld {
    requires hanyaeger;

    exports com.github.hanyaeger.tutorial;
    exports com.github.hanyaeger.tutorial.entities.map;

    opens audio;
    opens backgrounds;
    opens sprites;
}
