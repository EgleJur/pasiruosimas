package lt.techin.zoo.api.dto.mapper;

import lt.techin.zoo.api.dto.RoomDto;
import lt.techin.zoo.api.dto.RoomEntityDto;
import lt.techin.zoo.model.Room;

public class RoomMapper {

    public static RoomDto toRoomDto(Room room) {
        var roomDto = new RoomDto();

        roomDto.setName(room.getName());
        roomDto.setType(room.getType());
        roomDto.setDescription(room.getDescription());

        return roomDto;
    }

    public static Room toRoom(RoomDto roomDto) {
        var room = new Room();

        room.setName(roomDto.getName());
        room.setType(roomDto.getType());
        room.setDescription(roomDto.getDescription());

        return room;
    }


    public static RoomEntityDto toRoomEntityDto(Room room) {
        var roomDto = new RoomEntityDto();

        roomDto.setId(room.getId());
        roomDto.setName(room.getName());
        roomDto.setType(room.getType());
        roomDto.setDescription(room.getDescription());
        roomDto.setModifiedDate(room.getModifiedDate());

        return roomDto;
    }

    public static Room toRoom(RoomEntityDto roomEntityDto) {
        var room = new Room();

        room.setId(roomEntityDto.getId());
        room.setName(roomEntityDto.getName());
        room.setType(roomEntityDto.getType());
        room.setDescription(roomEntityDto.getDescription());

        return room;
    }

}
