package com.example.mensaapi.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "menus")
@NoArgsConstructor
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "canteen_id")
    @JsonBackReference
    private Canteen canteen;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "meal_id")
    @JsonBackReference
    private Meal meal;

    private LocalDate date;

    public Menu(Canteen canteen, Meal meal, LocalDate date) {
        this.canteen = canteen;
        this.meal = meal;
        this.date = date;
    }

    public Menu(Canteen canteen, LocalDate date){
        this.canteen = canteen;
        this.date = date;
    }
}