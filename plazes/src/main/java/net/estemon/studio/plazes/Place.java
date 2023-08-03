package net.estemon.studio.plazes;

public class Place {
    private String name;
    private String address;
    private GeoPoint pos;
    private String photo;
    private int phone;
    private String url;
    private String comment;
    private long date;
    private float score;
    private PlaceType type;

    public Place(String name, String address, double longitude, double latitude, PlaceType type, int phone, String url, String comment, int score) {
        pos = new GeoPoint(longitude, latitude);
        date = System.currentTimeMillis();
        this.name = name;
        this.address = address;
        this.type = type;
        this.photo = photo;
        this.phone = phone;
        this.url = url;
        this.comment = comment;
        this.score = score;
    }

    public Place() {
        date = System.currentTimeMillis();
        pos = new GeoPoint(0, 0);
        type = PlaceType.OTHER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GeoPoint getPos() {
        return pos;
    }

    public void setPos(GeoPoint pos) {
        this.pos = pos;
    }

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pos=" + pos +
                ", photo='" + photo + '\'' +
                ", phone=" + phone +
                ", url='" + url + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", score=" + score +
                ", type=" + type +
                '}';
    }
}