package uz.spring.mvc.tashkilotApp.model;

public class Bolim {
    private int id;
    private String name;
    private int workerCount;

    public Bolim() {
    }

    public Bolim(String name, int workerCount) {
        this.name = name;
        this.workerCount = workerCount;
    }

    public Bolim(int id, String name, int workerCount) {
        this.id = id;
        this.name = name;
        this.workerCount = workerCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }
}
