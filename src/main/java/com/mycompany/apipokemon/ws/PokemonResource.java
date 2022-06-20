/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apipokemon.ws;
import com.mycompany.apipokemon.Model.Pokemon;
import com.mycompany.apipokemon.service.PokemonService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Named
@Path("pokemon")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PokemonResource{
    
    @Inject
    private PokemonService pokemonService;

    @GET
    @Path("pokemons")
    public List<Pokemon> listarPokemons() {
        return pokemonService.findAll();
    }

    @GET
    @Path("buscar/{codigo}")
    public Pokemon listarPokemon(@PathParam("codigo") Long codigo) {
        return pokemonService.findById(codigo);
    }
    
    
    //Método POST "pokemon", insere um novo pokemon com os dados do pokemon informados no body da requisição;
    @POST
    @Path("pokemon")
    public Response save(Pokemon pokemon) {
        try {
            pokemonService.save(pokemon);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Instabilidade no serviço").build();
        }
    }
    
    @PUT
    @Path("update")
    public Response update(Pokemon pokemon){
        try{
            pokemonService.update(pokemon);
            return Response.ok().build();
        } catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).entity("Não foi possivel fazer o update").build();
        }
    }
  }