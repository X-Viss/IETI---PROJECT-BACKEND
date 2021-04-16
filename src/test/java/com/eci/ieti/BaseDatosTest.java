package com.eci.ieti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eci.ieti.model.Store;
import com.eci.ieti.model.UserModel;
import com.eci.ieti.persistence.TravelPersistenceService;
import com.eci.ieti.persistence.repository.CustomRepository;
import com.eci.ieti.persistence.repository.repo.StoreRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseDatosTest {

    @Autowired
    CustomRepository customRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    TravelPersistenceService travelRepository;

    @Test
    public void insertData() {
        Date date = new Date();
        UserModel user = new UserModel("prueba@mail.com","Prueba", "123", 314250,date,"Colombia");
        customRepository.createUser(user);
        UserModel var = customRepository.getName("Prueba");
        Assertions.assertEquals("123", var.getPassword());
    }

    @Test
    public void userRepo(){
        Date date = new Date();
        UserModel userG = new UserModel("luisa@mail.com","Luisa","321", 314250,date,"Colombia");
        customRepository.createUser(userG);
        UserModel var = userRepository.findByUserName("Luisa");
        Assertions.assertEquals("321", var.getPassword());
    }

    @Test
    public void insertUser(){
        UserModel userG = new UserModel();
        userG.setUserName("Luisa2");
        userG.setPassword("321");
        customRepository.createUser(userG);
        UserModel var = userRepository.findByUserName("Luisa2");
        Assertions.assertEquals("321", var.getPassword());
    }

    @Test
    public void updateUser(){
        Date date = new Date();
        UserModel userG = new UserModel("andres@mail.com","andres","321", 314250,date,"Colombia");
        customRepository.createUser(userG);
        customRepository.updateUser("andres", "andres@mail.com", "341", 310753);
        UserModel var = customRepository.getName("andres@mail.com");
        Assertions.assertEquals("341", var.getPassword());
    }
    

    @Test
    public void verifyStoreCategoryNull(){
        Store store = new Store();
        List<String> tagCat = new ArrayList<>();
        tagCat.add("ASEO");
        tagCat.add("SALUD");
        tagCat.add("ACCESORIOS");
        store.setName("Metro");
        store.setPathImage("imageonred.html");
        store.setUrl("metro.com");
        store.setTagCategories(tagCat);
        storeRepository.save(store);

        String categoryCompare = "";
        
        List<Store> storeResult = travelRepository.getStores(categoryCompare);
        Assertions.assertEquals(0, storeResult.size());
    }

    @Test
    public void verifyStoreCategoryNoExiste(){
        Store store = new Store();
        List<String> tagCat = new ArrayList<>();
        tagCat.add("ASEO");
        tagCat.add("SALUD");
        tagCat.add("ACCESORIOS");
        store.setName("Metro");
        store.setPathImage("imageonred.html");
        store.setUrl("metro.com");
        store.setTagCategories(tagCat);
        storeRepository.save(store);

        String categoryCompare = "VESTUARIO";
        
        List<Store> storeResult = travelRepository.getStores(categoryCompare);
        Assertions.assertEquals(0, storeResult.size());
    }

    @Test
    public void verifyStoreCategoryExiste(){
        Store store1 = new Store();
        List<String> tagCat1 = new ArrayList<>();
        tagCat1.add("ASEO");
        tagCat1.add("SALUD");
        tagCat1.add("ACCESORIOS");
        store1.setName("Metro");
        store1.setPathImage("imageonred.html");
        store1.setUrl("metro.com");
        store1.setTagCategories(tagCat1);
        storeRepository.save(store1);

        Store store2 = new Store();
        List<String> tagCat2 = new ArrayList<>();
        tagCat2.add("ROPA");
        tagCat2.add("SALUD");
        store2.setName("Jumbo");
        store2.setPathImage("imageonred2.html");
        store2.setUrl("jumbo.com");
        store2.setTagCategories(tagCat2);
        storeRepository.save(store2);

        String categoryCompare = "SALUD";
        
        List<Store> storeResult = travelRepository.getStores(categoryCompare);
        Assertions.assertEquals(2, storeResult.size());
    }
}
