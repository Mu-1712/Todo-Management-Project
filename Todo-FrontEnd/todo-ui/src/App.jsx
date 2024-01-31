import { useState } from 'react'
import './App.css'
import ListTodoComponent from './Components/ListTodoComponent'
import HeaderComponent from './Components/HeaderComponent'
import TodoComponent from './Components/TodoComponent'
import FooterComponent from './Components/FooterComponent'
import { BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import RegisterComponent from './Components/RegisterComponent'
import LoginComponent from './Components/LoginComponent'
import { isUserLoggedIn } from './Services/AuthService'


function App() {

  function AuthenticationRoute({children}){

    const isAuth = isUserLoggedIn();

    if(isAuth){
      return children;
    }
    return <Navigate to="/" />
  }

  return (
    <>
    <BrowserRouter>
        <HeaderComponent />
          <Routes>

            {/* http://localhost:8080 */}
              <Route path='/' element = { <LoginComponent /> }></Route>
               
            {/* http://localhost:8080/todos */}

            <Route path='/todos' element = { 
              <AuthenticationRoute>
                <ListTodoComponent /> 
              </AuthenticationRoute>
            }></Route>
              
            {/* http://localhost:8080/add-todo */}

            <Route path='/add-todo' element = {
              <AuthenticationRoute>
                <TodoComponent /> 
              </AuthenticationRoute>
            }></Route>
              
            {/* http://localhost:8080/update-todo/1 */}

            <Route path='/update-todo/:id' element = {
              <AuthenticationRoute>
                <TodoComponent /> 
              </AuthenticationRoute>
            }></Route>

            {/* http://localhost:8080/register */}
            <Route path='/register' element = {<RegisterComponent />}></Route>

            {/* http://localhost:8080/login */}
            <Route path='/login' element = { <LoginComponent /> }></Route>

          </Routes>
        <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
