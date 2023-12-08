package com.app.wow.car.rental.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prs_login")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrsLogin {

    @Id
    private String username;

    private String password;


    @Column(name = "login_type", columnDefinition = "enum('CL','EL')")
    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    public enum LoginType {
        CL, EL
    }

}
