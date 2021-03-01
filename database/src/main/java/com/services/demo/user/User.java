package com.services.demo.user;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Table(name="users") //user ist ein geblockter Name in Postgres deswegen auf users umändern
@Entity
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sq",
            sequenceName =  "user_sq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sq"
    )
    private Long ID;

    private LocalDate creationDate;
    private String userName;
    @Transient
    private Long age_of_account;

    public User(Long ID, LocalDate creationDate, String userName) {
        this.ID = ID;
        this.creationDate = creationDate;
        this.userName = userName;
    }

    public User(LocalDate creationDate, String userName) {
        this.creationDate = creationDate;
        this.userName = userName;
    }

    public User(String userName) {
        this.creationDate = LocalDate.now();
        this.userName = userName;
    }

    public User() {
        this.creationDate = LocalDate.now();
    }

    public Long getID() {
        return ID;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getUserName() {
        return userName;
    }

    public long getAgeofaccount() { return Period.between(this.creationDate, LocalDate.now()).getYears();}

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge_of_account(Long age_of_account) { this.age_of_account = age_of_account; }


    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", creationDate=" + creationDate +
                ", userName='" + userName + '\'' +
                ", age_of_account=" + getAgeofaccount() +
                '}';
    }
}
