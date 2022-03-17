module waterworld {
    requires hanyaeger;

    exports com.github.hanyaeger.tutorial;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports com.github.hanyaeger.tutorial.tutorial.entities.map;
//    exports com.github.hanyaeger;
//    opens TitleScene;
}
