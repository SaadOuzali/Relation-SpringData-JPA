package com.example.relation.dao;


import com.example.relation.entitie.Address;
import com.example.relation.entitie.User;
import com.example.relation.repositorie.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDAO {

    @Autowired
    private UserRepo userRepo;
    public List<User> getUser(){
        return this.userRepo.findAll();
    }



    public Optional<User> getuserbyId(long Id){
        return this.userRepo.findById(Id);
    }

    public User createuser(User user){
        return  this.userRepo.save(user);
    }


    public User updateuser(User user){

        Long id=user.getUser_id();
        System.out.println("id           "+id);
        User u=this.userRepo.findById(id).get();
        u.setUser_name(user.getUser_name());
        u.setEmail(user.getEmail());
//       User uu= this.userRepo.save(u);
//        User userr=u.get();
//        System.out.println("adress      "+u.get().getAddress().getStreetName());
//        userr.setUser_name("dabla");
//        userr.setAddress(user.getAddress());

//        userr.getAddress().setStreetName(user.getAddress().getStreetName());

        return u;
//        if (u.isPresent()){
////            return   this.userRepo.save(userr);
//
////                return u.get();
//        }else {
//            return null;
//        }

    }


    public User updateuserr(User user,Long id){

//        Long id=user.getUser_id();
        User u=this.userRepo.findById(id).get();

        return u;

    }

//    public User updateforeignuser(Address adress,Long id){
//        Optional<User>  u=getuserbyId(id);
//
//        if (u.isPresent()){
//            User user=u.get();
//
//            return   this.userRepo.save(user);
//
//        }else {
//            return null;
//        }
//
//    }

//    public Testentity gg(String email){
//       return this.testrepo.findUserByStatus(email);
//    }
//
//    public Testentity k(UUID id){
//        return this.testrepo.findUserByid(id);
//    }
//
//    public int resetpwd(String pwd,String email){
//       return this.testrepo.updateUser(pwd,email);
//    }
//
//    public List<Testentity> geta(){
//        return this.testrepo.findUsers();
//    }

//    public Optional<List<User>>  fetchAll(String email){
//        return   this.userRepo.getAllByEmail(email);
//    }

    public long CountByEmail(){
        return  this.userRepo.count();
    }

    @Transactional
    public void delete(Long id){
        this.userRepo.deleteById(id);
    }

//    @Transactional
//    public long Delete(Long id){
//        return this.userRepo.deleteByEmail(email);
//    }

//    public List<User> finduserandsort(){
////        return this.testrepo.findAll(Sort.by(Sort.Direction.DESC,"user_id"));
//        return this.userRepo.findByOrderByPasswordDesc();
//    }





}
