package com.udacity.jdnd.course3.critter.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by Brian Smith on 10/4/21.
 * Description: User entity to reuse fields for customers and employees
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name="user")
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nationalized
    private String name;

    public User(String name){
        this.name = name;
    }
}
