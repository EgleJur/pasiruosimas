import { AnimalListPage } from './pages/AnimalList';
import './App.css';
import { useState } from 'react';
import { Menu } from './components/Menu'
import { CreateAnimalPage } from './pages/CreateAnimal';
import { UpdateAnimalPage } from './pages/UpdateAnimal';
import {RoomListPage} from './pages/RoomList';
import { UpdateRoomPage } from "./pages/UpdateRoom";
import { ViewAnimal } from './pages/ViewAnimal';
import { HashRouter, Route, Routes } from 'react-router-dom';
import { ViewRoom } from "./pages/ViewRoom";

function App() {
 
  return (
    <div className="App">
      <HashRouter>
        <Menu />
        <Routes>
        <Route path='/' element={<AnimalListPage />} />
        <Route path='/create' element={<CreateAnimalPage />} />
        <Route path='/animals/view/:id' element={<ViewAnimal />} />
        <Route path='/animals/update/:id' element={<UpdateAnimalPage />} />
        <Route path='/rooms' element={<RoomListPage />} />
        <Route path='/rooms/update/:id' element={<UpdateRoomPage />} />
        <Route path='/rooms/view/:id' element={<ViewRoom />} />
        </Routes>
      </HashRouter>
    </div>
  );
}

export default App;
