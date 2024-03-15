package DTO;

public class ProductDTO {
    private int stt;
    private int id;
    private String ten;

    private double gia;
    private int so_luong;

    private String mau;
    private String mo_ta;
    private String ten_muc;

    public ProductDTO(int id, String ten, double gia, int so_luong, String mau, String mo_ta) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.so_luong = so_luong;
        this.mau = mau;
        this.mo_ta = mo_ta;
    }

    public ProductDTO(String ten, double gia, int so_luong, String mau, String mo_ta) {
        this.ten = ten;
        this.gia = gia;
        this.so_luong = so_luong;
        this.mau = mau;
        this.mo_ta = mo_ta;
    }

    public ProductDTO(String ten, double gia, int so_luong, String mau, String mo_ta, String ten_muc) {
        this.ten = ten;
        this.gia = gia;
        this.so_luong = so_luong;
        this.mau = mau;
        this.mo_ta = mo_ta;
        this.ten_muc = ten_muc;
    }

    public ProductDTO() {


    }

    public ProductDTO(int id, String ten, double gia, int so_luong, String mau, String mo_ta, String ten_muc) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.so_luong = so_luong;
        this.mau = mau;
        this.mo_ta = mo_ta;
        this.ten_muc = ten_muc;
    }

    public ProductDTO(int stt, int id, String ten, double gia, int so_luong, String mau, String mo_ta, String ten_muc) {
        this.stt = stt;
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.so_luong = so_luong;
        this.mau = mau;
        this.mo_ta = mo_ta;
        this.ten_muc = ten_muc;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public String getTen_muc() {
        return ten_muc;
    }

    public void setTen_muc(String ten_muc) {
        this.ten_muc = ten_muc;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "stt=" + stt +
                ", id=" + id +
                ", ten='" + ten + '\'' +
                ", gia=" + gia +
                ", so_luong=" + so_luong +
                ", mau='" + mau + '\'' +
                ", mo_ta='" + mo_ta + '\'' +
                ", ten_muc='" + ten_muc + '\'' +
                '}';
    }
}
