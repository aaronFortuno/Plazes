package net.estemon.studio.plazes;

class Main {

    public static void main(String[] args) {
        Places places = new PlacesList();
        for (int i = 0 ; i < places.size() ; i++) {
            System.out.println(places.place(i).toString());
        }
    }
}
