package com.Blog.Service;

import com.Blog.JWT.JwtFilter;
import com.Blog.Repositories.BlogRepository;
import com.Blog.Repositories.UserRepository;
import com.Blog.Wrapper.Productwrapper;
import com.Blog.modules.Blog;
import com.Blog.Wrapper.productwrapperfordisplay;
import com.Blog.modules.User;
import com.Login.com.Login.utils.apputils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
@Slf4j
@Service
public class BlogServices {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;


    @Autowired
    JwtFilter jwtFilter;

    Logger logger = Logger.getLogger("my.app");

    public ResponseEntity<String> addNewBlog(Productwrapper requestMap) {
        try {

                blogRepository.save(getProductFromMap(requestMap)) ;
                    return apputils.getResponseEntity("Blog addes succefully", HttpStatus.OK);


        }catch(Exception ex){
            ex.printStackTrace();
        }
        return apputils.getResponseEntity("Something went wrong in services", HttpStatus.INTERNAL_SERVER_ERROR);

    }




    private Blog getProductFromMap(Productwrapper requestMap) throws IOException {
        Blog blog = new Blog();
        blog.setTitle(requestMap.getName());
        blog.setUserId(requestMap.getUserId());
        String id = requestMap.getUserId();
        User user = userRepository.findById(Integer.valueOf(id)).get();
        blog.setDescription(requestMap.getDescription());
        blog.setUsername(user.getName());
        blog.setImage(Base64.getEncoder().encodeToString(requestMap.getImage().getBytes()));
        return blog;
    }





    public ResponseEntity<List<Blog>> getAllBlogs() {
     List<Blog> blogs = blogRepository.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);

    }




    public ResponseEntity<productwrapperfordisplay> showBlog(Map<String, String> requestMap) {
        try {
            String id = requestMap.get("id");
            Blog blog = blogRepository.findById(Integer.valueOf(id)).get();
            productwrapperfordisplay productwrapper = new productwrapperfordisplay();
            productwrapper.setName(blog.getTitle());
            productwrapper.setDescription(blog.getDescription());
            productwrapper.setUserId(blog.getUserId());
            productwrapper.setImage(blog.getImage());
            productwrapper.setUsername(blog.getUsername());

            return new ResponseEntity<>(productwrapper, HttpStatus.OK);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new productwrapperfordisplay(), HttpStatus.INTERNAL_SERVER_ERROR);
    }




}

