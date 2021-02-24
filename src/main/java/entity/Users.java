package entity;


import javax.persistence.*;
import java.util.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private int drfo;
    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BankAccount> list;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, List<BankAccount> list) {
        this.username = username;
        this.list = list;
    }

    public Users(String username, int drfo) {
        this.username = username;
        this.drfo = drfo;
    }


    public int getDrfo() {
        return drfo;
    }

    public void setDrfo(int drfo) {
        this.drfo = drfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<BankAccount> getList() {
        return list;
    }

    public void setList(List<BankAccount> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", list=" + list +
                '}';
    }
}


