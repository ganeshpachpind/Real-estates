package scout24.realestate.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Estate {
    private int id;
    private String title;
    private int price;
    private Location location;
    private List<Image> images;

    public Estate() {
    }

    public Estate(int id, String title, int price, Location location, List<Image> images) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.location = location;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public Location getLocation() {
        return location;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
