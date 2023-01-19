import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export function ViewRoom() {
    const [room, setRoom] = useState({});
    const params = useParams();

useEffect(()=>{
    fetch('api/v1/rooms/' + params.id)
    .then((response)=> response.json())
    .then(setRoom)
}, [params.id]);

    return(<div>
            <div><b>ID</b></div>
            <div>{room.id}</div>

            <div><b>Name</b></div>
            <div>{room.name}</div>

            <div><b>Type</b></div>
            <div>{room.type}</div>

            <div><b>Description</b></div>
            <div>{room.description}</div>

            
        </div>);


}