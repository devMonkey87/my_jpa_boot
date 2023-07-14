package com.example.postgresdemo.controller;

import com.example.postgresdemo.dto.PokemonDTO;
import com.example.postgresdemo.mapper.PokemonMapper;
import com.example.postgresdemo.model.Pokemon;
import com.example.postgresdemo.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@AllArgsConstructor
public class PokemonController {
    private PokemonService pokemonService;
    private PokemonMapper mapper;

    @GetMapping("/pokemons")
    public List<PokemonDTO> getAllPokemons() {
        return pokemonService.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/pokemons/{id}")
    public PokemonDTO getPokemonById(@PathVariable int id) {
        Pokemon pokemon = pokemonService.findById(id);
        return mapper.toDto(pokemon);
    }


    @PostMapping("/pokemons")
    public PokemonDTO addAnswer(@Valid @RequestBody Pokemon pokemon) {
        Pokemon savedPokemon = pokemonService.saveOrUpdate(pokemon);
        return mapper.toDto(savedPokemon);
    }

    @PutMapping("/pokemons/{id}")
    public PokemonDTO updateAnswer(@PathVariable int id, @Valid @RequestBody Pokemon pokemon) {
        return mapper.toDto(pokemonService.saveOrUpdate(pokemon));
    }

    @DeleteMapping("/pokemons/{id}")
    public ResponseEntity<Integer> deleteAnswer(@PathVariable Integer id) {
        pokemonService.deleteById(id);
        return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);

    }
}
