package tdc.edu.vn.quanly_dathang_xemay.model;

public class CtyXe {
    private String image;


    private String maLoai;
    private String tenLoai, xuatXu;

    public CtyXe() {
    }

    public CtyXe(String maLoai) {
        this.maLoai = maLoai;
    }

    public CtyXe(String maLoai, String tenLoai, String xuatXu, String image) {

        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.xuatXu = xuatXu;
        this.image = image;
    }

    public void setMaLoai(String maLoai) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
