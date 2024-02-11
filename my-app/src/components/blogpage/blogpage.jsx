
import React,{Componen, useEffect, useState} from "react";
import './blogpage.scss';
import { Link } from 'react-router-dom';
import axiosClient from "../../axios-client";

const blogpage = () => {
    const [blogs, setBlogs] = useState([]);
useEffect( () => {
   getB()
} , [])


const getB = () => {
   axiosClient.get('/blog/get')
   .then(({data})=>{
        setBlogs(data)
        console.log(data);

   })
.catch(err => {
   const response = err.response;
   if(response && response.status == 422){
       console.log(response.data.errors);
   }
})
}
    return (

<div className="home-blog">
    <div className="posts">
    {blogs.map(b => (   <div key={b.id}className="post">
            <div className="img-blog">
            <img src={`data:image/jpeg;base64,${b.image}`} alt="" />
            </div> 
            <div className="content-blog">
                <Link className="link-blog">
                    <h1>{b.title}</h1>
                </Link>
                <p>{b.description.slice(0, 25)}</p>
                <Link  to={'/blogpage/'+b.id } >
                <button>Read More</button>
                </Link>

                
            </div>
        </div>))}
        
    </div>
</div>
  );
};

export default blogpage; // Exporting the corrected Card component
 