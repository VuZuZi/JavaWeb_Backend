package model;

public class phong {
    private int id;
    private double gia;

    public phong(int id, double gia) {
        this.id = id;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
