package com.pallaw.tmassignment.UI.Gallary;

/**
 * Created by Pallaw Pathak on 2019-06-18. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public enum DisplayMode {

    LIST(1),
    GRID(2),
    CAROUSEL(3);

    private int displayMode;

    DisplayMode(int displayMode) {

        this.displayMode = displayMode;
    }

    @Override
    public String toString() {
        return String.valueOf(displayMode);
    }

}
