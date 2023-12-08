package com.app.wow.car.rental.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "prs_employeeLoginTable")
@Data
@IdClass(LoginIdClass.class)
public class EmployeeLogin {


    @Id
    private String username;
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private PrsLogin prsLogin;

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "locationid")
    private Office prsOfficeLocation;
}
