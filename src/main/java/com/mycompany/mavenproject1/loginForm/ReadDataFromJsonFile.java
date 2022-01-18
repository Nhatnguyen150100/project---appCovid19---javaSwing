package com.mycompany.mavenproject1.loginForm;



import API.City;
import API.District;
import API.Wards;
import DataCity.CityHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromJsonFile {

    public ReadDataFromJsonFile() {
    }

    private static  ArrayList<City> listCityData = new ArrayList<City>();
    private static final ArrayList<Wards> WardsData = new ArrayList<Wards>();
    public static void read() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("/home/nhatnguyen/netbean/mavenproject1/src/main/java/com/mycompany/mavenproject1/loginForm/resources/Json/local.json");

        JSONArray arrayLocal = (JSONArray)jsonParser.parse(reader);
        JSONObject listCityObj;

        JSONArray districts;
        int sizeAraydistricts = 0;
        int sizeArayLocal = arrayLocal.size();
        for(int i = 0; i < sizeArayLocal; i++){
            City city = new City();
            ArrayList<District> DistrictData = new ArrayList<District>();
            listCityObj = (JSONObject) arrayLocal.get(i);
            String id = (String) listCityObj.get("id");
            String name = (String) listCityObj.get("name");
            districts = (JSONArray) listCityObj.get("districts");

            sizeAraydistricts = districts.size();
            for(int j = 0; j < sizeAraydistricts; j++){
                District district = new District();
                district.setNameDistrict("");
                JSONObject districtObj = (JSONObject) districts.get(j);
                String idDistricts = (String) districtObj.get("id");
                String nameDistricts = (String) districtObj.get("name");
//                System.out.println("Name districts: "+nameDistricts);
//                wards = (JSONArray) districtObj.get("wards");
//                int sizeAraywards = wards.size()/15;
//                for(int k = 0 ; k < sizeAraywards; i++){
//                    System.out.println("start3");
//                    wardsObj = (JSONObject) districts.get(k);
//                    String nameWard = (String) wardsObj.get("name");
//                    String prefix = (String) wardsObj.get("prefix");
//                    ward.setNameWards(nameWard);
//                    ward.setPrefix(prefix);
//                    WardsData.add(ward);
//                }
                district.setIdDistrict(idDistricts);
                district.setNameDistrict(nameDistricts);
                DistrictData.add(district);
            }
            city.setId(id);
            city.setName(name);
            city.setDistricts(DistrictData);
            listCityData.add(city);
        }
        CityHandler.setListCityHandler(listCityData);

//        for(int i = 0 ; i < listCityData.size(); i++){
//            System.out.println("ID Name CITY in VIETNAM: "+listCityData.get(i).getId());
//            System.out.println("Name CITY in VIETNAM: " +listCityData.get(i).getName());
//            for(int j = 0; j < listCityData.get(i).getDistricts().size(); j++){
//                System.out.println("name d: " +listCityData.get(i).getDistricts().get(j).getNameDistrict());
//            }
//        }

    }
}
