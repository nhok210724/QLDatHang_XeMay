package tdc.edu.vn.quanly_dathang_xemay.model;

public class ChiTietDonDatHang extends DonDatHang {


    private String maXe;
    private int soLuongDatHang, donGia;


    public ChiTietDonDatHang(String maDDH, String maXe, int soLuongDatHang, int donGia) {
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

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getMaXe() {
        return maXe;
    }


}
