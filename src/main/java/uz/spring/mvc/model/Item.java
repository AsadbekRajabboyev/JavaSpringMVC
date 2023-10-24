package uz.spring.mvc.model;

public class Item {
    private int id;
    private String name;
    private int price;
    private String type;
    private String srok;

    public Item() {
    }

    public Item(String name, int price, String type, String  srok) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.srok = srok;
    }

    public Item(int id, String name, int price, String type, String  srok) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.srok = srok;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String  getSrok() {
        return srok;
    }

    public void setSrok(String  srok) {
        this.srok = srok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
