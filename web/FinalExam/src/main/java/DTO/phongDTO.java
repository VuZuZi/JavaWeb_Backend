package DTO;

public class phongDTO {
    private int stt;
    private String maPhongTro;
    private String tenKhachHang;
    private String sdt;
    private String ngayBatDau;
    private String hinhThuc;
    private String ghiChu;
    private int idHD;

    public phongDTO() {
    }


    public phongDTO(int stt, String maPhongTro, String tenKhachHang, String sdt, String ngayBatDau, String hinhThuc, String ghiChu) {

        this.stt = stt;
        this.maPhongTro = maPhongTro;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.ngayBatDau = ngayBatDau;
        this.hinhThuc = hinhThuc;
        this.ghiChu = ghiChu;
    }

    public phongDTO(int stt, String maPhongTro, String tenKhachHang, String sdt, String ngayBatDau, String hinhThuc, String ghiChu, int idHD) {
        this.stt = stt;
        this.maPhongTro = maPhongTro;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.ngayBatDau = ngayBatDau;
        this.hinhThuc = hinhThuc;
        this.ghiChu = ghiChu;
        this.idHD = idHD;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaPhongTro() {
        return maPhongTro;
    }

    public void setMaPhongTro(String maPhongTro) {
        this.maPhongTro = maPhongTro;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
