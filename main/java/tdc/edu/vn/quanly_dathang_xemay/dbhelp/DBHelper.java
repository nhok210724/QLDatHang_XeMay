package tdc.edu.vn.quanly_dathang_xemay.dbhelp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
    static final public String TABLE_ADMIN = "admin";
    //COL in ADmin:
    static final public String COL_USER = "User";
    static final public String COL_PASS = "Pass";

    //Colum in DSCtyXe:
    static final public String COL_MALOAI = "MaLoai";
    static final public String COL_TENLOAI = "TenLoai";
    static final public String COL_XUATXU = "XuatXu";


    //Colum in TenXe:
    static final public String COL_MAXE = "MaXe";
    static final public String COL_TENXE = "TenXe";
    static final public String COL_DUNGTICH = "DungTich";
    static final public String COL_SOLUONGXE = "SoLuongXe";


    //Colum in DondatHang
    static final public String COL_MADONDATHANG = "MaDonDatHang";
    static final public String COL_NGAYLAP = "NgayLap";


    //Colum in DSChiTietDonHang:
    static final public String COL_SOLUONGDATHANG = "SoLuongDatHang";
    static final public String COL_DONGIA = "DONGIA";


    //Function:
    public DBHelper(@Nullable Context context, String DataName) {
        super(context, DataName, null, DATABASE_VERSION);
    }


    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(getSql());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
