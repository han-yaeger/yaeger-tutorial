module waterworld {
    requires hanyaeger;

    exports com.github.hanyaeger.tutorial;
    exports com.github.hanyaeger.tutorial.settings;
    exports com.github.hanyaeger.tutorial.scenes;
    exports com.github.hanyaeger.tutorial.entities;
    exports com.github.hanyaeger.tutorial.entities.buttons;
    exports com.github.hanyaeger.tutorial.entities.text;
    exports com.github.hanyaeger.tutorial.entities.swordfish;

    opens audio;
    opens backgrounds;
    opens sprites;
}
