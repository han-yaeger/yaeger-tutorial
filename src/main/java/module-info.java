module waterworld {
    requires hanyaeger.api;

    exports com.github.hanyaeger.tutorial;
    exports com.github.hanyaeger.tutorial.entities.game.tilemaps.entities;
    opens audio;
    opens backgrounds;
    opens sprites;
}
