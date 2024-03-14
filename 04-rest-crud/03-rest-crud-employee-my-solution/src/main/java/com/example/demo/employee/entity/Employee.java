package com.example.demo.employee.entity;

import jakarta.persistence.*;

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

    @Column(name = "email")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder {
        private String _firstName;
        private String _lastName;
        private String _email;

        public Builder firstName(String firstName) {
            this._firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this._lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this._email = email;
            return this;
        }

        public Employee build() {
            var employee = new Employee();
            employee.setFirstName(this._firstName);
            employee.setLastName(this._lastName);
            employee.setEmail(this._email);

            return employee;
        }
    }
}
