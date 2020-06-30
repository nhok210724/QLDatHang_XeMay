package tdc.edu.vn.quanly_dathang_xemay.model;

public class ChiTietDonDatHang {
private TenXe tenXe;
private DonDatHang donDatHang;
    private int soLuongDatHang;
    private double donGia;

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

    public ChiTietDonDatHang(TenXe tenXe, DonDatHang donDatHang, int soLuongDatHang, double donGia) {
        this.tenXe = tenXe;
        this.donDatHang = donDatHang;
        this.soLuongDatHang = soLuongDatHang;
        this.donGia = donGia;
    }
}
