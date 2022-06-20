/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apipokemon.utils;

import java.io.Serializable;

/**
 *
 * @author igor_
 * //TODO: talvez preciso tirar esse parametro
 * @param <ID>
 */
public interface Model<ID extends Serializable> extends Serializable {
    ID getId();
}
