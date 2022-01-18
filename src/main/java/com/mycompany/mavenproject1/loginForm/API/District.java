package API;

import java.util.ArrayList;

public class District {
    private String idDistrict;
    private String nameDistrict;
    private ArrayList<Wards> wards;

    public District() {
    }

    public District(String idDistrict, String nameDistrict, ArrayList<Wards> wards) {
        this.idDistrict = idDistrict;
        this.nameDistrict = nameDistrict;
        this.wards = wards;
    }

    public String getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(String idDistrict) {
        this.idDistrict = idDistrict;
    }

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    public ArrayList<Wards> getWards() {
        return wards;
    }

    public void setWards(ArrayList<Wards> wards) {
        this.wards = wards;
    }
}
