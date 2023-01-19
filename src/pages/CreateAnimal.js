import { useState } from "react"
import {useHref} from 'react-router-dom';
import { ANIMAL_TYPES } from '../constants/Constants';

export function CreateAnimalPage(props) {
    const [name, setName] = useState("");
    const [type, setType] = useState("TIGER");
    const [description, setDescription] = useState("");

    const listUrl = useHref('/');
    const clear = () =>{
        setName("");
        setType("");
        setDescription("");
    };

    const applyResult = (result) => {
        if (result.ok) {
            clear();
        }else{
            window.alert("Nepavyko sukursti: " + result.status);
        }
    };

    const createAnimal = () => {
        fetch('/api/v1/animals', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name,
                type,
                description,
                registered: false
            })
        }).then(applyResult)
        .then(() => window.location = listUrl);
    };


    return (
        <fieldset id="create">
            <legend>Create new animal</legend>
            <div>
                <label htmlFor="name">Name </label>
                <input
                    id="name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
            </div>
            <div>
                <label htmlFor="type">Type </label>
                </div><div>
                <select value={type}
                    onChange={(e) => setType(e.target.value)}>
                        {Object.entries(ANIMAL_TYPES)
 .map(([key, value]) => <option key={key} value={key}>{value}</option>)}
                    </select>
                
            </div>
            <div>
                <label htmlFor="description">Description</label>
                <input
                    id="description"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)} />
            </div>
            <div>
                <button onClick = {createAnimal}>Create</button>
            </div>
        </fieldset>
    )
}