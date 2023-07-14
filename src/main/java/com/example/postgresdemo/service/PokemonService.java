package com.example.postgresdemo.service;

import com.example.postgresdemo.model.Pokemon;

import java.util.List;

public interface PokemonService {

    Pokemon findById(int id);

    List<Pokemon> findAll();

    Pokemon saveOrUpdate(Pokemon pokemon);

    void deleteById(int id);


}
