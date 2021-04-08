package com.eci.ieti;

import com.eci.ieti.model.WeatherCategoryRol;
import com.eci.ieti.persistence.repository.repo.WeatherCategoryRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

public class SaveData implements CommandLineRunner {

    @Autowired
    WeatherCategoryRolRepository weatherCategoryRolRepository;

    public static void main(String[] args) {
        SpringApplication.run(SaveData.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        invierno();
        verano();
        otoño();
        primaver();
        mascota();
        mochilero();
        pareja();
        turista();
        trabajo();
        aLaMano();
        aseo();
        salud();
    }

    private void salud() {
        List<String> salud = new ArrayList<>();
        salud.add("Formulas medicas");
        salud.add("Mareol");
        salud.add("Pastas para el dolor de cabeza");
        salud.add("Pomadas");
        salud.add("Pastas para la gripa");
        salud.add("Pastas para la tensión");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Salud");
        weatherCategoryRol.setHealth(salud);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void aseo() {
        List<String> aseo = new ArrayList<>();
        aseo.add("Cuchilla de afeitar");
        aseo.add("Desodorante");
        aseo.add("Cepillo de dientes");
        aseo.add("Crema dental");
        aseo.add("Shampoo");
        aseo.add("Talcos");
        aseo.add("Loción");
        aseo.add("Peinillas");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Aseo");
        weatherCategoryRol.setCleanness(aseo);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void aLaMano() {
        List<String> mano = new ArrayList<>();
        mano.add("Papeles");
        mano.add("Llaves");
        mano.add("Celular");
        mano.add("Dinero");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Mano");
        weatherCategoryRol.setOnHand(mano);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void trabajo() {
        List<String>  trabajoAccesorios = new ArrayList<>();
        List<String>  trabajoRopa = new ArrayList<>();
        List<String>  trabajoSalud = new ArrayList<>();
        List<String>  trabajoMano= new ArrayList<>();
        trabajoAccesorios.add("Computador");
        trabajoAccesorios.add("Mouse");
        trabajoAccesorios.add("Libreta");
        trabajoRopa.add("Trajes");
        trabajoRopa.add("Camisas");
        trabajoRopa.add("Corbatas");
        trabajoRopa.add("Tacones");
        trabajoRopa.add("Casco");
        trabajoSalud.add("Seguro medico");
        trabajoMano.add("Celular");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Trabajo");
        weatherCategoryRol.setWorkAccesories(trabajoAccesorios);
        weatherCategoryRol.setWorkClothes(trabajoRopa);
        weatherCategoryRol.setWorkHealth(trabajoSalud);
        weatherCategoryRol.setWorkOnHand(trabajoMano);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void turista() {
        List<String> turistaAccesorios = new ArrayList<>();
        List<String> turistaRopa = new ArrayList<>();
        turistaAccesorios.add("Maleta");
        turistaAccesorios.add("Mapa");
        turistaAccesorios.add("Celular");
        turistaAccesorios.add("Cámara");
        turistaAccesorios.add("Sombrilla");
        turistaAccesorios.add("Brújula");
        turistaAccesorios.add("Bloqueador");
        turistaAccesorios.add("Carpa");
        turistaAccesorios.add("Gorra de sol");
        turistaRopa.add("Chanclas");
        turistaRopa.add("Tenis");
        turistaRopa.add("Pantalonetas");
        turistaRopa.add("Vestidos");
        turistaRopa.add("Sandalias");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Turista");
        weatherCategoryRol.setTouristAccesories(turistaAccesorios);
        weatherCategoryRol.setTouristClothes(turistaRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void pareja() {
        List<String> parejaAccesorios = new ArrayList<>();
        parejaAccesorios.add("Silla para bebe");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Pareja");
        weatherCategoryRol.setCoupleAcceosires(parejaAccesorios);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void mochilero() {
        List<String> mochileroAccesorios = new ArrayList<>();
        List<String> mochileroRopa = new ArrayList<>();
        mochileroAccesorios.add("Brújula");
        mochileroAccesorios.add("Hoyas");
        mochileroAccesorios.add("Bloqueador");
        mochileroAccesorios.add("Carpa");
        mochileroAccesorios.add("Pipa de gas");
        mochileroAccesorios.add("Maleta");
        mochileroAccesorios.add("Mapa");
        mochileroRopa.add("Pantalonetas");
        mochileroRopa.add("Tenis");
        mochileroRopa.add("Sacos");
        mochileroRopa.add("Chaquetas");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Mochilero");
        weatherCategoryRol.setBackpackerAccesories(mochileroAccesorios);
        weatherCategoryRol.setBackpackerClothes(mochileroRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void mascota() {
        List<String> mascotaAccesorios= new ArrayList<>();
        List<String> mascotaRopa = new ArrayList<>();
        List<String> mascotaSalud = new ArrayList<>();
        mascotaAccesorios.add("Cama de la mascota");
        mascotaAccesorios.add("Jueguetes de la mascota");
        mascotaAccesorios.add("Correa");
        mascotaRopa.add("Saco para mascota");
        mascotaRopa.add("Chaqueta para mascota");
        mascotaSalud.add("Carnet de vacunas");
        mascotaSalud.add("Medicamento contra garrapatas");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Mascota");
        weatherCategoryRol.setPetsAccesories(mascotaAccesorios);
        weatherCategoryRol.setPetsClothes(mascotaRopa);
        weatherCategoryRol.setPetsOnHand(mascotaSalud);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void primaver() {
        List<String> primaverAccesorios = new ArrayList<>();
        List<String> primaveraRopa = new ArrayList<>();
        primaverAccesorios.add("Gafas");
        primaverAccesorios.add("Balacas");
        primaverAccesorios.add("Bufandas");
        primaverAccesorios.add("Gorros para el sol");
        primaveraRopa.add("Faldas");
        primaveraRopa.add("Vestidos");
        primaveraRopa.add("Pantalonetas");
        primaveraRopa.add("Chanclas");
        primaveraRopa.add("Tenis");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Primavera");
        weatherCategoryRol.setSpringAccesories(primaverAccesorios);
        weatherCategoryRol.setSpringClothes(primaveraRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void otoño() {
        List<String> otoñoAccesorios = new ArrayList<>();
        List<String> otoñoRopa = new ArrayList<>();
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        otoñoAccesorios.add("Sombrilla");
        otoñoAccesorios.add("Anteojos");
        otoñoRopa.add("Sacos");
        otoñoRopa.add("Bufandas");
        otoñoRopa.add("Guantes");
        otoñoRopa.add("Gorros");
        weatherCategoryRol.setId("Otoño");
        weatherCategoryRol.setAutumnAccesories(otoñoAccesorios);
        weatherCategoryRol.setAutumnClothes(otoñoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void verano() {
        List<String> veranoAccesorios = new ArrayList<>();
        List<String> veranoRopa = new ArrayList<>();
        veranoAccesorios.add("Gafas de sol");
        veranoAccesorios.add("Gorra de sol");
        veranoAccesorios.add("Bloqueador");
        veranoAccesorios.add("Bronceador");
        veranoRopa.add("Traje de baño");
        veranoRopa.add("Pantalonetas");
        veranoRopa.add("Camisas de esquelet");
        veranoRopa.add("Chanclas");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Verano");
        weatherCategoryRol.setSummerAccesories(veranoAccesorios);
        weatherCategoryRol.setSummerClothes(veranoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }

    private void invierno() {
        List<String> inviernoAccesorios = new ArrayList<>();
        List<String> inviernoRopa = new ArrayList<>();
        inviernoAccesorios.add("Orejeras");
        inviernoAccesorios.add("Tabla de esquí");
        inviernoAccesorios.add("Sombrilla");
        inviernoAccesorios.add("Anteojos");
        inviernoAccesorios.add("Maquillaje");
        inviernoRopa.add("Gorro");
        inviernoRopa.add("Bufanda");
        inviernoRopa.add("Chaqueta");
        inviernoRopa.add("Botas");
        inviernoRopa.add("Tapa-bocas");
        WeatherCategoryRol weatherCategoryRol = new WeatherCategoryRol();
        weatherCategoryRol.setId("Invierno");
        weatherCategoryRol.setWinterAccesories(inviernoAccesorios);
        weatherCategoryRol.setWinterClothes(inviernoRopa);
        weatherCategoryRolRepository.save(weatherCategoryRol);
    }


}
