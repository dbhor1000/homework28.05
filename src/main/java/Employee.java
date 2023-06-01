//**Требования к Entity:**
//
//        - Entity класс должен быть помечен аннотацией @Entity или описан в XML-файле конфигурации JPA.
//        - Entity класс должен содержать публичный конструктор без параметров (может иметь дополнительно конструкторы с аргументами).
//        - Entity класс должен быть классом верхнего уровня.
//        - Перечисление или интерфейс не могут быть определены как сущность (Entity).
//        - Entity класс не может быть финальным. Entity класс не может содержать финальные поля или методы, если они участвуют в маппинге (являются элементами таблицы БД).
//        - Как обычный так и абстрактный класс может быть Entity. Entity могут наследоваться как от не Entity классов, так и от Entity классов. А не Entity классы могут наследоваться от Entity классов.
//        - Поля Entity классов должны быть объявлены как private, protected или default.
//        - Entity класс должен содержать первичный ключ, то есть атрибут или группу атрибутов, которые уникально определяют запись этого Entity класса в базе данных.

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "city_id")
    private Integer cityId;
    @ManyToOne()
    @JoinColumn(name="city_id", nullable=false, insertable = false, updatable = false)
    private City city;



    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String gender, int age, int cityId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", cityId=" + cityId +
                ", city=" + city +
                '}';
    }
}
