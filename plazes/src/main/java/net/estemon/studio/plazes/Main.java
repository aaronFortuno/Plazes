package net.estemon.studio.plazes;

class Main {

    public static void main(String[] args) {
        Place place = new Place("EPSG",
                "C. Paranimf, 1 46730 Gandia (SPAIN)",
                -0.166093,
                38.995656,
                962849300,
                "http://www.epsg.upv.es",
                "A place to learn",
                3);
        System.out.println("Place " + place);
    }
}
