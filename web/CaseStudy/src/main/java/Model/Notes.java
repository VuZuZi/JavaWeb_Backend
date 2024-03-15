package Model;

public class Notes {
    private String title;
    private String des;
    private int idType;

    public Notes() {
    }

    public Notes(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public Notes(String title, String des, int idType) {
        this.title = title;
        this.des = des;
        this.idType = idType;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
