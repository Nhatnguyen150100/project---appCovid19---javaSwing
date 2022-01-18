package API;

import java.util.ArrayList;

public class City {
    private String id;
    private String code;
    private String name;
    private ArrayList<District> districts;

    public City() {
    }

    public City(String id, String code, String name, ArrayList<District> districts) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.districts = districts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<District> districts) {
        this.districts = districts;
    }
}
