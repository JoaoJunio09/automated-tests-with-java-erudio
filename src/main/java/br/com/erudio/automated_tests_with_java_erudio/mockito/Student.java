package br.com.erudio.automated_tests_with_java_erudio.mockito;

public class Student {

    private long id;
    private String name;
    private int age;
    private String token;

    public Student() {}

    public Student(long id, String name, int age, String token) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
