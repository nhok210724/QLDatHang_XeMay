package tdc.edu.vn.quanly_dathang_xemay.DanhSach;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class DanhSachCtyXe {
    private ArrayList<CtyXe> ctyXes = new ArrayList<>();
    private int vitri = -1;

    public void Them(CtyXe ctyXe) {
        ctyXes.add(ctyXe);
    }

    public void Xoa(CtyXe ctyXe) {
        ctyXes.remove(ctyXe);
    }

    public void Sua(CtyXe ctyXe) {
        ctyXes.set(vitri, ctyXe);
    }

}
