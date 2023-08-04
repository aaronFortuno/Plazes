package net.estemon.studio.plazes;

public enum PlaceType {

    OTHER ("Other", R.drawable.ic_other),
    RESTAURANT ("Restaurant", R.drawable.ic_restaurant),
    BAR ("Bar", R.drawable.ic_bar),
    DRINKING ("Drinking", R.drawable.ic_drinking),
    SHOW ("Show", R.drawable.ic_show),
    HOTEL ("Hotel", R.drawable.ic_hotel),
    SHOPPING ("Shopping", R.drawable.ic_shopping),
    EDUCATION ("Education", R.drawable.ic_education),
    SPORTS ("Sports", R.drawable.ic_sports),
    NATURE ("Nature", R.drawable.ic_nature),
    GAS_STATION ("Gas station", R.drawable.ic_gas_station);

    private final String text;
    private final int resource;

    PlaceType(String text, int resource) {
        this.text = text;
        this.resource = resource;
    }

    public String getText() { return text; }
    public int getResource() { return resource; }
}
