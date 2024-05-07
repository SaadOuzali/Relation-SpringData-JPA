//package com.example.relation.controller;
//
//import com.example.relation.dao.PostDAO;
//import com.example.relation.entitie.Posts;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/post")
//public class PostController {
//
//
//    @Autowired
//    private PostDAO postDAO;
//
//    @PostMapping("/create")
//    public Posts createPost(@RequestBody Posts post){
//        return this.postDAO.createpost(post);
//    }
//
//}
