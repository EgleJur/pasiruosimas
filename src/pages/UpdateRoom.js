import "../css/Update.css";
import { useHref } from 'react-router-dom';
import { ROOM_TYPES } from '../constants/Constants';
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";


export function UpdateRoomPage() {
    const params = useParams();
    const [error, setError] = useState();
    const [room, setRoom] = useState({
        name: '',
        type: '',
        description: '',
    });

    const listUrl = useHref('/rooms');
    const JSON_HEADERS = {
        "Content-Type": "application/json"
    }
    const updateRoom = () => {
        fetch('/api/v1/rooms/' + params.id, {
            method: 'PATCH',
            headers: JSON_HEADERS,
            body: JSON.stringify(room)
        }).then(result => {
            if (!result.ok) {
                setError('Update failed');
            } else {
                setError();
                window.location = listUrl;
            }
        })
            // .then(() => window.location = listUrl);
    }

    useEffect(() => {
        fetch('/api/v1/rooms/' + params.id)
            .then(response => response.json())
            .then(setRoom);
    }, []);

    const updateProperty = (property, event) => {
        setRoom({
            ...room,
            [property]: event.target.value
        });
    }

    return (<div>

        <h2>Update room</h2>
        <fieldset>
            <legend>{params.id}</legend>
            <div>
                <label>Name</label>
                <input value={room.name} onChange={(e) => updateProperty('name', e)} />
            </div><div>
                <label>Type</label>
            </div><div>
                <select value={room.type}
                    onChange={(e) => updateProperty('type', e)}>
                    {Object.entries(ROOM_TYPES)
                        .map(([key, value]) => <option key={key} value={key}>{value}</option>)}
                </select>
            </div><div>
                <label>Description</label>
                <input value={room.description} onChange={(e) => updateProperty('description', e)} />
            </div>
            {error && (<div className='error'> {error}</div>)}
            <div>
                <button onClick={updateRoom}>Update</button>
            </div>
        </fieldset>

    </div>);

}
