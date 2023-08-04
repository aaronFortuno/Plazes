package net.estemon.studio.plazes;

public interface Places {

    Place place(int id);

    void addPlace(Place place); // Add the given place
    int newPlace(); // Create a new blank place and returns its id
    void deletePlace(int id); // Deletes the place with given id
    int size(); // Returns the number of elements

    void updatePlace(int id, Place place); // Replace a place given its id
}
