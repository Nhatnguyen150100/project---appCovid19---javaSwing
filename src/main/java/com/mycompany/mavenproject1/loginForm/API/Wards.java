package API;

public class Wards {
    private String idWards;
    private String nameWards;
    private String prefix;

    public Wards() {
    }

    public String getIdWards() {
        return idWards;
    }

    public void setIdWards(String idWards) {
        this.idWards = idWards;
    }

    public String getNameWards() {
        return nameWards;
    }

    public void setNameWards(String nameWards) {
        this.nameWards = nameWards;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Wards(String idWards, String nameWards, String prefix) {
        this.idWards = idWards;
        this.nameWards = nameWards;
        this.prefix = prefix;
    }
}
