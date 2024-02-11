import React,{useEffect, useRef, useState} from "react";


import img1 from "../../assets/img/pexels-jess-bailey-designs-768474.jpg";
import styles from './addNewblog.module.css';
import { Link } from "react-router-dom";
import axiosClient from "../../axios-client";
import { useStateContext } from "../../contexts/ContextProvider";
import { Navigate } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';



const Form = () => {
    const {user} = useStateContext();

    const nameRef = useRef();
    const descriptionRef = useRef();
     const [images,setImages] = useState('')
     const navigate = useNavigate();

     function handleImage(e) {
        setImages(e.target.files[0])
     }

    

    const onSubmit = (ev) =>{
        ev.preventDefault()

        const formData = new FormData()
        formData.append('image',images)
        formData.append('description',descriptionRef.current.value)
         formData.append('UserId',user.id)
         formData.append('name',nameRef.current.value)
        
        axiosClient.post('/blog/add', formData)
        .then(({data})=>{
             console.log(data);
             navigate('/blog')

        })
    .catch(err => {
        const response = err.response;
        if(response && response.status == 422){
            //setErrors(response.data.errors)
        }
    })

}
  return (
    <div className={styles.logintoblog}>
    <section className={styles.FormFor}>
        <div className={styles.register}>
         <div className={styles.col1}>
            <h2>Add New Blog</h2>
            
            <form id={styles.form345} className={`${styles.flex34} ${styles.flexcol7}`} enctype="multipart/form-data" >
             <input ref={nameRef} type="text" placeholder="name" />
             <input ref={descriptionRef} type="text"  />

             <input  type="file" onChange={handleImage} />
             <button onClick={onSubmit} className={styles.btn}>Add new Blog</button>
            </form>
         </div>
         <div className={styles.col2}>
            <img src={img1} alt="a header image" />
         </div>
        </div>
    </section>
  </div>

  );
};

export default Form; // Exporting the corrected Card component
