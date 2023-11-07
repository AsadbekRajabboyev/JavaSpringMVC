package uz.spring.mvc.tashkilotApp.model;

public class Ishchi {
    private int id;
    private String name;

    private String surname;
    private String phone;
    private String passport;
    private String address;
    private int salary;

    public Ishchi(int id, String name, String surname, String phone, String passport, String address, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passport = passport;
        this.address = address;
        this.salary = salary;
    }

    public Ishchi() {
    }

    public Ishchi(String name, String surname, String phone, String passport, String address, int salary) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passport = passport;
        this.address = address;
        this.salary = salary;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
