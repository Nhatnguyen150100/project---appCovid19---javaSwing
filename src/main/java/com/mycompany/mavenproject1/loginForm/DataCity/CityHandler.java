package DataCity;

import API.City;

import java.util.ArrayList;

public class CityHandler {
    private static ArrayList<City> listCityHandler;

    public static synchronized  ArrayList<City> getListCityHandler() {
        return listCityHandler;
    }

    public static synchronized void setListCityHandler(ArrayList<City> listCityHandler) {
        CityHandler.listCityHandler = listCityHandler;
    }
}
