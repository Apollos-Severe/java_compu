package com.example.java_compu.Users;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")

    private Long id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String address_1;
    private String address_2;
    private String city;
    private String state;
    private String zipcode;
    private LocalDate dob;
    private Boolean isAdmin;

    @Transient
    private Integer age;

    public Users() {
    }

    public Users(Long id, String username, String password, String first_name, String last_name, String email,
            String phone, String address_1, String address_2, String city, String state, String zipcode, LocalDate dob,
            Boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.dob = dob;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress_1() {
        return this.address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return this.address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Boolean isIsAdmin() {
        return this.isAdmin;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Users id(Long id) {
        setId(id);
        return this;
    }

    public Users username(String username) {
        setUsername(username);
        return this;
    }

    public Users password(String password) {
        setPassword(password);
        return this;
    }

    public Users first_name(String first_name) {
        setFirst_name(first_name);
        return this;
    }

    public Users last_name(String last_name) {
        setLast_name(last_name);
        return this;
    }

    public Users email(String email) {
        setEmail(email);
        return this;
    }

    public Users phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Users address_1(String address_1) {
        setAddress_1(address_1);
        return this;
    }

    public Users address_2(String address_2) {
        setAddress_2(address_2);
        return this;
    }

    public Users city(String city) {
        setCity(city);
        return this;
    }

    public Users state(String state) {
        setState(state);
        return this;
    }

    public Users zipcode(String zipcode) {
        setZipcode(zipcode);
        return this;
    }

    public Users dob(LocalDate dob) {
        setDob(dob);
        return this;
    }

    public Users isAdmin(Boolean isAdmin) {
        setIsAdmin(isAdmin);
        return this;
    }

    public Users age(Integer age) {
        setAge(age);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Users)) {
            return false;
        }
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(username, users.username)
                && Objects.equals(password, users.password) && Objects.equals(first_name, users.first_name)
                && Objects.equals(last_name, users.last_name) && Objects.equals(email, users.email)
                && Objects.equals(phone, users.phone) && Objects.equals(address_1, users.address_1)
                && Objects.equals(address_2, users.address_2) && Objects.equals(city, users.city)
                && Objects.equals(state, users.state) && Objects.equals(zipcode, users.zipcode)
                && Objects.equals(dob, users.dob) && Objects.equals(isAdmin, users.isAdmin)
                && Objects.equals(age, users.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, first_name, last_name, email, phone, address_1, address_2, city,
                state, zipcode, dob, isAdmin, age);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", username='" + getUsername() + "'" + ", password='" + getPassword()
                + "'" + ", first_name='" + getFirst_name() + "'" + ", last_name='" + getLast_name() + "'" + ", email='"
                + getEmail() + "'" + ", phone='" + getPhone() + "'" + ", address_1='" + getAddress_1() + "'"
                + ", address_2='" + getAddress_2() + "'" + ", city='" + getCity() + "'" + ", state='" + getState() + "'"
                + ", zipcode='" + getZipcode() + "'" + ", dob='" + getDob() + "'" + ", isAdmin='" + isIsAdmin() + "'"
                + ", age='" + getAge() + "'" + "}";
    }

}
