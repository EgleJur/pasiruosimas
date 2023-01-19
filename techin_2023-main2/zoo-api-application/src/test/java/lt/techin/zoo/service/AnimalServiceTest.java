package lt.techin.zoo.service;

import lt.techin.zoo.dao.AnimalRepository;
import lt.techin.zoo.exception.ZooValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static lt.techin.zoo.stubs.AnimalCreator.createAnimal;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    @Mock
    AnimalRepository animalRepository;

    @InjectMocks
    AnimalService animalService;

    @Test
    void update_animalNotFound_throwsException() {
        var animal = createAnimal(1l);

        when(animalRepository.findById(1l)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> animalService.update(1l, animal))
                .isInstanceOf(ZooValidationException.class)
                .hasMessageContaining("Animal does not exist")
                .hasFieldOrPropertyWithValue("rejectedValue", "1");
    }

}