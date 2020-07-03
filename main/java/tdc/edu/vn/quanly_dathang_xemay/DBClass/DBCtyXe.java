package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.Context;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;

public class DBCtyXe {
    //New Properties
    DBHelper dbHelper;
    //Cau Truy Van:

    String sql = "Create Table " + DBHelper.TABLE_CTYXE
            + "(" + DBHelper.COL_MALOAI + " text PRIMARY KEY,"
            + DBHelper.COL_TENLOAI + " text,"
            + DBHelper.COL_XUATXU + " text )";


    public DBCtyXe(Context context) {
        dbHelper.setSql(sql);
        dbHelper = new DBHelper(context, DBHelper.NAME_DATABASE);

    }


}
