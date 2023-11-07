package uz.spring.mvc.model;

import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "Ism bosh kiritildi")
    @Size(min = 2, max = 20, message = "Ism 2tdan kop 20dan kam bolishi kerak ")
    private String name;
    @Min(value = 0, message = " 0dan katta yosh kriiting")
    @Max(value = 100, message = "Dinozavr")
    private int age;
    @Email(message = "togri email kiriting")
    private String email;
    private String phone;


    public Person(int id, String name, int age, String email, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }


    public Person() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
