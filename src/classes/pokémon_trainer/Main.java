package classes.pokémon_trainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        while(!"Tournament".equals(command)) {
            String[] pokemonValues = command.split("\\s+");
            String trainerName = pokemonValues[0];
            String pokemonName = pokemonValues[1];
            String pokemonElement = pokemonValues[2];
            Integer pokemonHealth = Integer.parseInt(pokemonValues[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if(trainers.containsKey(trainerName)) {
                trainers.get(trainerName).getPokemons().add(pokemon);
            } else {
                Trainer trainer = new Trainer(trainerName);
                trainer.getPokemons().add(pokemon);
                trainers.put(trainerName, trainer);
            }
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while(!"End".equals(command)) {
            if(command.equals("Fire") || command.equals("Water") || command.equals("Electricity")) {
                for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
//                    entry.getValue().checkForPokemon(command);
                    entry.getValue().applyCommand(command);
                }
            }
            command = scanner.nextLine();
        }
//        trainers.entrySet().stream().sorted((t1, t2) -> Integer.compare(t2.getValue().getNumberOfBadgets(), t1.getValue().getNumberOfBadgets()))
//        .forEach(item -> System.out.println(item.getValue()));
        trainers.values().stream().sorted(Comparator.comparing(Trainer::getNumberOfBadgets).reversed())
       .forEach(System.out::println);
    }
}
