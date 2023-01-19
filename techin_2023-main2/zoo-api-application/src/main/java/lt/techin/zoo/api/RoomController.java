package lt.techin.zoo.api;

import lt.techin.zoo.api.dto.AnimalDto;
import lt.techin.zoo.api.dto.RoomDto;
import lt.techin.zoo.api.dto.RoomEntityDto;
import lt.techin.zoo.api.dto.mapper.RoomMapper;
import lt.techin.zoo.model.RoomType;
import lt.techin.zoo.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.zoo.api.dto.mapper.AnimalMapper.toAnimal;
import static lt.techin.zoo.api.dto.mapper.AnimalMapper.toAnimalDto;
import static lt.techin.zoo.api.dto.mapper.RoomMapper.*;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/rooms")
@Validated
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    @ResponseBody
    public List<RoomEntityDto> getRooms() {
        return roomService.getAll().stream()
                .map(RoomMapper::toRoomEntityDto)
                .collect(toList());

    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomEntityDto> getRoom(@PathVariable Long roomId) {
        var roomOptional = roomService.getById(roomId);

        var responseEntity = roomOptional
                .map(room -> ok(toRoomEntityDto(room)))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId) {
        var roomDeleted = roomService.deleteById(roomId);

        if (roomDeleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RoomDto> createRoom(@Valid @RequestBody RoomDto roomDto) {
        var createdRoom = roomService.create(toRoom(roomDto));

        return ok(toRoomDto(createdRoom));
    }

    @PatchMapping("/{roomId}")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long roomId, @RequestBody RoomDto roomDto) {
        var updatedRoom = roomService.update(roomId, toRoom(roomDto));

        return ok(toRoomDto(updatedRoom));
    }
    @PutMapping("/{roomId}")
    public ResponseEntity<RoomDto> replaceRoom(@PathVariable Long animalId, @RequestBody RoomDto roomDto) {
        var updatedRoom = roomService.replace(animalId, toRoom(roomDto));

        return ok(toRoomDto(updatedRoom));
    }

    @GetMapping("/custom")
    public ResponseEntity<String> executeCustom(@RequestParam String input) {
        var result = roomService.executeSpringDataNamedMethod(input);
        return ok(result);
    }

    @GetMapping("/type/top")
    public ResponseEntity<List<RoomDto>> findLatestByType(@RequestParam RoomType type) {
        var result = roomService.findByType(type).stream()
                .map(RoomMapper::toRoomDto)
                .collect(toList());

        return ok(result);
    }
    @GetMapping("/search")
    @ResponseBody
    public List<RoomEntityDto> findRoomsPaged(@RequestParam(required = false) String name, @RequestParam(required = false) RoomType type,
                                              @RequestParam int page, @RequestParam int pageSize) {
        return roomService.findByExample(name, type, page, pageSize).stream()
                .map(RoomMapper::toRoomEntityDto)
                .collect(toList());
    }
}
