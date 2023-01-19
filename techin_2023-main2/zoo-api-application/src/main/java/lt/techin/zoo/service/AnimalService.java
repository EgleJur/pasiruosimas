package lt.techin.zoo.service;

import lt.techin.zoo.api.dto.AnimalDto;
import lt.techin.zoo.api.dto.mapper.AnimalMapper;
import lt.techin.zoo.dao.AnimalRepository;
import lt.techin.zoo.dao.RoomRepository;
import lt.techin.zoo.exception.ZooValidationException;
import lt.techin.zoo.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static lt.techin.zoo.api.dto.mapper.AnimalMapper.toAnimal;
import static lt.techin.zoo.model.AnimalType.*;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final RoomRepository roomRepository;

    @Autowired //jeigu nenurodytume Spring'as (nuo 4.3 versijos) pridetu vieninteliam managed Bean klases konstruktoriuj @Autowired automatiskai
    public AnimalService(AnimalRepository animalRepository, RoomRepository roomRepository) {
        this.animalRepository = animalRepository;
        this.roomRepository = roomRepository;
    }

    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getById(Long id) {
        return animalRepository.findById(id);
    }


    public Animal create(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal update(Long id, Animal animal) {
        var existingAnimal = animalRepository.findById(id)
                .orElseThrow(() -> new ZooValidationException("Animal does not exist",
                        "id", "Animal not found", id.toString()));

        existingAnimal.setName(animal.getName());
        existingAnimal.setType(animal.getType());
        existingAnimal.setDescription(animal.getDescription());

        return animalRepository.save(existingAnimal);
    }

    public Animal replace(Long id, Animal animal) {
        animal.setId(id);

        return animalRepository.save(animal);
    }

    public boolean deleteById(Long id) {
        try {
            animalRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public List<Animal> findMarkedAnimals() {
        return animalRepository.findAllMarkedAnimals();
    }

    @Transactional
    public int deleteNonRegistered() {
        return animalRepository.deleteNonRegisteredAnimals();
    }

    public Animal addRoomToAnimal(Long animalId, Long roomId) {
        // - find animal
        var existingAnimal = animalRepository.findById(animalId)
                .orElseThrow(() -> new ZooValidationException("Animal does not exist",
                        "id", "Animal not found", animalId.toString()));

        // - find room
        var existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new ZooValidationException("Room does not exist",
                        "id", "Room not found", roomId.toString()));

        // - if OK - set
        existingAnimal.setRoom(existingRoom);

        return animalRepository.save(existingAnimal);
    }

}
