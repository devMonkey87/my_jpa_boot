package com.example.postgresdemo.service.impl;

import com.example.postgresdemo.model.Pokemon;
import com.example.postgresdemo.repository.PokemonRepository;
import com.example.postgresdemo.service.PokemonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Pokemon findById(int id) {
        return pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon not found"));
    }

    @Override
    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon saveOrUpdate(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public void deleteById(int id) {
        pokemonRepository.deleteById(id);
    }
}
