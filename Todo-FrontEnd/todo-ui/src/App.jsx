import { useState } from 'react'
import './App.css'
import ListTodoComponent from './Components/ListTodoComponent'
import HeaderComponent from './Components/HeaderComponent'
import TodoComponent from './Components/TodoComponent'
import FooterComponent from './Components/FooterComponent'
import { BrowserRouter, Routes, Route} from 'react-router-dom'


function App() {

  return (
    <>
    <BrowserRouter>
        <HeaderComponent />
          <Routes>

              {/* http://localhost:8080 */}
              <Route path='/' element = { <ListTodoComponent /> }></Route>
               
               {/* http://localhost:8080/todos */}
              <Route path='/todos' element = { <ListTodoComponent /> }></Route>
              
              {/* http://localhost:8080/add-todo */}
              <Route path='/add-todo' element = { <TodoComponent /> }></Route>
              
              {/* http://localhost:8080/update-todo/1 */}
              <Route path='/update-todo/:id' element = { <TodoComponent /> }></Route>

          </Routes>
        <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
