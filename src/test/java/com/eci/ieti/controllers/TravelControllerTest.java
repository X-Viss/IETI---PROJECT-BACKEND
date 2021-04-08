package com.eci.ieti.controllers;


import com.eci.ieti.model.*;
import com.eci.ieti.persistence.repository.repo.TravelRepository;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import com.eci.ieti.persistence.repository.repo.UserRolRepository;
import com.eci.ieti.persistence.repository.repo.WeatherCategoryRolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.ResultActions;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TravelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRolRepository userRolRepository;

    @Autowired
    private WeatherCategoryRolRepository weatherCategoryRolRepository;

    @Test
    public void getTravelsShouldExist() throws Exception {
        User user = new User();
        user.setUserName("david");
        user.setpassword("123456joke");
        userRepository.save(user);
        mockMvc.perform(get("/api/travels?user=david")).andDo(print()).andExpect(status().isOk());


        User user2 = new User();
        user2.setUserName("jose");
        user2.setpassword("123456joke");
        userRepository.save(user2);
        mockMvc.perform(get("/api/travels?user=jose")).andDo(print()).andExpect(status().isOk());

        User user3 = new User();
        user3.setUserName("pepito");
        user3.setpassword("123456joke");
        userRepository.save(user3);
        mockMvc.perform(get("/api/travels?user=pepito")).andDo(print()).andExpect(status().isOk());
    }


    @Test
    public void getTravelsShouldNotExist() throws Exception {
        mockMvc.perform(get("/api/travels?user=123")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=456")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=omg")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=dfdfdf")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=45dfsdfds6")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=4sfdsfsdf56")).andDo(print()).andExpect(status().isBadRequest());
        mockMvc.perform(get("/api/travels?user=sdfsdfdsfsd456")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void getTravelShouldBeEmpty() throws Exception {
        User user = new User();
        user.setUserName("davinchi");
        user.setpassword("123456joke");
        userRepository.save(user);
        ResultActions result = mockMvc.perform(get("/api/travels?user=davinchi")).andDo(print()).andExpect(status().isOk()).andExpect(
                content().json("[]")
        );
    }

    @Test
    public void postUserRoleShouldBeCreated() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();

        mockMvc.perform( post("/api/create/rol")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(generitToUserRolWeatherOrCategoryList)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldBePutUserRolSelectDestiny() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("1", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        Country country = new Country();

        mockMvc.perform( put("/api/create/destiny?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(country)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectWeather() throws Exception {
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

        List<String> otoñoAccesorios = new ArrayList<>();
        List<String> otoñoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol10 = new WeatherCategoryRol();
        otoñoAccesorios.add("Sombrilla");
        otoñoRopa.add("Guantes");
        otoñoRopa.add("Gorros");
        weatherCategoryRol10.setId("Otoño");
        weatherCategoryRol10.setAutumnAccesories(otoñoAccesorios);
        weatherCategoryRol10.setAutumnClothes(otoñoRopa);
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
        UserRolSelect user = new UserRolSelect("2", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Primavera", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Otoño", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Invierno", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Verano", "cualquier cosa"));

        mockMvc.perform( put("/api/create/weather?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectAccessories() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("3", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/accessories?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectOnHand() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("4", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/onhand?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectCleanliness() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("5", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/cleanliness?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectShopping() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("6", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/shopping?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectMedicine() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("7", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/medicine?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void shouldBePutUserRolSelectClothes() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("8", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/clothes?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void severalBePutUserRolSelectSeveral() throws Exception {

        List<GeneritToUserRolWeatherOrCategory> generitToUserRolWeatherOrCategoryList = new ArrayList<>();
        UserRolSelect user = new UserRolSelect("9", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();

        mockMvc.perform( put("/api/create/category/several?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }


    @Test
    public void shouldBePassAllWeather() throws Exception {
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

        List<String> otoñoAccesorios = new ArrayList<>();
        List<String> otoñoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol10 = new WeatherCategoryRol();
        weatherCategoryRol10.setAutumnAccesories(otoñoAccesorios);
        weatherCategoryRol10.setAutumnClothes(otoñoRopa);
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
        generitToUserRolWeatherOrCategoryList.add(new GeneritToUserRolWeatherOrCategory(true,"Viaje con mascotas", "cualquier cosa"));
        UserRolSelect user = new UserRolSelect("10", generitToUserRolWeatherOrCategoryList);
        String id = user.getId();
        userRolRepository.insert(user);
        List<GeneritToUserRolWeatherOrCategory> weatherList = new ArrayList<>();
        weatherList.add(new GeneritToUserRolWeatherOrCategory(false, "Primavera", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Otoño", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Invierno", "cualquier cosa"));
        weatherList.add(new GeneritToUserRolWeatherOrCategory(true, "Verano", "cualquier cosa"));

        mockMvc.perform( put("/api/create/weather?id="+id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(weatherList)))
                .andDo(print())
                .andExpect(status().isAccepted());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
