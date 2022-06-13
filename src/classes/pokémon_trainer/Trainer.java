package classes.pokémon_trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int numberOfBadgets;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadgets = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadgets() {
        return numberOfBadgets;
    }

    public void setNumberOfBadgets(int numberOfBadgets) {
        this.numberOfBadgets = numberOfBadgets;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    private List<Pokemon> pokemons;

    public void checkForPokemon(String element) {
        boolean haveTrainerPokemonWithELement = false;
        for (Pokemon pokemon : pokemons) {
            if(pokemon.getElement().equals(element)) {
                haveTrainerPokemonWithELement = true;
                numberOfBadgets++;
            }
        }
        if(!haveTrainerPokemonWithELement) {
            attackPokemons();
        }
    }

    private void attackPokemons() {
        for (Pokemon pokemon : pokemons) {
            pokemon.setHealth(pokemon.getHealth() - 10);
        }
      pokemons.removeIf(pokemon->pokemon.getHealth() <= 0 );
    }

    @Override
    public String toString() {
        return name + " " + numberOfBadgets + " " + pokemons.size();
    }


    public boolean hasElement(String element) {
        return this.pokemons.stream().anyMatch(s -> s.getElement().equals(element));
    }

    public void applyCommand(String element) {
        if(hasElement(element)) {
            this.numberOfBadgets++;
        } else {
            this.pokemons.forEach(Pokemon::looseHealth);
            this.pokemons.removeIf(Pokemon::isDead);
        }
    }
}
