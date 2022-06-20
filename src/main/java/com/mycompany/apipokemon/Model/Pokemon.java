/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apipokemon.Model;
import com.mycompany.apipokemon.utils.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author igor_
 */
@Entity
@Table(name = "pokemonapi")
public class Pokemon implements Model<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int num;
    private String name;
    private String type;
    private int pre_evolution;
    private int next_evolution;

    @Override
    public Long getId() {
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPre_evolution() {
        return pre_evolution;
    }

    public void setPre_evolution(int pre_evolution) {
        this.pre_evolution = pre_evolution;
    }

    public int getNext_evolution() {
        return next_evolution;
    }

    public void setNext_evolution(int next_evolution) {
        this.next_evolution = next_evolution;
    }
}