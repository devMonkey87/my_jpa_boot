package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Pokemon;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends GenericRepository<Pokemon, Integer> {

}
