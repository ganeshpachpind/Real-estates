package scout24.realestate.model;


public class Estate {
    private final int id;
    private final String title;
    private final int price;
    private final Location location;

    public Estate(int id, String title, int price, Location location) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.location = location;
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
}
