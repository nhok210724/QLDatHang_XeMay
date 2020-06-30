package tdc.edu.vn.quanly_dathang_xemay.model;

public class TenXe extends CtyXe {
    final private String maXe;
    private String tenXe;
    private int dungTich, soLuong;


    public TenXe(String maXe) {
        super(maXe);
        this.maXe = maXe;
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


}
