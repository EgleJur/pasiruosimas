import { useEffect, useState } from "react"
import './Menu.css'
import { Link } from "react-router-dom";

export function Menu(props) {

    return (
        <div className="Menu">
            <Link to='/'>Animal List</Link>
            &nbsp;|&nbsp;
            <Link to='/create'>Create new animal</Link>
            &nbsp;|&nbsp;
            <Link to='/rooms'>Room list</Link>
        </div>
    )
}