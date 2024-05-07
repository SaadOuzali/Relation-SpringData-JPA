package com.example.relation.controller;



import com.example.relation.dao.AdressDAO;
import com.example.relation.dao.UserDAO;
import com.example.relation.dto.Dtoo;
import com.example.relation.entitie.Address;
import com.example.relation.entitie.Student;
import com.example.relation.entitie.User;
import com.example.relation.repositorie.StudenetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//jpa ets une spécefication qui standard l'ORM
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
//    private AdressDAO adressDao;
    private AdressDAO adressDAO;

    @Autowired
    private StudenetRepo studenetRepo;

    @GetMapping(path = "/get-users")
    public List<User> getUsers(){
        return this.userDAO.getUser();
    }

    @GetMapping(path = "/option")
    public Optional<String> check(){
        String a=null;
        Optional<String> x=Optional.ofNullable(a);

        if (x.isPresent()){
            System.out.println(x);
            return Optional.ofNullable(a);
        }else {
            System.out.println("not present"+x);
            return Optional.ofNullable(a);
        }

    }




//    @GetMapping(path = "/findbyid")
//    public Optional<Testentity> getById(@RequestParam  Integer user_id){
//       return this.testdao.getuserbyId(user_id);
//    }



//    @GetMapping(path = "/findbyid")
//    public ResponseEntity<Testentity> getByid(@RequestParam UUID user_id){
//        Optional<Testentity> user= this.testdao.getuserbyId(user_id);
//
//        //pour retourner les atrributs
//        if (user.isPresent()) {
////            return user.get().getEmail();
////            return ResponseEntity.ok(user.get());
//            return new ResponseEntity<>(user.get(), HttpStatus.ACCEPTED);
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping(path = "/findbyid")
    public User getByid(@RequestParam Long user_id){
        Optional<User> user= this.userDAO.getuserbyId(user_id);

//        System.out.println("hanna    "+user.get().getAddress().getStreetName());
        //pour retourner les atrributs
        if (user.isPresent()) {
//            return user.get().getEmail();
//            return ResponseEntity.ok(user.get());
//            return new ResponseEntity<>(user.get(), HttpStatus.ACCEPTED);
//            Dtoo b=new Dtoo();
//            b.setUser_id(user.get().getUser_id());
//            b.setPassword(user.get().getPassword());
//            b.setUser_name(user.get().getUser_name());
//            b.setEmail(user.get().getEmail());
//            b.setAddress(user.get().getAddress());
//            Address adress=user.get().getAddress();
//            b.setAddress(adress);
//
            System.out.println("find user one by id hada email dialo"+user.get().getAddress().getStreetName());
//            b.setAddress();
//            return b;
            return user.get();

        }else {
            return  null;
        }
    }



//    @PostMapping(path = "/create")
//    public User createUser(@RequestBody User user) throws Exception{
//        try {
////            Testentity u=new Testentity();
////           Address adress=this.adressDAO.findone(id);
//           User u=user;
//           u.getAddress().setUser(user);
//            u.setAddress(user.getAddress());
//
//            return this.userDAO.createuser(u);
//        }catch (Exception  e){
//            throw new Exception(e.getMessage());
//        }
//    }


    @PostMapping(path = "/create")
    public User createUser(@RequestBody User user) throws Exception{
//        try {
//            Testentity u=new Testentity();
//           Address adress=this.adressDAO.findone(user.getAddress().getAddressId());
//           adress.setStreetName("sid 5ala5al");
//            User u=new User();
//            u.setEmail(user.getEmail());
//            u.setPassword(user.getPassword());
//            u.setUser_name(user.getUser_name());
//            Address adress=user.getAddress();
//            adress.setUser(user);
//        user.setAddress(adress);
            return this.userDAO.createuser(user);
//            }
//        }catch (Exception  e){
//            throw new Exception(e.getMessage());
//        }
    }

    @PostMapping(path = "/update")
    public User updateteUser(@RequestBody User user) throws Exception{
        try {
            User u=this.userDAO.updateuser(user);
            return u;
        }catch (Exception  e){
            throw new Exception("Erorrrrrrr"+e.getMessage());
        }
    }

    @PostMapping(path = "/updatee")
    public User updateteUserr(@RequestBody User user) throws Exception{
        try {
            Long id=user.getUser_id();
            User u=this.userDAO.updateuserr(user,id);
            return u;
        }catch (Exception  e){
            throw new Exception("Erorrrrrrr"+e.getMessage());
        }
    }

//    @GetMapping(path = "/LL")
//    public Testentity get(@RequestParam  String email){
//        return this.testdao.gg(email);
//    }
//
//    @GetMapping(path = "/ff")
//    public Testentity j(@RequestParam  UUID id){
//        return this.testdao.k(id);
//    }
//
//    @GetMapping(path = "/all")
//    public List<Testentity> n(){
//        return this.testdao.geta();
//    }
//
//    @PostMapping(path = "/reset")
//    public int reset(@RequestBody Testentity user){
//       return this.testdao.resetpwd(user.getPassword(), user.getEmail());
//    }

//    @GetMapping(path = "/alluser")
//    public List<Testentity> n(){
//        return this.testdao.fetchAll("saad@gmail.com");
//    }

//    @GetMapping(path = "/alluser")
//    public Optional<List<User>> n(){
//        Optional<List<User>> user= this.userDAO.fetchAll("Hicham@gmail.com");
//        if(user.isPresent()){
//            System.out.println("userrr "+user);
//            return user;
//        }else {
//            System.out.println( user);
//            return user;
//        }
//    }

    @GetMapping(path = "/count")
    public HashMap<String,Long> countby(){
        HashMap<String,Long> data=new HashMap<String,Long>();
        long count= this.userDAO.CountByEmail();
        data.put("the number of user with that email is:",count);
        return data;
    }

//    @DeleteMapping (path = "/byid")
//    public long delete(){
////        return this.userDAO.Delete("bouchra@gmail.com");
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userDAO.delete(id);
    }

    @PostMapping("/student")
    public Student cr(@RequestBody Student student){
        return this.studenetRepo.save(student);
    }

    @PutMapping("/student")
    public Student up(@RequestBody Student student){
        return this.studenetRepo.save(student);
    }

    @GetMapping("/student")
    public String fi(@PathVariable Long id){
        System.out.println("id     ddddddd"+id);
        return "this.studenetRepo.findById(id).orElse(null)";
    }

//    @GetMapping (path = "/ ")
//    public List<User> asc(){
//        return this.userDAO.finduserandsort();
//    }

//    @GetMapping(path = "/hna")
//    public Dtoo rt(){
//        Dtoo c=new Dtoo();
//        c.setId(123);
//        c.setName("saad");
//        return c;
//    }

}

