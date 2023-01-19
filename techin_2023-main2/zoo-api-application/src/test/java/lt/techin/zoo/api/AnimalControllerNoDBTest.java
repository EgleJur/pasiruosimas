package lt.techin.zoo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.zoo.dao.AnimalRepository;
import lt.techin.zoo.dao.RoomRepository;
import lt.techin.zoo.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@MockBeans({@MockBean(RoomController.class), @MockBean(RoomService.class), @MockBean(RoomRepository.class)})
@AutoConfigureMockMvc
class AnimalControllerNoDBTest {

    @MockBean
    AnimalRepository animalRepository;

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @Test
    void updateAnimal_callsDbMethod() throws Exception {
        when(animalRepository.deleteNonRegisteredAnimals()).thenReturn(3);

        var mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/v1/animals/registry/clear")
                )
                .andExpect(status().isOk())
                .andReturn();

        var mappedResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Integer.class);

        assertThat(mappedResponse)
                .isEqualTo(3);
    }

}