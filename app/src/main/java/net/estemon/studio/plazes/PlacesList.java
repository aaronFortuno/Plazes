package net.estemon.studio.plazes;

import java.util.ArrayList;
import java.util.List;

public class PlacesList implements Places {

    protected List<Place> placeList = examplePlaces();

    public PlacesList() {
        placeList = examplePlaces();
    }

    @Override
    public Place place(int id) {
        return placeList.get(id);
    }

    @Override
    public void addPlace(Place place) {
        placeList.add(place);
    }

    @Override
    public int newPlace() {
        Place place = new Place();
        placeList.add(place);
        return placeList.size() - 1;
    }

    @Override
    public void deletePlace(int id) {
        placeList.remove(id);
    }

    @Override
    public int size() {
        return placeList.size();
    }

    @Override
    public void updatePlace(int id, Place place) {
        placeList.set(id, place);
    }

    public static ArrayList<Place> examplePlaces() {
        ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(
                "EPSG",
                "C. Paranimf, 1 46730 Gandia (SPAIN)",
                -0.166093,
                38.995656,
                PlaceType.EDUCATION,
                962849300,
                "http://www.epsg.upv.es",
                "A place to learn",
                3)
        );
        places.add(new Place(
                "Home",
                "C. Potato 12, 12121 Soria (RUSSIA)",
                0.352422,
                37.125238,
                PlaceType.OTHER,
                919191919,
                "http://www.myhome.com",
                "A place to stay",
                5)
        );
        return places;
    }
}
