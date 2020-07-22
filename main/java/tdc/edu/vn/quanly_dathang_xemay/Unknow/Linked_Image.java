package tdc.edu.vn.quanly_dathang_xemay.Unknow;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class Linked_Image {
    String[] tenXe_img_audi = {"audi_a4", "audi_a8", "audi_q5", "audi_q7", "audi_s7", "audi_s8", "audi_sq5"};
    String[] tenXe_img_bmw = {"bmw_330i_m_sport", "bmw_530i", "bmw_i8", "bmw_m_series", "bmw_series_6", "bmw_x7", "bmw_z4"};
    String[] tenXe_img_honda = {"honda_accord", "honda_brio", "honda_city", "honda_civic", "honda_cr_v", "honda_hr_r", "honda_jazz"};
    String[] tenXe_img_merce = {"mercedes_benz_a_class", "mercedes_benz_c_class", "mercedes_benz_e_class", "mercedes_benz_g_class", "mercedes_benz_gla",
            "mercedes_benz_gle", "mercedes_maybach", "mercedes1", "mercedes2"};
    String[] tenXe_img_lambor = {"lamborghini_aventador_lp_700_4_roadster", "lamborghini_aventador_s", "lamborghini_aventador_sv_roadster"
            , "lamborghini_aventador_svj", "lamborghini_huracan_lp610_4", "lamborghini_huracan_performante_spyder", "lamborghini_sian_fkp_37"};
    String[] tenXe_img_vinfast = {"vinfast_lux", "vinfast_red", "vinfast_sedan", "vinfast_sedangold"};


    public String[] check_Img(String tenImg) {

        if (tenImg.equals("vinfast_logo")) return tenXe_img_vinfast;
        if (tenImg.equals("mercedes_logo")) return tenXe_img_merce;
        if (tenImg.equals("lamborghini_logo")) return tenXe_img_lambor;
        if (tenImg.equals("honda_logo")) return tenXe_img_honda;
        if (tenImg.equals("bmw_logo")) return tenXe_img_bmw;
        if (tenImg.equals("audi_logo")) return tenXe_img_audi;
        return null;
    }
}
