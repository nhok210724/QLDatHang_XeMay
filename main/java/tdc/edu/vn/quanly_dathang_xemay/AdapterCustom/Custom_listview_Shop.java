package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBController;
import tdc.edu.vn.quanly_dathang_xemay.MainActivity;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class Custom_listview_Shop extends BaseAdapter {
    ArrayList<Xe> xes;
    Context context;
    public static Integer[] spr_soluong = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static List<Integer> ints = Arrays.asList(1000000, 2000000, 50000000, 5000000, 10000000, 20000000, 80000000);
    Random random = new Random();

    public Custom_listview_Shop(ArrayList<Xe> xes, Context context) {
        this.xes = xes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return xes.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_shop, parent, false);

        ImageView img_xe = convertView.findViewById(R.id.shop_img_xe);
        TextView tv_shop_tenxe = convertView.findViewById(R.id.tv_shop_tenxe);
        TextView tv_shop_DonGia = convertView.findViewById(R.id.tv_shop_DonGia);
        TextView tv_shop_soLuongXe = convertView.findViewById(R.id.tv_shop_soluongxe);

        final Spinner spr_SoLuong = convertView.findViewById(R.id.spr_shop_soLuong);
        ImageButton ib_adtocard = convertView.findViewById(R.id.ib_shop_addToCard);
        LinearLayout linearLayout = convertView.findViewById(R.id.liner_animation);


        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_gallery_item, spr_soluong);

        spr_SoLuong.setAdapter(arrayAdapter);
        spr_SoLuong.setBackgroundColor(context.getResources().getColor(R.color.spiner_backgroud));


        final Xe xe = xes.get(position);
        img_xe.setImageResource(MainActivity.getImageId(context, xe.getImage()));
        tv_shop_tenxe.setText(xe.getTenXe());
        tv_shop_soLuongXe.setText(xe.getSoLuong() + "");
        final int rd = ints.get(random.nextInt(ints.size()));
        tv_shop_DonGia.setText(rd + " VND");

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.move);
        linearLayout.startAnimation(animation);

        final View finalConvertView = convertView;


        ib_adtocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int tong = rd * Integer.parseInt(spr_SoLuong.getSelectedItem().toString());

                AlertDialog.Builder builder = new AlertDialog.Builder(finalConvertView.getContext());
                builder.setMessage("Bạn Có Muốn Đặt Hàng Với Tổng Giá Trị : " + '\n' + tong + " VND ?").setTitle("Thông Báo");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                new DBController(context).Them(xe.getImage(), xe.getMaXe(), xe.getTenXe(),
                                        Integer.parseInt(spr_SoLuong.getSelectedItem().toString()), rd);
                                Custom_toast.makeText(context, "Đặt Hàng Thành Công",
                                        Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
                            }
                        });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        return convertView;
    }
}
