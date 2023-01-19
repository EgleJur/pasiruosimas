import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "../css/List.css";


export function RoomListPage(props) {

    const [rooms, setRooms] = useState([]);
    const JSON_HEADERS = {
        "Content-Type": "application/json"
    }

    const fetchRooms = () => {
        fetch('api/v1/rooms')
            .then(response => response.json())
            .then(jsonResponse => setRooms(jsonResponse));
    };


    useEffect(() => {
        fetchRooms();
    }, []);

    const deleteRoom = (id) => {
        fetch("api/v1/rooms/" + id, {
            method: "DELETE",
            headers: JSON_HEADERS
        }).then(fetchRooms);
    };


    return (<div  className="List">
        <h2>Rooms</h2>
        
        <table >
            <thead>
                <tr>
                    <th>Vardas</th>
                    <th>Tipas</th>
                    <th>Aprasas</th>
                    <th>Veiksmai</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
        
        <tbody>
            {rooms.map(room => (
                <tr key={room.id}>
                  
                    <td>{room.name}</td>
                    <td>{room.type}</td>
                    <td>{room.description}</td>
                    <td><button onClick={() => deleteRoom(room.id)}>Delete</button></td>
                    <td><Link to={"/rooms/update/" + room.id}>
                    <button>Update</button></Link></td>
                    <td><Link to={"/rooms/view/" + room.id}>
                    <button>View</button></Link></td>
                </tr>
            ))}
        </tbody>
        </table>
        
    </div>
    )
}