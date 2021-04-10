package com.eci.ieti.controllers;

import com.eci.ieti.configuration.JwtUtils;
import com.eci.ieti.model.*;
import com.eci.ieti.persistence.repository.repo.UserRolRepository;
import com.eci.ieti.persistence.repository.repo.WeatherCategoryRolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CreateTripControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRolRepository userRolRepository;

    @Autowired
    private WeatherCategoryRolRepository weatherCategoryRolRepository;

    @Autowired
    private JwtUtils jwtlUtils;


    @Test
    void postUserRoleShouldBeCreated() throws Exception {


        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();

        mockMvc.perform( post("/api/create/rol").header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(generitToUserRolWeatherOrCategoryList)))
                .andDo(print())
                .andExpect(status().isCreated());
    }


    @Test
    void shouldBePutUserRolSelectDestiny() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("1", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        Country country = new Country();

        mockMvc.perform( put("/api/create/destiny?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(country)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBePutUserRolSelectWeather() throws Exception {
        List<String> salud = new ArrayList<>();
        salud.add("Formulas medicas");
        salud.add("Mareol");
        salud.add("Pastas para la tensión");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Salud");
        weatherCategoryRol.setHealth(salud);
        weatherCategoryRolRepository.save(weatherCategoryRol);

        List<String> aseo = new ArrayList<>();
        aseo.add("Cuchilla de afeitar");
        aseo.add("Peinillas");
        WeatherCategoryRol weatherCategoryRol2 = new WeatherCategoryRol();
        weatherCategoryRol2.setId("Aseo");
        weatherCategoryRol2.setCleanness(aseo);
        weatherCategoryRolRepository.save(weatherCategoryRol2);

        List<String> mano = new ArrayList<>();
        mano.add("Papeles");
        mano.add("Dinero");
        WeatherCategoryRol weatherCategoryRol3 = new WeatherCategoryRol();
        weatherCategoryRol3.setId("Mano");
        weatherCategoryRol3.setOnHand(mano);
        weatherCategoryRolRepository.save(weatherCategoryRol3);

        List<String>  trabajoAccesorios = new ArrayList<>();
        List<String>  trabajoRopa = new ArrayList<>();
        List<String>  trabajoSalud = new ArrayList<>();
        List<String>  trabajoMano= new ArrayList<>();
        trabajoAccesorios.add("Computador");
        trabajoAccesorios.add("Mouse");
        trabajoRopa.add("Casco");
        trabajoSalud.add("Seguro medico");
        trabajoMano.add("Celular");
        WeatherCategoryRol weatherCategoryRol4 = new WeatherCategoryRol();
        weatherCategoryRol4.setId("Trabajo");
        weatherCategoryRol4.setWorkAccesories(trabajoAccesorios);
        weatherCategoryRol4.setWorkClothes(trabajoRopa);
        weatherCategoryRol4.setWorkHealth(trabajoSalud);
        weatherCategoryRol4.setWorkOnHand(trabajoMano);
        weatherCategoryRolRepository.save(weatherCategoryRol4);

        List<String> turistaAccesorios = new ArrayList<>();
        List<String> turistaRopa = new ArrayList<>();
        turistaAccesorios.add("Maleta");
        turistaAccesorios.add("Mapa");
        turistaRopa.add("Vestidos");
        turistaRopa.add("Sandalias");
        WeatherCategoryRol weatherCategoryRol5 = new WeatherCategoryRol();
        weatherCategoryRol5.setId("Turista");
        weatherCategoryRol5.setTouristAccesories(turistaAccesorios);
        weatherCategoryRol5.setTouristClothes(turistaRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol5);

        List<String> parejaAccesorios = new ArrayList<>();
        parejaAccesorios.add("Silla para bebe");
        WeatherCategoryRol weatherCategoryRol6 = new WeatherCategoryRol();
        weatherCategoryRol6.setId("Pareja");
        weatherCategoryRol6.setCoupleAcceosires(parejaAccesorios);
        weatherCategoryRolRepository.save(weatherCategoryRol6);

        List<String> mochileroAccesorios = new ArrayList<>();
        List<String> mochileroRopa = new ArrayList<>();
        mochileroAccesorios.add("Brújula");
        mochileroAccesorios.add("Hoyas");
        mochileroAccesorios.add("Bloqueador");
        mochileroRopa.add("Chaquetas");
        WeatherCategoryRol weatherCategoryRol7 = new WeatherCategoryRol();
        weatherCategoryRol7.setId("Mochilero");
        weatherCategoryRol7.setBackpackerAccesories(mochileroAccesorios);
        weatherCategoryRol7.setBackpackerClothes(mochileroRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol7);

        List<String> mascotaAccesorios= new ArrayList<>();
        List<String> mascotaRopa = new ArrayList<>();
        List<String> mascotaSalud = new ArrayList<>();
        mascotaAccesorios.add("Cama de la mascota");
        mascotaSalud.add("Medicamento contra garrapatas");
        WeatherCategoryRol weatherCategoryRol8 = new WeatherCategoryRol();
        weatherCategoryRol8.setId("Mascota");
        weatherCategoryRol8.setPetsAccesories(mascotaAccesorios);
        weatherCategoryRol8.setPetsClothes(mascotaRopa);
        weatherCategoryRol8.setPetsOnHand(mascotaSalud);
        weatherCategoryRolRepository.save(weatherCategoryRol8);

        List<String> primaverAccesorios = new ArrayList<>();
        List<String> primaveraRopa = new ArrayList<>();
        primaverAccesorios.add("Gafas");
        primaverAccesorios.add("Balacas");
        primaveraRopa.add("Chanclas");
        primaveraRopa.add("Tenis");
        WeatherCategoryRol weatherCategoryRol9 = new WeatherCategoryRol();
        weatherCategoryRol9.setId("Primavera");
        weatherCategoryRol9.setSpringAccesories(primaverAccesorios);
        weatherCategoryRol9.setSpringClothes(primaveraRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol9);

        List<String> otonoAccesorios = new ArrayList<>();
        List<String> otonoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol10 = new WeatherCategoryRol();
        otonoAccesorios.add("Sombrilla");
        otonoRopa.add("Guantes");
        otonoRopa.add("Gorros");
        weatherCategoryRol10.setId("otono");
        weatherCategoryRol10.setAutumnAccesories(otonoAccesorios);
        weatherCategoryRol10.setAutumnClothes(otonoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol10);

        List<String> veranoAccesorios = new ArrayList<>();
        List<String> veranoRopa = new ArrayList<>();
        veranoAccesorios.add("Gafas de sol");
        veranoRopa.add("Camisas de esquelet");
        veranoRopa.add("Chanclas");
        WeatherCategoryRol weatherCategoryRol11 = new WeatherCategoryRol();
        weatherCategoryRol11.setId("Verano");
        weatherCategoryRol11.setSummerAccesories(veranoAccesorios);
        weatherCategoryRol11.setSummerClothes(veranoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol11);

        List<String> inviernoAccesorios = new ArrayList<>();
        List<String> inviernoRopa = new ArrayList<>();
        inviernoAccesorios.add("Orejeras");
        inviernoAccesorios.add("Tabla de esquí");
        inviernoRopa.add("Botas");
        inviernoRopa.add("Tapa-bocas");
        WeatherCategoryRol weatherCategoryRol12 = new WeatherCategoryRol();
        weatherCategoryRol12.setId("Invierno");
        weatherCategoryRol12.setWinterAccesories(inviernoAccesorios);
        weatherCategoryRol12.setWinterClothes(inviernoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol12);


        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje con mascotas", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje como Mochilero", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje en pareja", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje como turist", "cualquier cosa"));
        UserRolSelect user = new UserRolSelect("2", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Invierno", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Primavera", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Otoño", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Verano", "cualquier cosa"));

        mockMvc.perform( put("/api/create/weather?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBePutUserRolSelectAccessories() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("3", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/accessories?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBePutUserRolSelectOnHand() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("4", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/onhand?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBePutUserRolSelectCleanliness() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("5", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/cleanliness?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBePutUserRolSelectShopping() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("6", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/shopping?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBePutUserRolSelectMedicine() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("7", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/medicine?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBePutUserRolSelectClothes() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("8", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/clothes?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void severalBePutUserRolSelectSeveral() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("9", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/several?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }


    @Test
    void shouldBePassAllWeather() throws Exception {
        List<String> salud = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Salud");
        weatherCategoryRol.setHealth(salud);
        weatherCategoryRolRepository.save(weatherCategoryRol);

        List<String> aseo = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol2 = new WeatherCategoryRol();
        weatherCategoryRol2.setId("Aseo");
        weatherCategoryRol2.setCleanness(aseo);
        weatherCategoryRolRepository.save(weatherCategoryRol2);

        List<String> mano = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol3 = new WeatherCategoryRol();
        weatherCategoryRol3.setId("Mano");
        weatherCategoryRol3.setOnHand(mano);
        weatherCategoryRolRepository.save(weatherCategoryRol3);

        List<String>  trabajoAccesorios = new ArrayList<>();
        List<String>  trabajoRopa = new ArrayList<>();
        List<String>  trabajoSalud = new ArrayList<>();
        List<String>  trabajoMano= new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol4 = new WeatherCategoryRol();
        weatherCategoryRol4.setId("Trabajo");
        weatherCategoryRol4.setWorkAccesories(trabajoAccesorios);
        weatherCategoryRol4.setWorkClothes(trabajoRopa);
        weatherCategoryRol4.setWorkHealth(trabajoSalud);
        weatherCategoryRol4.setWorkOnHand(trabajoMano);
        weatherCategoryRolRepository.save(weatherCategoryRol4);

        List<String> turistaAccesorios = new ArrayList<>();
        List<String> turistaRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol5 = new WeatherCategoryRol();
        weatherCategoryRol5.setId("Turista");
        weatherCategoryRol5.setTouristAccesories(turistaAccesorios);
        weatherCategoryRol5.setTouristClothes(turistaRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol5);

        List<String> parejaAccesorios = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol6 = new WeatherCategoryRol();
        weatherCategoryRol6.setId("Pareja");
        weatherCategoryRol6.setCoupleAcceosires(parejaAccesorios);
        weatherCategoryRolRepository.save(weatherCategoryRol6);

        List<String> mochileroAccesorios = new ArrayList<>();
        List<String> mochileroRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol7 = new WeatherCategoryRol();
        weatherCategoryRol7.setId("Mochilero");
        weatherCategoryRol7.setBackpackerAccesories(mochileroAccesorios);
        weatherCategoryRol7.setBackpackerClothes(mochileroRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol7);

        List<String> mascotaAccesorios= new ArrayList<>();
        List<String> mascotaRopa = new ArrayList<>();
        List<String> mascotaSalud = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol8 = new WeatherCategoryRol();
        weatherCategoryRol8.setId("Mascota");
        weatherCategoryRol8.setPetsAccesories(mascotaAccesorios);
        weatherCategoryRol8.setPetsClothes(mascotaRopa);
        weatherCategoryRol8.setPetsOnHand(mascotaSalud);
        weatherCategoryRolRepository.save(weatherCategoryRol8);

        List<String> primaverAccesorios = new ArrayList<>();
        List<String> primaveraRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol9 = new WeatherCategoryRol();
        weatherCategoryRol9.setId("Primavera");
        weatherCategoryRol9.setSpringAccesories(primaverAccesorios);
        weatherCategoryRol9.setSpringClothes(primaveraRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol9);

        List<String> otonoAccesorios = new ArrayList<>();
        List<String> otonoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol10 = new WeatherCategoryRol();
        weatherCategoryRol10.setAutumnAccesories(otonoAccesorios);
        weatherCategoryRol10.setAutumnClothes(otonoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol10);

        List<String> veranoAccesorios = new ArrayList<>();
        List<String> veranoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol11 = new WeatherCategoryRol();
        weatherCategoryRol11.setId("Verano");
        weatherCategoryRol11.setSummerAccesories(veranoAccesorios);
        weatherCategoryRol11.setSummerClothes(veranoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol11);

        List<String> inviernoAccesorios = new ArrayList<>();
        List<String> inviernoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol12 = new WeatherCategoryRol();
        weatherCategoryRol12.setId("Invierno");
        weatherCategoryRol12.setWinterAccesories(inviernoAccesorios);
        weatherCategoryRol12.setWinterClothes(inviernoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol12);


        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje con mascotas", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje como Mochilero", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje en pareja", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje como turista", "cualquier cosa"));
        UserRolSelect user = new UserRolSelect("10", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Otoño", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Primavera", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Invierno", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Verano", "cualquier cosa"));


        mockMvc.perform( put("/api/create/weather?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBePassWithAllNull() throws Exception {
        List<String> salud = new ArrayList<>();
        salud.add("Formulas medicas");
        salud.add("Mareol");
        salud.add("Pastas para la tensión");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Salud");
        weatherCategoryRol.setHealth(salud);
        weatherCategoryRolRepository.save(weatherCategoryRol);

        List<String> aseo = new ArrayList<>();
        aseo.add("Cuchilla de afeitar");
        aseo.add("Peinillas");
        WeatherCategoryRol weatherCategoryRol2 = new WeatherCategoryRol();
        weatherCategoryRol2.setId("Aseo");
        weatherCategoryRol2.setCleanness(aseo);
        weatherCategoryRolRepository.save(weatherCategoryRol2);

        List<String> mano = new ArrayList<>();
        mano.add("Papeles");
        mano.add("Dinero");
        WeatherCategoryRol weatherCategoryRol3 = new WeatherCategoryRol();
        weatherCategoryRol3.setId("Mano");
        weatherCategoryRol3.setOnHand(mano);
        weatherCategoryRolRepository.save(weatherCategoryRol3);

        List<String>  trabajoAccesorios = new ArrayList<>();
        List<String>  trabajoRopa = new ArrayList<>();
        List<String>  trabajoSalud = new ArrayList<>();
        List<String>  trabajoMano= new ArrayList<>();
        trabajoAccesorios.add("Computador");
        trabajoAccesorios.add("Mouse");
        trabajoRopa.add("Casco");
        trabajoSalud.add("Seguro medico");
        trabajoMano.add("Celular");
        WeatherCategoryRol weatherCategoryRol4 = new WeatherCategoryRol();
        weatherCategoryRol4.setId("Trabajo");
        weatherCategoryRol4.setWorkAccesories(trabajoAccesorios);
        weatherCategoryRol4.setWorkClothes(trabajoRopa);
        weatherCategoryRol4.setWorkHealth(trabajoSalud);
        weatherCategoryRol4.setWorkOnHand(trabajoMano);
        weatherCategoryRolRepository.save(weatherCategoryRol4);

        List<String> turistaAccesorios = new ArrayList<>();
        List<String> turistaRopa = new ArrayList<>();
        turistaAccesorios.add("Maleta");
        turistaAccesorios.add("Mapa");
        turistaRopa.add("Vestidos");
        turistaRopa.add("Sandalias");
        WeatherCategoryRol weatherCategoryRol5 = new WeatherCategoryRol();
        weatherCategoryRol5.setId("Turista");
        weatherCategoryRol5.setTouristAccesories(turistaAccesorios);
        weatherCategoryRol5.setTouristClothes(turistaRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol5);

        List<String> parejaAccesorios = new ArrayList<>();
        parejaAccesorios.add("Silla para bebe");
        WeatherCategoryRol weatherCategoryRol6 = new WeatherCategoryRol();
        weatherCategoryRol6.setId("Pareja");
        weatherCategoryRol6.setCoupleAcceosires(parejaAccesorios);
        weatherCategoryRolRepository.save(weatherCategoryRol6);

        List<String> mochileroAccesorios = new ArrayList<>();
        List<String> mochileroRopa = new ArrayList<>();
        mochileroAccesorios.add("Brújula");
        mochileroAccesorios.add("Hoyas");
        mochileroAccesorios.add("Bloqueador");
        mochileroRopa.add("Chaquetas");
        WeatherCategoryRol weatherCategoryRol7 = new WeatherCategoryRol();
        weatherCategoryRol7.setId("Mochilero");
        weatherCategoryRol7.setBackpackerAccesories(mochileroAccesorios);
        weatherCategoryRol7.setBackpackerClothes(mochileroRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol7);

        List<String> mascotaAccesorios= new ArrayList<>();
        List<String> mascotaRopa = new ArrayList<>();
        List<String> mascotaSalud = new ArrayList<>();
        mascotaAccesorios.add("Cama de la mascota");
        mascotaSalud.add("Medicamento contra garrapatas");
        mascotaRopa.add("Orejeras");
        WeatherCategoryRol weatherCategoryRol8 = new WeatherCategoryRol();
        weatherCategoryRol8.setId("Mascota");
        weatherCategoryRol8.setPetsAccesories(mascotaAccesorios);
        weatherCategoryRol8.setPetsClothes(mascotaRopa);
        weatherCategoryRol8.setPetsOnHand(mascotaSalud);
        weatherCategoryRolRepository.save(weatherCategoryRol8);

        List<String> primaverAccesorios = new ArrayList<>();
        List<String> primaveraRopa = new ArrayList<>();
        primaverAccesorios.add("Gafas");
        primaverAccesorios.add("Balacas");
        primaveraRopa.add("Chanclas");
        primaveraRopa.add("Tenis");
        WeatherCategoryRol weatherCategoryRol9 = new WeatherCategoryRol();
        weatherCategoryRol9.setId("Primavera");
        weatherCategoryRol9.setSpringAccesories(primaverAccesorios);
        weatherCategoryRol9.setSpringClothes(primaveraRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol9);

        List<String> otonoAccesorios = new ArrayList<>();
        List<String> otonoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol10 = new WeatherCategoryRol();
        otonoAccesorios.add("Sombrilla");
        otonoRopa.add("Guantes");
        otonoRopa.add("Gorros");
        weatherCategoryRol10.setId("Otoño");
        weatherCategoryRol10.setAutumnAccesories(otonoAccesorios);
        weatherCategoryRol10.setAutumnClothes(otonoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol10);

        List<String> veranoAccesorios = new ArrayList<>();
        List<String> veranoRopa = new ArrayList<>();
        veranoAccesorios.add("Gafas de sol");
        veranoRopa.add("Camisas de esquelet");
        veranoRopa.add("Chanclas");
        WeatherCategoryRol weatherCategoryRol11 = new WeatherCategoryRol();
        weatherCategoryRol11.setId("Verano");
        weatherCategoryRol11.setSummerAccesories(veranoAccesorios);
        weatherCategoryRol11.setSummerClothes(veranoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol11);

        List<String> inviernoAccesorios = new ArrayList<>();
        List<String> inviernoRopa = new ArrayList<>();
        inviernoAccesorios.add("Orejeras");
        inviernoAccesorios.add("Tabla de esquí");
        inviernoRopa.add("Botas");
        inviernoRopa.add("Tapa-bocas");
        WeatherCategoryRol weatherCategoryRol12 = new WeatherCategoryRol();
        weatherCategoryRol12.setId("Invierno");
        weatherCategoryRol12.setWinterAccesories(inviernoAccesorios);
        weatherCategoryRol12.setWinterClothes(inviernoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol12);



        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje con mascotas", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje como Mochilero", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje en pareja", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje como turist", "cualquier cosa"));
        UserRolSelect user = new UserRolSelect("11", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Primavera", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Otoño", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Invierno", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Verano", "cualquier cosa"));

        mockMvc.perform( put("/api/create/weather?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBegetAllWeaterClothes() throws Exception {
        List<String> salud = new ArrayList<>();
        salud.add("Formulas medicas");
        salud.add("Mareol");
        salud.add("Pastas para la tensión");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Salud");
        weatherCategoryRol.setHealth(salud);
        weatherCategoryRolRepository.save(weatherCategoryRol);

        List<String> aseo = new ArrayList<>();
        aseo.add("Cuchilla de afeitar");
        aseo.add("Peinillas");
        WeatherCategoryRol weatherCategoryRol2 = new WeatherCategoryRol();
        weatherCategoryRol2.setId("Aseo");
        weatherCategoryRol2.setCleanness(aseo);
        weatherCategoryRolRepository.save(weatherCategoryRol2);

        List<String> mano = new ArrayList<>();
        mano.add("Papeles");
        mano.add("Dinero");
        WeatherCategoryRol weatherCategoryRol3 = new WeatherCategoryRol();
        weatherCategoryRol3.setId("Mano");
        weatherCategoryRol3.setOnHand(mano);
        weatherCategoryRolRepository.save(weatherCategoryRol3);

        List<String>  trabajoAccesorios = new ArrayList<>();
        List<String>  trabajoRopa = new ArrayList<>();
        List<String>  trabajoSalud = new ArrayList<>();
        List<String>  trabajoMano= new ArrayList<>();
        trabajoAccesorios.add("Computador");
        trabajoAccesorios.add("Mouse");
        trabajoRopa.add("Casco");
        trabajoSalud.add("Seguro medico");
        trabajoMano.add("Celular");
        WeatherCategoryRol weatherCategoryRol4 = new WeatherCategoryRol();
        weatherCategoryRol4.setId("Trabajo");
        weatherCategoryRol4.setWorkAccesories(trabajoAccesorios);
        weatherCategoryRol4.setWorkClothes(trabajoRopa);
        weatherCategoryRol4.setWorkHealth(trabajoSalud);
        weatherCategoryRol4.setWorkOnHand(trabajoMano);
        weatherCategoryRolRepository.save(weatherCategoryRol4);

        List<String> turistaAccesorios = new ArrayList<>();
        List<String> turistaRopa = new ArrayList<>();
        turistaAccesorios.add("Maleta");
        turistaAccesorios.add("Mapa");
        turistaRopa.add("Vestidos");
        turistaRopa.add("Sandalias");
        WeatherCategoryRol weatherCategoryRol5 = new WeatherCategoryRol();
        weatherCategoryRol5.setId("Turista");
        weatherCategoryRol5.setTouristAccesories(turistaAccesorios);
        weatherCategoryRol5.setTouristClothes(turistaRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol5);

        List<String> parejaAccesorios = new ArrayList<>();
        parejaAccesorios.add("Silla para bebe");
        WeatherCategoryRol weatherCategoryRol6 = new WeatherCategoryRol();
        weatherCategoryRol6.setId("Pareja");
        weatherCategoryRol6.setCoupleAcceosires(parejaAccesorios);
        weatherCategoryRolRepository.save(weatherCategoryRol6);

        List<String> mochileroAccesorios = new ArrayList<>();
        List<String> mochileroRopa = new ArrayList<>();
        mochileroAccesorios.add("Brújula");
        mochileroAccesorios.add("Hoyas");
        mochileroAccesorios.add("Bloqueador");
        mochileroRopa.add("Chaquetas");
        WeatherCategoryRol weatherCategoryRol7 = new WeatherCategoryRol();
        weatherCategoryRol7.setId("Mochilero");
        weatherCategoryRol7.setBackpackerAccesories(mochileroAccesorios);
        weatherCategoryRol7.setBackpackerClothes(mochileroRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol7);

        List<String> mascotaAccesorios= new ArrayList<>();
        List<String> mascotaRopa = new ArrayList<>();
        List<String> mascotaSalud = new ArrayList<>();
        mascotaAccesorios.add("Cama de la mascota");
        mascotaSalud.add("Medicamento contra garrapatas");
        WeatherCategoryRol weatherCategoryRol8 = new WeatherCategoryRol();
        weatherCategoryRol8.setId("Mascota");
        weatherCategoryRol8.setPetsAccesories(mascotaAccesorios);
        weatherCategoryRol8.setPetsClothes(mascotaRopa);
        weatherCategoryRol8.setPetsOnHand(mascotaSalud);
        weatherCategoryRolRepository.save(weatherCategoryRol8);

        List<String> primaverAccesorios = new ArrayList<>();
        List<String> primaveraRopa = new ArrayList<>();
        primaverAccesorios.add("Gafas");
        primaverAccesorios.add("Balacas");
        primaveraRopa.add("Chanclas");
        primaveraRopa.add("Tenis");
        WeatherCategoryRol weatherCategoryRol9 = new WeatherCategoryRol();
        weatherCategoryRol9.setId("Primavera");
        weatherCategoryRol9.setSpringAccesories(primaverAccesorios);
        weatherCategoryRol9.setSpringClothes(primaveraRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol9);

        List<String> otonoAccesorios = new ArrayList<>();
        List<String> otonoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol10 = new WeatherCategoryRol();
        otonoAccesorios.add("Sombrilla");
        otonoRopa.add("Guantes");
        otonoRopa.add("Gorros");
        weatherCategoryRol10.setId("otono");
        weatherCategoryRol10.setAutumnAccesories(otonoAccesorios);
        weatherCategoryRol10.setAutumnClothes(otonoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol10);

        List<String> veranoAccesorios = new ArrayList<>();
        List<String> veranoRopa = new ArrayList<>();
        veranoAccesorios.add("Gafas de sol");
        veranoRopa.add("Camisas de esquelet");
        veranoRopa.add("Chanclas");
        WeatherCategoryRol weatherCategoryRol11 = new WeatherCategoryRol();
        weatherCategoryRol11.setId("Verano");
        weatherCategoryRol11.setSummerAccesories(veranoAccesorios);
        weatherCategoryRol11.setSummerClothes(veranoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol11);

        List<String> inviernoAccesorios = new ArrayList<>();
        List<String> inviernoRopa = new ArrayList<>();
        inviernoAccesorios.add("Orejeras");
        inviernoAccesorios.add("Tabla de esquí");
        inviernoRopa.add("Botas");
        inviernoRopa.add("Tapa-bocas");
        WeatherCategoryRol weatherCategoryRol12 = new WeatherCategoryRol();
        weatherCategoryRol12.setId("Invierno");
        weatherCategoryRol12.setWinterAccesories(inviernoAccesorios);
        weatherCategoryRol12.setWinterClothes(inviernoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol12);



        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje con mascotas", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje como Mochilero", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje en pareja", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje como turist", "cualquier cosa"));
        UserRolSelect user = new UserRolSelect("12", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Primavera", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Otoño", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Invierno", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Verano", "cualquier cosa"));

        mockMvc.perform( put("/api/create/weather?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBegetAllWeaterAccespries() throws Exception {
        List<String> salud = new ArrayList<>();
        salud.add("Formulas medicas");
        salud.add("Mareol");
        salud.add("Pastas para la tensión");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Salud");
        weatherCategoryRol.setHealth(salud);
        weatherCategoryRolRepository.save(weatherCategoryRol);

        List<String> aseo = new ArrayList<>();
        aseo.add("Cuchilla de afeitar");
        aseo.add("Peinillas");
        WeatherCategoryRol weatherCategoryRol2 = new WeatherCategoryRol();
        weatherCategoryRol2.setId("Aseo");
        weatherCategoryRol2.setCleanness(aseo);
        weatherCategoryRolRepository.save(weatherCategoryRol2);

        List<String> mano = new ArrayList<>();
        mano.add("Papeles");
        mano.add("Dinero");
        WeatherCategoryRol weatherCategoryRol3 = new WeatherCategoryRol();
        weatherCategoryRol3.setId("Mano");
        weatherCategoryRol3.setOnHand(mano);
        weatherCategoryRolRepository.save(weatherCategoryRol3);

        List<String>  trabajoAccesorios = new ArrayList<>();
        List<String>  trabajoRopa = new ArrayList<>();
        List<String>  trabajoSalud = new ArrayList<>();
        List<String>  trabajoMano= new ArrayList<>();
        trabajoAccesorios.add("Computador");
        trabajoAccesorios.add("Mouse");
        trabajoRopa.add("Casco");
        trabajoSalud.add("Seguro medico");
        trabajoMano.add("Celular");
        WeatherCategoryRol weatherCategoryRol4 = new WeatherCategoryRol();
        weatherCategoryRol4.setId("Trabajo");
        weatherCategoryRol4.setWorkAccesories(trabajoAccesorios);
        weatherCategoryRol4.setWorkClothes(trabajoRopa);
        weatherCategoryRol4.setWorkHealth(trabajoSalud);
        weatherCategoryRol4.setWorkOnHand(trabajoMano);
        weatherCategoryRolRepository.save(weatherCategoryRol4);

        List<String> turistaAccesorios = new ArrayList<>();
        List<String> turistaRopa = new ArrayList<>();
        turistaAccesorios.add("Maleta");
        turistaAccesorios.add("Mapa");
        turistaRopa.add("Vestidos");
        turistaRopa.add("Sandalias");
        WeatherCategoryRol weatherCategoryRol5 = new WeatherCategoryRol();
        weatherCategoryRol5.setId("Turista");
        weatherCategoryRol5.setTouristAccesories(turistaAccesorios);
        weatherCategoryRol5.setTouristClothes(turistaRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol5);

        List<String> parejaAccesorios = new ArrayList<>();
        parejaAccesorios.add("Silla para bebe");
        WeatherCategoryRol weatherCategoryRol6 = new WeatherCategoryRol();
        weatherCategoryRol6.setId("Pareja");
        weatherCategoryRol6.setCoupleAcceosires(parejaAccesorios);
        weatherCategoryRolRepository.save(weatherCategoryRol6);

        List<String> mochileroAccesorios = new ArrayList<>();
        List<String> mochileroRopa = new ArrayList<>();
        mochileroAccesorios.add("Brújula");
        mochileroAccesorios.add("Hoyas");
        mochileroAccesorios.add("Bloqueador");
        mochileroRopa.add("Chaquetas");
        WeatherCategoryRol weatherCategoryRol7 = new WeatherCategoryRol();
        weatherCategoryRol7.setId("Mochilero");
        weatherCategoryRol7.setBackpackerAccesories(mochileroAccesorios);
        weatherCategoryRol7.setBackpackerClothes(mochileroRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol7);

        List<String> mascotaAccesorios= new ArrayList<>();
        List<String> mascotaRopa = new ArrayList<>();
        List<String> mascotaSalud = new ArrayList<>();
        mascotaAccesorios.add("Cama de la mascota");
        mascotaSalud.add("Medicamento contra garrapatas");
        WeatherCategoryRol weatherCategoryRol8 = new WeatherCategoryRol();
        weatherCategoryRol8.setId("Mascota");
        weatherCategoryRol8.setPetsAccesories(mascotaAccesorios);
        weatherCategoryRol8.setPetsClothes(mascotaRopa);
        weatherCategoryRol8.setPetsOnHand(mascotaSalud);
        weatherCategoryRolRepository.save(weatherCategoryRol8);

        List<String> primaverAccesorios = new ArrayList<>();
        List<String> primaveraRopa = new ArrayList<>();
        primaverAccesorios.add("Gafas");
        primaverAccesorios.add("Balacas");
        primaveraRopa.add("Chanclas");
        primaveraRopa.add("Tenis");
        WeatherCategoryRol weatherCategoryRol9 = new WeatherCategoryRol();
        weatherCategoryRol9.setId("Primavera");
        weatherCategoryRol9.setSpringAccesories(primaverAccesorios);
        weatherCategoryRol9.setSpringClothes(primaveraRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol9);

        List<String> otonoAccesorios = new ArrayList<>();
        List<String> otonoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol10 = new WeatherCategoryRol();
        otonoAccesorios.add("Sombrilla");
        otonoRopa.add("Guantes");
        otonoRopa.add("Gorros");
        weatherCategoryRol10.setId("otono");
        weatherCategoryRol10.setAutumnAccesories(otonoAccesorios);
        weatherCategoryRol10.setAutumnClothes(otonoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol10);

        List<String> veranoAccesorios = new ArrayList<>();
        List<String> veranoRopa = new ArrayList<>();
        veranoAccesorios.add("Gafas de sol");
        veranoRopa.add("Camisas de esquelet");
        veranoRopa.add("Chanclas");
        WeatherCategoryRol weatherCategoryRol11 = new WeatherCategoryRol();
        weatherCategoryRol11.setId("Verano");
        weatherCategoryRol11.setSummerAccesories(veranoAccesorios);
        weatherCategoryRol11.setSummerClothes(veranoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol11);

        List<String> inviernoAccesorios = new ArrayList<>();
        List<String> inviernoRopa = new ArrayList<>();
        inviernoAccesorios.add("Orejeras");
        inviernoAccesorios.add("Tabla de esquí");
        inviernoRopa.add("Botas");
        inviernoRopa.add("Tapa-bocas");
        WeatherCategoryRol weatherCategoryRol12 = new WeatherCategoryRol();
        weatherCategoryRol12.setId("Invierno");
        weatherCategoryRol12.setWinterAccesories(inviernoAccesorios);
        weatherCategoryRol12.setWinterClothes(inviernoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol12);



        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje con mascotas", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje como Mochilero", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje en pareja", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(false,"Viaje como turist", "cualquier cosa"));
        UserRolSelect user = new UserRolSelect("13", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Primavera", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Otoño", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Invierno", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Verano", "cualquier cosa"));

        mockMvc.perform( put("/api/create/weather?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    void shouldBegetAllWeaterAccespriesOFWinner() throws Exception {
        List<String> salud = new ArrayList<>();
        salud.add("Formulas medicas");
        salud.add("Mareol");
        salud.add("Orejeras");
        salud.add("Pastas para la tensión");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Salud");
        weatherCategoryRol.setHealth(salud);
        weatherCategoryRolRepository.save(weatherCategoryRol);

        List<String> aseo = new ArrayList<>();
        aseo.add("Cuchilla de afeitar");
        aseo.add("Peinillas");
        aseo.add("Orejeras");
        WeatherCategoryRol weatherCategoryRol2 = new WeatherCategoryRol();
        weatherCategoryRol2.setId("Aseo");
        weatherCategoryRol2.setCleanness(aseo);
        weatherCategoryRolRepository.save(weatherCategoryRol2);

        List<String> mano = new ArrayList<>();
        mano.add("Papeles");
        mano.add("Orejeras");
        mano.add("Dinero");
        WeatherCategoryRol weatherCategoryRol3 = new WeatherCategoryRol();
        weatherCategoryRol3.setId("Mano");
        weatherCategoryRol3.setOnHand(mano);
        weatherCategoryRolRepository.save(weatherCategoryRol3);

        List<String>  trabajoAccesorios = new ArrayList<>();
        List<String>  trabajoRopa = new ArrayList<>();
        List<String>  trabajoSalud = new ArrayList<>();
        List<String>  trabajoMano= new ArrayList<>();
        trabajoAccesorios.add("Computador");
        trabajoAccesorios.add("Mouse");
        trabajoRopa.add("Casco");
        trabajoSalud.add("Seguro medico");
        trabajoMano.add("Celular");
        trabajoMano.add("Orejeras");
        trabajoRopa.add("Orejeras");
        trabajoSalud.add("Orejeras");
        trabajoAccesorios.add("Orejeras");
        WeatherCategoryRol weatherCategoryRol4 = new WeatherCategoryRol();
        weatherCategoryRol4.setId("Trabajo");
        weatherCategoryRol4.setWorkAccesories(trabajoAccesorios);
        weatherCategoryRol4.setWorkClothes(trabajoRopa);
        weatherCategoryRol4.setWorkHealth(trabajoSalud);
        weatherCategoryRol4.setWorkOnHand(trabajoMano);
        weatherCategoryRolRepository.save(weatherCategoryRol4);

        List<String> turistaAccesorios = new ArrayList<>();
        List<String> turistaRopa = new ArrayList<>();
        turistaAccesorios.add("Maleta");
        turistaAccesorios.add("Orejeras");
        turistaAccesorios.add("Mapa");
        turistaAccesorios.add("Otracosa1");
        turistaAccesorios.add("Otracosa2");
        turistaRopa.add("Orejeras");
        turistaRopa.add("Vestidos");
        turistaRopa.add("Sandalias");
        turistaRopa.add("SandaliasOTracosa");
        turistaRopa.add("Sandaliasqueseyo");
        WeatherCategoryRol weatherCategoryRol5 = new WeatherCategoryRol();
        weatherCategoryRol5.setId("Turista");
        weatherCategoryRol5.setTouristAccesories(turistaAccesorios);
        weatherCategoryRol5.setTouristClothes(turistaRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol5);

        List<String> parejaAccesorios = new ArrayList<>();
        parejaAccesorios.add("Silla para bebe");
        WeatherCategoryRol weatherCategoryRol6 = new WeatherCategoryRol();
        weatherCategoryRol6.setId("Pareja");
        weatherCategoryRol6.setCoupleAcceosires(parejaAccesorios);
        weatherCategoryRolRepository.save(weatherCategoryRol6);

        List<String> mochileroAccesorios = new ArrayList<>();
        List<String> mochileroRopa = new ArrayList<>();
        mochileroAccesorios.add("Brújula");
        mochileroAccesorios.add("Hoyas");
        mochileroAccesorios.add("Orejeras");
        mochileroAccesorios.add("Bloqueador");
        mochileroRopa.add("Chaquetas");
        mochileroRopa.add("Orejeras");
        WeatherCategoryRol weatherCategoryRol7 = new WeatherCategoryRol();
        weatherCategoryRol7.setId("Mochilero");
        weatherCategoryRol7.setBackpackerAccesories(mochileroAccesorios);
        weatherCategoryRol7.setBackpackerClothes(mochileroRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol7);

        List<String> mascotaAccesorios= new ArrayList<>();
        List<String> mascotaRopa = new ArrayList<>();
        List<String> mascotaSalud = new ArrayList<>();
        mascotaAccesorios.add("Cama de la mascota");
        mascotaAccesorios.add("Orejeras");
        mascotaSalud.add("Medicamento contra garrapatas");
        mascotaSalud.add("Orejeras");
        mascotaRopa.add("Orejeras");
        mascotaRopa.add("Otracosa");
        WeatherCategoryRol weatherCategoryRol8 = new WeatherCategoryRol();
        weatherCategoryRol8.setId("Mascota");
        weatherCategoryRol8.setPetsAccesories(mascotaAccesorios);
        weatherCategoryRol8.setPetsClothes(mascotaRopa);
        weatherCategoryRol8.setPetsOnHand(mascotaSalud);
        weatherCategoryRolRepository.save(weatherCategoryRol8);

        List<String> primaverAccesorios = new ArrayList<>();
        List<String> primaveraRopa = new ArrayList<>();
        primaverAccesorios.add("Gafas");
        primaverAccesorios.add("Balacas");
        primaverAccesorios.add("Orejeras");
        primaverAccesorios.add("Orejeras");
        primaveraRopa.add("Orejeras");
        primaveraRopa.add("Chanclas");
        primaveraRopa.add("Tenis");
        primaveraRopa.add("Orejeras");
        WeatherCategoryRol weatherCategoryRol9 = new WeatherCategoryRol();
        weatherCategoryRol9.setId("Primavera");
        weatherCategoryRol9.setSpringAccesories(primaverAccesorios);
        weatherCategoryRol9.setSpringClothes(primaveraRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol9);

        List<String> otonoAccesorios = new ArrayList<>();
        List<String> otonoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol10 = new WeatherCategoryRol();
        otonoAccesorios.add("Sombrilla");
        otonoAccesorios.add("Orejeras");
        otonoRopa.add("Guantes");
        otonoRopa.add("Orejeras");
        otonoRopa.add("Gorros");
        weatherCategoryRol10.setId("Otoño");
        weatherCategoryRol10.setAutumnAccesories(otonoAccesorios);
        weatherCategoryRol10.setAutumnClothes(otonoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol10);

        List<String> veranoAccesorios = new ArrayList<>();
        List<String> veranoRopa = new ArrayList<>();
        veranoAccesorios.add("Gafas de sol");
        veranoAccesorios.add("Orejeras");
        veranoRopa.add("Orejeras");
        veranoRopa.add("Camisas de esquelet");
        veranoRopa.add("Chanclas");
        WeatherCategoryRol weatherCategoryRol11 = new WeatherCategoryRol();
        weatherCategoryRol11.setId("Verano");
        weatherCategoryRol11.setSummerAccesories(veranoAccesorios);
        weatherCategoryRol11.setSummerClothes(veranoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol11);

        List<String> inviernoAccesorios = new ArrayList<>();
        List<String> inviernoRopa = new ArrayList<>();
        inviernoAccesorios.add("Orejeras");
        inviernoAccesorios.add("Tabla de esquí");
        inviernoRopa.add("Orejeras");
        inviernoRopa.add("Botas");
        inviernoRopa.add("Tapa-bocas");
        WeatherCategoryRol weatherCategoryRol12 = new WeatherCategoryRol();
        weatherCategoryRol12.setId("Invierno");
        weatherCategoryRol12.setWinterAccesories(inviernoAccesorios);
        weatherCategoryRol12.setWinterClothes(inviernoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol12);



        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje con mascotas", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje como Mochilero", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje en pareja", "cualquier cosa"));
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje como turist", "cualquier cosa"));
        UserRolSelect user = new UserRolSelect("14", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Primavera", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Otoño", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Invierno", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Verano", "cualquier cosa"));

        mockMvc.perform( put("/api/create/weather?id="+id).header("Authorization", "Bearer "+jwtlUtils.getTokenString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }


    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
