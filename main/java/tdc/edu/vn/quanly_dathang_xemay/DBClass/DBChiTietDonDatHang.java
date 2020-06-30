package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.Context;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;

public class DBChiTietDonDatHang {
    //New Properties
    DBHelper dbHelper;
    //Cau Truy Van:

    String sql = "Create Table " + DBHelper.TABLE_CHITIETDONHANG
            + "( " + DBHelper.COL_MADONDATHANG + " text, "
            + DBHelper.COL_MAXE + " text, "
            + DBHelper.COL_SOLUONGDATHANG + " int, "
            + DBHelper.COL_DONGIA + " int, "
            + "CONSTRAINT fk_MaDonDatHang_ChiTiet" +
            "   FOREIGN KEY (" + DBHelper.COL_MADONDATHANG + ")"
            + "   REFERENCES " + DBHelper.TABLE_DONDATHANG + "(" + DBHelper.COL_MADONDATHANG + "),"
            + "CONSTRAINT fk_MaXe_ChiTiet" +
            "   FOREIGN KEY (" + DBHelper.COL_MAXE + ")"
            + "   REFERENCES " + DBHelper.TABLE_TENXE + "(" + DBHelper.COL_MAXE + ")" + ")";


    public DBChiTietDonDatHang(Context context) {
        dbHelper = new DBHelper(context, DBHelper.NAME_DATABASE);
        dbHelper.setSql(sql);
    }
}
