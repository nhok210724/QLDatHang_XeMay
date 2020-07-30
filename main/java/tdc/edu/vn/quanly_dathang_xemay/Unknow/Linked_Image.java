package tdc.edu.vn.quanly_dathang_xemay.Unknow;

public class Linked_Image {
    String[] tenXe_img_honda = {"logo_honda_lead", "logo_honda_sh", "logo_honda_vision", "logo_honda_wave", "logo_honda_winner_x"};
    String[] tenXe_img_kawasaki = {"logo_kawasaki_ninja_h2_sx_se", "logo_kawasaki_ninja_zx10_r", "logo_kawasaki_w175", "logo_kawasaki_z650",
            "logo_kawasaki_z1000"};

    String[] tenXe_img_suzuki = {"logo_suzuki_address", "logo_suzuki_gsx150", "logo_suzuki_impulse", "logo_suzuki_raider", "logo_suzuki_viva"};
    String[] tenXe_img_sym = {"logo_sym_angela", "logo_sym_galaxy", "logo_sym_husky"
            , "logo_sym_passing", "logo_sym_star_sr_170"};
    String[] tenXe_img_yamaha = {"logo_yamaha_exciter", "logo_yamaha_grande", "logo_yamaha_janus", "logo_yamaha_r3", "logo_yamaha_sirius"};


    public String[] check_Img(String tenImg) {

        if (tenImg.equals("logo_yamaha")) return tenXe_img_yamaha;
        if (tenImg.equals("logo_suzuki")) return tenXe_img_suzuki;
        if (tenImg.equals("logo_sym")) return tenXe_img_sym;
        if (tenImg.equals("logo_honda")) return tenXe_img_honda;
        if (tenImg.equals("logo_kawasaki")) return tenXe_img_kawasaki;

        return null;
    }
}
