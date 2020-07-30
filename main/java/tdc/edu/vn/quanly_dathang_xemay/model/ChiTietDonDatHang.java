package tdc.edu.vn.quanly_dathang_xemay.model;

public class ChiTietDonDatHang extends DonDatHang {


    private String maXe;
    private int soLuongDatHang;
    private double donGia;

    public ChiTietDonDatHang(String maDDH, String maXe, int soLuongDatHang, double donGia) {
        super(maDDH);
        this.maXe = maXe;
        this.soLuongDatHang = soLuongDatHang;
        this.donGia = donGia;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public int getSoLuongDatHang() {
        return soLuongDatHang;
    }

    public void setSoLuongDatHang(int soLuongDatHang) {
        this.soLuongDatHang = soLuongDatHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMaXe() {
        return maXe;
    }


}
