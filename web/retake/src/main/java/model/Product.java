package model;

public class Product {
    private int id;
    private String ten;

    private double gia;
    private int so_luong;

    private String mau;
    private String mo_ta;

    public Product(String name, Double price, int quan, String color, String des) {
    }

    public Product(int id, String ten, double gia, int so_luong, String mau, String mo_ta) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.so_luong = so_luong;
        this.mau = mau;
        this.mo_ta = mo_ta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }
}
