package tdc.edu.vn.quanly_dathang_xemay.model;

public class CtyXe {
    private final String maLoai;
    private String tenLoai, xuatXu;

    public CtyXe(String maLoai) {
        this.maLoai = maLoai;
    }



    public String getMaLoai() {
        return maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    @Override
    public String toString() {
        return "CtyXe{" +
                "maLoai='" + maLoai + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
                ", xuatXu='" + xuatXu + '\'' +
                '}';
    }
}
