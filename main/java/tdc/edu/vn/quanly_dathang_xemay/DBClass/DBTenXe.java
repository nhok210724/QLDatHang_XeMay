package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.Context;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;

public class DBTenXe {
    //New Properties
    DBHelper dbHelper;
    //Cau Truy Van:

    String sql = "Create Table " + DBHelper.TABLE_TENXE
            + "(" + DBHelper.COL_MAXE + " text PRIMARY KEY,"
            + DBHelper.COL_TENXE + " Int,"
            + DBHelper.COL_DUNGTICH + " Int,"
            + DBHelper.COL_SOLUONGXE + " int,"
            + DBHelper.COL_MALOAI + " text, "
            + "CONSTRAINT fk_TenXe_MaLoai" +
            "   FOREIGN KEY (" + DBHelper.COL_MALOAI + ")" +
            "   REFERENCES " + DBHelper.TABLE_CTYXE + " (" + DBHelper.COL_MALOAI + ")" + ")";


    public DBTenXe(Context context) {
        dbHelper = new DBHelper(context, DBHelper.NAME_DATABASE);
        dbHelper.setSql(sql);
    }
}
