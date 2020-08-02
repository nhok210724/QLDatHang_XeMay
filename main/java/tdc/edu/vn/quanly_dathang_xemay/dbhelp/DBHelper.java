package tdc.edu.vn.quanly_dathang_xemay.dbhelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBChiTietDonDatHang;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBController;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBDonDatHang;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBTenXe;

public class DBHelper extends SQLiteOpenHelper {
    //Cau Truy va'n Create Talbe:
    public String sql;
    //DATA Version:
    private static final int DATABASE_VERSION = 1;
    //Data Name:
    static final public String NAME_DATABASE = "QLDatHangXeMay";
//Table name:

    static final public String TABLE_CTYXE = "CtyXe";
    static final public String TABLE_TENXE = "TenXe";
    static final public String TABLE_DONDATHANG = "DonDatHang";
    static final public String TABLE_CHITIETDONHANG = "ChiTietDonHang";


    //Colum in DSCtyXe:
    static final public String COL_MALOAI = "MaLoai";
    static final public String COL_TENLOAI = "TenLoai";
    static final public String COL_XUATXU = "XuatXu";
    static final public String COL_IMG_CTYXE = "image";


    //Colum in TenXe:
    static final public String COL_MAXE = "MaXe";
    static final public String COL_TENXE = "TenXe";
    static final public String COL_DUNGTICH = "DungTich";
    static final public String COL_SOLUONGXE = "SoLuongXe";
    static final public String COL_IMG_TENXE = "image";

    //Colum in DondatHang
    static final public String COL_MADONDATHANG = "MaDonDatHang";
    static final public String COL_NGAYLAP = "NgayLap";
    static final public String COL_IMG_DDH = "image";

    //Colum in DSChiTietDonHang:
    static final public String COL_SOLUONGDATHANG = "SoLuongDatHang";
    static final public String COL_DONGIA = "DONGIA";



    //Function:.
    public DBHelper(Context context) {
        super(context, NAME_DATABASE, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DBCtyXe.sql);
            db.execSQL(DBTenXe.sql);
            db.execSQL(DBDonDatHang.sql);
            db.execSQL(DBChiTietDonDatHang.sql);
            db.execSQL(DBController.sql);
        } catch (SQLiteException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CTYXE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TENXE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DONDATHANG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHITIETDONHANG);
        onCreate(db);
    }
}
