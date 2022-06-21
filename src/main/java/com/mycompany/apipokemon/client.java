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
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pokemonAPI-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        Pokemon pokemon = entityManager.find(Pokemon.class, 1);
        entityManager.getTransaction().commit();
        System.out.println(pokemon.getName());
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
