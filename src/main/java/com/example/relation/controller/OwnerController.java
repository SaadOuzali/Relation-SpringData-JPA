package com.example.relation.controller;

import com.example.relation.entitie.*;
import com.example.relation.repositorie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerRepo ownerRepository;

    @Autowired
    private AdressRepo adressRepo;
    @Autowired
    private BlogRepo blogRepository;

    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Autowired
    private InscriptionRepo inscriptionRepo;

    //to save one owner
//    @PostMapping("/saveOwner")
//    public String saveOwner(@RequestBody Owner owner) {
//        System.out.println("Owner save called...");
//        // save Owner
//        Owner ownerOut = ownerRepository.save(owner);
//        System.out.println("Owner out :: " + ownerOut);
//
//        System.out.println("Saved!!!");
//        System.out.println(ownerOut.getBlogList());
//        return "Owner saved!!!";
//    }





    //to save owner with her adress or owner only
    @PostMapping("/saveOwner")
    public String saveOwner(@RequestBody Owner owner) {
        System.out.println("Owner save called...");
//        Owner owner1=new Owner();
//        owner1.setEmail(owner.getEmail());
//        owner1.setName(owner.getName());
//        Address address=owner.getAddress();


        // save Owner
        Owner ownerOut = ownerRepository.save(owner);
        System.out.println("Saved!!!");
        return "Owner saved!!!";
    }


//    @PostMapping("/saveOwner")
//    public String saveOwner(@RequestBody Owner owner) {
//        System.out.println("Owner save called...");
//
//        // a new Owner
//        Owner ownerIn = new Owner(owner.getName(), owner.getEmail());
//        // list of Blog
//        List<Blog> blogs = new ArrayList<>();
//        if(owner.getBlogList() != null){
//            for (Blog blogIn : owner.getBlogList()) {
//                // new Blog
//                Blog blog = new Blog(blogIn.getTitle(), blogIn.getCategory(), blogIn.getContent());
//                // set owner to Blog
//                blog.setOwner(ownerIn);
//                // add blog to list
//                blogs.add(blog);
//            }
//        }
//
//        // add blog list to Owner
//        ownerIn.setBlogList(blogs);
//        Address adress=owner.getAddress();
//        adress.setOwner(ownerIn);
//        ownerIn.setAddress(adress);
//
//        // save Owner
//        Owner ownerOut = ownerRepository.save(ownerIn);
//        System.out.println("Owner out :: " + ownerOut);
//
//        System.out.println("Saved!!!");
//        return "Owner saved!!!";
//    }



    // create blog for exiting user
        @PostMapping("/saveBlog")
    public String saveBlog(@RequestParam(name = "id") String id) {
        System.out.println("Blog save called...");

        // fetch Owner
        Owner ownerTemp = ownerRepository.getById(Integer.valueOf(id));

        // new Blog
        Blog blog = new Blog("Build application server using NodeJs", "nodeJs",
                "We will build REStful api using nodeJs.");
        // set owner to blog
        if (ownerTemp != null){
            blog.setOwner(ownerTemp );
        }
       ownerTemp.getBlogList().add(blog);

        // save Owner
        blogRepository.save(blog);

        System.out.println("Saved!!!");
        return "Blog saved!!!";
    }







    //from blog i can create user but i need to add
    @PostMapping("/saveBlogg")
    public String saveBlogg(@RequestBody Blog blog) {
        System.out.println("Blog save called...");
        blogRepository.save(blog);
        System.out.println("Saved!!!");
        return "Blog saved!!!";
    }

    @GetMapping("/getOwner/{id}")
    public Owner getOwner(@PathVariable(name = "id") Integer id) {
        System.out.println("Owner get called...");

        // fetch Owner
        Owner ownerOut = ownerRepository.findById(id).get();
        System.out.println("email" + ownerOut.getEmail());
        System.out.println("name" + ownerOut.getName());
        System.out.println("id" + ownerOut.getId());
//        System.out.println("\nList of Blogs :: \n" + ownerOut.getBlogList());

//        System.out.println("\nDone!!!");
        return ownerOut;
    }

    @GetMapping("/getBlog/{id}")
    public Blog getBlog(@PathVariable(name = "id") String id) {
        System.out.println("Blog get called...");

        // fetch Blog
        Blog blogOut = blogRepository.getById(Integer.valueOf(id));
        System.out.println("\nBlog details :: \n" + blogOut);
        System.out.println("\nOwner details :: \n" + blogOut.getOwner());

        System.out.println("\nDone!!!");
        return blogOut;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        this.ownerRepository.deleteById(id);
    }

    @DeleteMapping("/deleteblog/{id}")
    public void deleteBlog(@PathVariable Integer id){
        this.blogRepository.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id){
        Blog blog=blogRepository.findById(id).get();
        blog.setCategory("java/fullstack");
        this.blogRepository.save(blog);
    }



        @PostMapping("/saveGroup")
    public String saveGroup(@RequestBody Group group) {
        System.out.println("Group save called...");
        this.groupRepo.save(group);
        System.out.println("Saved!!!");
        return "Group saved!!!";
    }

    @PostMapping("/saveInscription")
    public String saveInsxri(@RequestBody Inscription inscription) {
        System.out.println("insxri save called...");
        this.inscriptionRepo.save(inscription);
        System.out.println("Saved!!!");
        return "Inscri saved!!!";
    }


    //save inscri with exiting group and utilisateur
    @PostMapping("/saveInscri/{id}/{id2}")
    public String saveInscri(@PathVariable Long id,@PathVariable Long id2,@RequestBody Inscription inscription) {
        System.out.println("insxri save called...");
        Group g=this.groupRepo.findById(id).orElse(null);
        Utilisateurs u=this.utilisateurRepo.findById(id2).orElse(null);
        Inscription in=new Inscription();
        in.setGroup(g);
        in.setUtilisateurs(u);
        this.inscriptionRepo.save(in);
        System.out.println("Saved!!!");
        return "Inscri saved!!!";
    }

    @GetMapping("/findInscri")
    public List<Inscription> fi(){
        return this.inscriptionRepo.findAll();
    }




//    @PostMapping("/saveUtili")
//    public String saveUtilisateu(@RequestBody Utilisateurs util) {
//        System.out.println("utili save called...");
//        this.utilisateurRepo.save(util);
//        System.out.println("Saved!!!");
//        return "utilisateur saved!!!";
//    }

    @PostMapping("/saveUtili")
    public String saveUtilisateu(@RequestBody Utilisateurs util) {
        System.out.println("utili save called...");
        this.utilisateurRepo.save(util);
        System.out.println("Saved!!!");
        return "utilisateur saved!!!";
    }

    //add user to group
//    @GetMapping("/addtogroup")
//    public void addToGroup(@RequestParam String group,@RequestParam String utili){
//
//        Utilisateurs u=this.utilisateurRepo.findByUserName(utili);
//        Group g=this.groupRepo.findByGroupName(group);
//        g.getUtilisateurs().add(u);
//        this.groupRepo.save(g);
//
//    }


}