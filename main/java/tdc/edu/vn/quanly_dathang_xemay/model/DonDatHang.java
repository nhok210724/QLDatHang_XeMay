package tdc.edu.vn.quanly_dathang_xemay.model;

import java.util.Date;

public class DonDatHang {
    final private String maDDH;
    private Date ngayLap;

    public DonDatHang(String maDDH) {
        this.maDDH = maDDH;
    }

    public String getMaDDH() {
        return maDDH;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }
}
