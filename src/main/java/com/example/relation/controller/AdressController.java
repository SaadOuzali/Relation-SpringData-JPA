package com.example.relation.controller;


import com.example.relation.dao.AdressDAO;
import com.example.relation.dao.UserDAO;
import com.example.relation.entitie.Address;
import com.example.relation.entitie.Owner;
import com.example.relation.entitie.User;
import com.example.relation.repositorie.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/adress")

public class AdressController {

    @Autowired
    private AdressDAO adressdao;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OwnerRepo ownerRepo;




    //mn l3aks mn adress n9ad ncree user
//    @PostMapping(path = "/create/{id}")
//    public ResponseEntity<Address> createexist(@RequestBody Address adress,@PathVariable Long id){
//        User user=adress.getUser();
//        Address ad=new Address();
//        ad.setAddress(adress.getAddress());
//        user.setAddress(ad);
//        ad.setStreetName(adress.getStreetName());
//        ad.setUser(user);
//        Address adre= this.adressdao.createAdress(ad);
//        return new ResponseEntity<>(adre, HttpStatus.CREATED);
//    }



//    @PostMapping(path = "/create/{id}")
//    public ResponseEntity<Address> createexist(@RequestBody Address adress,@PathVariable Long id){
//        User user=adress.getUser();
////        adress.setUser(user);
//        user.setAddress(adress);
//        //or
////        Address ad=new Address();
////        ad.setAddress(adress.getAddress());
////        user.setAddress(ad);
////        ad.setStreetName(adress.getStreetName());
////        ad.setUser(user);
//        Address adre= this.adressdao.createAdress(adress);
////        System.out.println("user mail"+adre.getUser().getEmail());
//        return new ResponseEntity<>(adre, HttpStatus.CREATED);
//    }




    @PostMapping(path = "/createonly")
    public ResponseEntity<Address> createonly(@RequestBody Address adress){

        Address adre= this.adressdao.createAdress(adress );


        return new ResponseEntity<>(adre, HttpStatus.CREATED);


    }

    //had route ila kan 3ndi user deja creer wbgit nsawb adress lih wnrbatha m3ah
        @PostMapping(path = "/create/{id}")
    public ResponseEntity<Address> create(@RequestBody Address adress,@PathVariable Long id){
//            Address adres=new Address();
//            adres.setStreetName(adress.getStreetName());
//            adres.setAddress(adress.getAddress());
        User user=userDAO.getuserbyId(id).orElse(null);
        user.setAddress(adress);
//        adres.setUser(user);
//            adress.setUser(user);
//            this.userDAO.createuser(user);
        Address adre= this.adressdao.createAdress(adress);
//            Address adre= this.userDAO.createuser(user).getAddress();
        return new ResponseEntity<>(adre, HttpStatus.CREATED);
    }



    @PostMapping(path = "/owneraddress/{id}")
    public ResponseEntity<Address> createownerAddress(@RequestBody Address adress,@PathVariable Integer id){
        Address adres=new Address();
        adres.setStreetName(adress.getStreetName());
        adres.setAddress(adress.getAddress());
        Owner owner=ownerRepo.findById(id).orElse(null);
        owner.setAddress(adres);
        adres.setOwner(owner);
        Address adre= this.adressdao.createAdress(adres );
        return new ResponseEntity<>(adre, HttpStatus.CREATED);
    }





    //hada howa logique diali ana li 5dam
//    @PostMapping(path = "/create/{id}")
//    public ResponseEntity<Address> create(@RequestBody Address adress,@PathVariable Long id){
//        User user=userDAO.getuserbyId(id).orElse(null);
//        user.setAddress(adress);
//        adress.setUser(user);
//        User user1=this.userDAO.createuser(user);
//        return new ResponseEntity<>(user1.getAddress(), HttpStatus.CREATED);
//    }


    @GetMapping(path = "/findone/{id}")
    public ResponseEntity<User> find(@PathVariable Long id){
        Address on=this.adressdao.findone(id);
        System.out.println("hna dial user  fa adress user Id      "+on.getUser().getUser_id());

//
        return new ResponseEntity<>(on.getUser()  , HttpStatus.FOUND);
    }


    //ma5damch hadchi
//    @GetMapping(path = "/find/{id}/{id2}")
//    public ResponseEntity<User> findd(@PathVariable Long id,@PathVariable Long id2){
//        Address on=this.adressdao.findone(id);
//        User user=this.userDAO.getuserbyId(id2).orElse(null);
//        user.setAddress(on);
//        on.setUser(user);
//        System.out.println("Updatedddddddd");
//
////
//        return new ResponseEntity<>(on.getUser()  , HttpStatus.FOUND);
//    }



    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        System.out.println("hna fa dressssssssss ");
        this.adressdao.deletAddress(id);
    }

    @PutMapping("/update")
    public Address deletebyuserId(@RequestBody Address adress){
        System.out.println("hna fa dressssssssss ");
      return  this.adressdao.Update(adress);
    }

//    @PutMapping("/cr")
}

