package DTO;

public class NoteDTO {
    private int id;
    private int stt;
    private String title;
    private String des;
    private String type;

    public NoteDTO() {
    }

    public NoteDTO(int id, int stt, String title, String des, String type) {
        this.id = id;
        this.stt = stt;
        this.title = title;
        this.des = des;
        this.type = type;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
