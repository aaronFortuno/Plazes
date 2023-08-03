package net.estemon.studio.plazes;

public class GeoPoint {

    private double lontigude, latitude;

    public GeoPoint(double lontigude, double latitude) {
        this.lontigude = lontigude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "GeoPoint{" +
                "lontigude=" + lontigude +
                ", latitude=" + latitude +
                '}';
    }

    /**
     * Calculates the distance between this GeoPoint and another GeoPoint using the Haversine formula.
     * The Haversine formula is used to calculate the great-circle distance between two points on the Earth's surface,
     * assuming a spherical Earth with a fixed radius.
     *
     * @param point The other GeoPoint to which the distance is to be calculated.
     * @return The distance in meters between this GeoPoint and the specified GeoPoint.
     */
    public double distance(GeoPoint point) {
        // The Earth's radius in meters
        final double EARTH_RADIUS = 6371000;

        // Convert latitude and longitude differences to radians
        double dLat = Math.toRadians(latitude - point.latitude);
        double dLon = Math.toRadians(lontigude - point.lontigude);

        // Convert latitude values to radians
        double lat1 = Math.toRadians(point.latitude);
        double lat2 = Math.toRadians(latitude);

        // Haversine formula to calculate the distance
        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.sin(dLon / 2) * Math.sin(dLon / 2) *
                Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate and return the distance
        return c * EARTH_RADIUS;
    }

    public double getLontigude() {
        return lontigude;
    }

    public void setLontigude(double lontigude) {
        this.lontigude = lontigude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
