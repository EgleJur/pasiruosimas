package lt.techin.zoo.dao;

import lt.techin.zoo.model.Room;
import lt.techin.zoo.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    long countByName(String name);

    List<Room> findFirst3ByType(RoomType type);

}
