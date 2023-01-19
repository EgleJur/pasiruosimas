package lt.techin.zoo.stubs;

import lt.techin.zoo.model.Animal;
import lt.techin.zoo.model.AnimalType;

public class AnimalCreator {

    public static Animal createAnimal(Long id) {
        var animal = new Animal();

        animal.setId(id);
        animal.setName("Lion");
        animal.setType(AnimalType.LION);

        return animal;
    }
}
