package tdc.edu.vn.quanly_dathang_xemay.model;

public   class DonDatHang {
    private String maDDH;
    private String ngayLap;

    public DonDatHang() {
    }

    public DonDatHang(String maDDH, String ngayLap) {
        this.maDDH = maDDH;
        this.ngayLap = ngayLap;
    }

    public DonDatHang(String maDDH) {
        this.maDDH = maDDH;
    }

    public String getMaDDH() {
        return maDDH;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
}
