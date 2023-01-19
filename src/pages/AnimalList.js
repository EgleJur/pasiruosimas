import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "../css/List.css";


export function AnimalListPage(props) {

    const [animals, setAnimals] = useState([]);
    const JSON_HEADERS = {
        "Content-Type": "application/json"
    }

    const fetchAnimals = () => {
        fetch('api/v1/animals')
            .then(response => response.json())
            .then(jsonResponse => setAnimals(jsonResponse));
    };


    useEffect(() => {
        fetchAnimals();
    }, []);

    const deleteAnimal = (id) => {
        fetch("api/v1/animals/" + id, {
            method: "DELETE",
            headers: JSON_HEADERS
        }).then(fetchAnimals);
    };


    return (<div className="List">
        <h2>Animals</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Vardas</th>
                    <th>Tipas</th>
                    <th>Aprasas</th>
                    <th>Veiksmai</th>
                    <th></th>
                </tr>
            </thead>
        
        <tbody>
            {animals.map(animal => (
                <tr key={animal.id}>
                    <td>
                        <Link to={"/animals/view/" + animal.id}>{animal.id}</Link>
                    </td>
                    <td>{animal.name}</td>
                    <td>{animal.type}</td>
                    <td>{animal.description}</td>
                    <td><button onClick={() => deleteAnimal(animal.id)}>Delete</button></td>
                    <td><Link to={"/animals/update/" + animal.id}>
                    <button>Update</button></Link></td>
                </tr>
            ))}
        </tbody>
        </table>
    </div>
    )
}