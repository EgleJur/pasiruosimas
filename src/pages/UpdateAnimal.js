import "../css/Update.css";
import { useHref } from 'react-router-dom';
import { ANIMAL_TYPES } from '../constants/Constants';
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";


export function UpdateAnimalPage() {
    const params = useParams();
    const [error, setError] = useState();
    const [animal, setAnimal] = useState({
        name: '',
        type: '',
        description: '',
    });

    const listUrl = useHref('/');
    const JSON_HEADERS = {
        "Content-Type": "application/json"
    }
    const updateAnimal = () => {
        fetch('/api/v1/animals/' + params.id, {
            method: 'PATCH',
            headers: JSON_HEADERS,
            body: JSON.stringify(animal)
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
        fetch('/api/v1/animals/' + params.id)
            .then(response => response.json())
            .then(setAnimal);
    }, []);

    const updateProperty = (property, event) => {
        setAnimal({
            ...animal,
            [property]: event.target.value
        });
    }

    return (<div>

        <h2>Update animal</h2>
        <fieldset className="Update-Animal">
            <legend>{params.id}</legend>
            <div>
                <label>Name</label>
                <input value={animal.name} onChange={(e) => updateProperty('name', e)} />
            </div><div>
                <label>Type</label>
            </div><div>
                <select value={animal.type}
                    onChange={(e) => updateProperty('type', e)}>
                    {Object.entries(ANIMAL_TYPES)
                        .map(([key, value]) => <option key={key} value={key}>{value}</option>)}
                </select>
            </div><div>
                <label>Description</label>
                <input value={animal.description} onChange={(e) => updateProperty('description', e)} />
            </div>
            {error && (<div className='error'> {error}</div>)}
            <div>
                <button onClick={updateAnimal}>Update</button>
            </div>
        </fieldset>

    </div>);

}
