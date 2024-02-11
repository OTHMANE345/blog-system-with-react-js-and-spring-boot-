
import React,{Componen, useEffect, useState} from "react";
import './blog.scss';
//import { Link } from 'react-router-dom';
import {  useNavigate, useParams } from 'react-router-dom';
import axiosClient from "../../axios-client";


const blogpage = () => {
    const {id}= useParams();
    const [blogs, setBlogs] = useState([]);

    useEffect( () => {
        getB()
     } , []);
     
     
     const getB = () => {
         const payload ={
             id: id,
         }
         console.log(id);
     
        axiosClient.post('/blog/show', payload)
        .then(({data})=>{
            setBlogs(data)
            console.log(data)
            
            //  setNavig(true);
     
        })
     .catch(err => {
        const response = err.response;
        if(response && response.status == 422){
            console.log(response.data.errors);
        }
     })
     }
    return (
<div className="row">
    <div className="card">
<div className="Single">
    <div className="content-blog">
<img src={`data:image/jpeg;base64,${blogs.image}`} alt="" /><div className="info-blog">
    <span> By {blogs.username}</span>

</div>
<div className="description-blog" style={{maxWidth:'900px'}}>
    <h1>{blogs.name}</h1>
    {blogs.description}

   </div>
    </div>
</div>
</div>
</div>
  );
};

export default blogpage; // Exporting the corrected Card component
