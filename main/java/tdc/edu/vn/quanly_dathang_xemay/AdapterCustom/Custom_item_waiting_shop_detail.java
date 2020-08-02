package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBChiTietDonDatHang;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBController;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBDonDatHang;
import tdc.edu.vn.quanly_dathang_xemay.MainActivity;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.ChiTietDonDatHang;

public class Custom_item_waiting_shop_detail extends BaseAdapter {
    ArrayList<ArrayList> data;
    Context context;

    //Bien luu gia tri:
    ArrayList<String> maDDH = new ArrayList<>();
    String getMaDHH_inSpr = "";

    public Custom_item_waiting_shop_detail(ArrayList<ArrayList> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_waiting_shop_detail, parent, false);

        ImageView img_xe = convertView.findViewById(R.id.waiting_shop_img_xe);
        TextView tv_ten = convertView.findViewById(R.id.tv_waiting_shop_tenxe);
        TextView tv_soluong = convertView.findViewById(R.id.tv_waiting_shop_soluongxe);
        TextView tv_dongia = convertView.findViewById(R.id.tv_waiting_shop_DonGia);
        TextView tv_tong = convertView.findViewById(R.id.tv_waiting_shop_Tong);
        ImageButton ib_accept = convertView.findViewById(R.id.ib_waiting_shop_accept);
        ImageButton ib_destroys = convertView.findViewById(R.id.ib_waiting_shop_destroy);

        //Mãng 2 chiều:
        final ArrayList<String> temp = (ArrayList<String>) data.get(position);
        img_xe.setImageResource(MainActivity.getImageId(context.getApplicationContext(), temp.get(0)));
        tv_ten.setText(temp.get(2));
        tv_soluong.setText(temp.get(3));
        tv_dongia.setText(temp.get(4));

        //Tính tổng giá tình soluong*dongia
        Integer tong = Integer.parseInt(temp.get(3)) * Integer.parseInt(temp.get(4));

        tv_tong.setText(tong + "");

//Accept thêm vào data Chi Tiet Don Dat Hang
        final View finalConvertView = convertView;
        ib_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBDonDatHang dbDonDatHang = new DBDonDatHang(context.getApplicationContext());
                maDDH = dbDonDatHang.get_MaDDH();
//New AlertDialog Selected MaDDH:
                setDialogSelectedMaDDH(position);


            }


            private void setDialogSelectedMaDDH(final int position) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context.getApplicationContext(), android.R.layout.simple_spinner_item, maDDH);

                final Spinner spinner = new Spinner(context.getApplicationContext());
                spinner.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                spinner.setAdapter(arrayAdapter);
                spinner.setBackgroundColor(context.getResources().getColor(R.color.red));

                AlertDialog.Builder builder = new AlertDialog.Builder(finalConvertView.getContext());
                builder.setTitle("Thông Báo").setMessage("Chọn Mã Đơn Đặt Hàng!");
                builder.setView(spinner);
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                getMaDHH_inSpr = spinner.getSelectedItem().toString();
                                ArrayList<String> temp = data.get(position);

                                DBChiTietDonDatHang dbChiTietDonDatHang = new DBChiTietDonDatHang(context);
                                ChiTietDonDatHang chiTietDonDatHang = new ChiTietDonDatHang(getMaDHH_inSpr, temp.get(1),
                                        Integer.parseInt(temp.get(3)), Integer.parseInt(temp.get(4)));
                                dbChiTietDonDatHang.Them(chiTietDonDatHang);

                                Custom_toast.makeText(context.getApplicationContext(), "Thêm Thành Công!!",
                                        Custom_toast.LENGTH_LONG, Custom_toast.WARNING);
                                DBController dbController = new DBController(context);
                                dbController.Xoa(temp.get(1));
                            }
                        });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Custom_toast.makeText(context.getApplicationContext(), "Bạn Chưa Chọn Mã Đơn Đặt Hàng",
                                        Custom_toast.LENGTH_LONG, Custom_toast.WARNING);
                                dialog.cancel();
                            }
                        });
                builder.create().show();
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });

            }
        });


        //Destroy Đơn hàng và k send to database
        ib_destroys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }
}
