package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.Context;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;

public class DBAdmin {
    //New Properties
    DBHelper dbHelper;
    //Cau Truy Van:

    String sql = "Create Table " + DBHelper.TABLE_ADMIN
            + "(" + DBHelper.COL_USER + " text ,"
            + DBHelper.COL_PASS + " text )";


    public DBAdmin(Context context) {
        dbHelper = new DBHelper(context, DBHelper.NAME_DATABASE);
        dbHelper.setSql(sql);
    }
}
