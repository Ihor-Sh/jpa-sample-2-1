package ua.kiev.prog.sample2;

import javax.persistence.*;

@Entity
@Table(name="Clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name", nullable = false)
    private String name;
    private int age;

    // в таблиці "Clients" СТВОРЮЄТСЯ колонка (group_id) є FK
    // силаєтькя на таблицю "Groups"(id)-групи-id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id") //Clients(group_id) FK for "Groups"(id)
    private Group group;

    public Client() {}

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
