import React from 'react'
import { Navigate, Outlet } from 'react-router-dom'
import { useStateContext } from '../contexts/ContextProvider'
import Navbar from './NavbarFor/NavbarFor';
//import Form from './Form/FormUi';
//import Show from './showProduct/showProduct';

export default function DefaultLayout() {
    // const {user, token} = useStateContext()

    // if(!token){
    //     return <Navigate to="/login"/>
    // }
  return (
    <>
<Navbar/>

<Outlet/>
</>
  )
}
