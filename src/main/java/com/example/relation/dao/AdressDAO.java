package com.example.relation.dao;

import com.example.relation.entitie.Address;
import com.example.relation.entitie.User;
import com.example.relation.repositorie.AdressRepo;
import com.example.relation.repositorie.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class AdressDAO {
    @Autowired
    private AdressRepo adressrepo;

    @Autowired
    private UserRepo userRepo;

    public Address createAdress(Address adress){
        return this.adressrepo.save(adress);
    }

    public Address findone(Long id) {

        return this.adressrepo.findById(id).get();
    }

    public String deletAddress(Long id){

//        User user=this.userRepo.findById(id).orElse(null);
//
//        if (user==null){
//            return "user not found";
//        }
////        user.setAddress(null);
////        Long addressId=user.getAddress().getAddressId();
////        System.out.println("adresss id"+addressId);
////        this.adressrepo.deleteById(addressId);
//        this.userRepo.save(user);
        Address ad=this.adressrepo.findById(id).orElse(null);
        if (ad==null){
            return "adress not found";
        }
            this.adressrepo.deleteById(id);
            return null ;
    }




    public Address Update(Address adress){
        System.out.println("adresss street"+adress.getStreetName());
        System.out.println("adresss "+adress.getAddress());
        System.out.println("________________________________");
        Optional<Address> u=adressrepo.findById(adress.getAddressId());
        System.out.println("adresss street"+u.get().getStreetName());
        System.out.println("adresss "+u.get().getAddress());
        Address address=u.get();
        address.setStreetName(adress.getStreetName());
        if (u.isPresent()){
            return   this.adressrepo.save(address);
        }else {
            return null;
        }
    }


}
