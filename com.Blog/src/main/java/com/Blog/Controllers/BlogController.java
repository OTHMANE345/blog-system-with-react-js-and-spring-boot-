package com.Blog.Controllers;


import com.Blog.Service.BlogServices;
import com.Blog.Wrapper.Productwrapper;
import com.Blog.modules.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping(path = "/blog")
@RestController
public class BlogController {

    @Autowired
    BlogServices blogServices;
// tis api by myself just
    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewBlog(@ModelAttribute Productwrapper requestMap){
        try {
            return blogServices.addNewBlog(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return com.Login.com.Login.utils.apputils.getResponseEntity("Something went wrong in controller", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping(path = "/get")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        try {
            return blogServices.getAllBlogs();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(path = "/show")
    public ResponseEntity<com.Blog.Wrapper.productwrapperfordisplay> showBlog(@RequestBody(required = true) Map<String,String> requestMap){
        try {
            return blogServices.showBlog(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new com.Blog.Wrapper.productwrapperfordisplay(), HttpStatus.INTERNAL_SERVER_ERROR);
    }







}
