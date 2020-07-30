package tdc.edu.vn.quanly_dathang_xemay.model;

public class Xe extends CtyXe {
    private String image;


    private String maXe;
    private String tenXe;
    private int dungTich, soLuong;

    public Xe() {
    }

    public Xe(String maXe, String tenXe, int dungTich, int soLuong, String image) {

        this.image = image;
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.dungTich = dungTich;
        this.soLuong = soLuong;

    }

    public Xe(String maXe, String tenXe, int dungTich, int soLuong, String image, String maLoai) {
        super(maLoai);
        this.image = image;
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.dungTich = dungTich;
        this.soLuong = soLuong;

    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    @Override
    public String getMaLoai() {
        return super.getMaLoai();
    }

    public String getMaXe() {
        return maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
