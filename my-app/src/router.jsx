import {createBrowserRouter} from "react-router-dom";

import Blogs from "./components/blogpage/blogpage";
import Blogspage from "./components/blog/blog";

import Login from "./components/Form/FormUi";
import Add from "./components/addNewBlog/addNewblog";

import Register from "./components/FormForSingUp/FormUiforSingUp";

import DefaultLayout from './components/DefaultLayout';


const router =  createBrowserRouter([
    {
        path:'/',
        element:<DefaultLayout/>,
        children:[

                {
                    path:'/login',
                    element:<Login/>
                },
                {
                    path:'/register',
                    element:<Register/>
                },
                {
                    path:'/blog',
                    element:<Blogs/>
                },
                {
                    path:'/blogpage/:id',
                    
                    element:<Blogspage/>
                },
                {
                    path:'/add',
                    
                    element:<Add/>
                },
              

        ]
    },
   

    // {
    //     path:'/',
    //     element:<GuestLayout/>,
    //      children:[

    //             {
    //                 path:'/signup',
    //                 element:<Form/>
    //             },

    //     ]
    // },


])


 export default router;
