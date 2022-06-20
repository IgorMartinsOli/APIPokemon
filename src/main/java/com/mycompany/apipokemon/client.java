/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.apipokemon;
import com.mycompany.apipokemon.Model.Pokemon;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author igor_
 */
public class client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pokemonAPI-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Pokemon pokemon = entityManager.find(Pokemon.class, 1);
        System.out.println(pokemon.getName());
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
