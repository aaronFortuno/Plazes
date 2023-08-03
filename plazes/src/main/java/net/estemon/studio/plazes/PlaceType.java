package net.estemon.studio.plazes;

public enum PlaceType {

    OTHER ("Other", 5),
    RESTAURANT ("Restaurant", 2),
    BAR ("Bar", 6),
    DRINKING ("Drinking", 0),
    SHOW ("Show", 0),
    HOTEL ("Hotel", 0),
    SHOPPING ("Shopping", 0),
    EDUCATION ("Education", 0),
    SPORTS ("Sports", 0),
    NATURE ("Nature", 0),
    GAS_STATION ("Gas station", 0);

    private final String text;
    private final int resource;

    PlaceType(String text, int resource) {
        this.text = text;
        this.resource = resource;
    }

    public String getText() { return text; }
    public int getResource() { return resource; }
}
