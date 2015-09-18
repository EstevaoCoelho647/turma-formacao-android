package br.com.cast.turmaformacao.taskmanager.model.entities;

/**
 * Created by Administrador on 17/09/2015.
 */
public enum Color {

    PINK(" #e91e63"),
    RED("#f44336"),
    PURPLE(" #9c27b0"),
    DEEP_PURPLE(" #673ab7"),
    INDIGO("#3f51b5"),
    BLUE(" #2196f3"),
    LIGHT_BLUE(" #03a9f4"),
    CYAN(" #00bcd4"),
    TEAL(" #009688"),
    GREEN(" #4caf50"),
    LIGHT_GREEN(" #4caf50"),
    LIME(" #cddc39"),
    YELLOW(" #ffeb3b"),
    AMBER(" #ffc107"),
    ORANGE(" #ff9800"),
    DEEP_ORANGE(" #ff5722"),
    BROWN(" #795548"),
    GREY(" #9e9e9e"),
    BLUE_GRAY(" #607d8b"),
    BLACK("#000000"),
    WHITE("#ffffff");


    private String hex;

    private Color(String hex) {
        this.hex = hex;
    }

    public String getHex() {
        return hex;
    }

}
