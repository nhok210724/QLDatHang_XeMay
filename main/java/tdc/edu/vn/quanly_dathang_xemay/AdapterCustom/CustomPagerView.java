package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBTenXe;
import tdc.edu.vn.quanly_dathang_xemay.MainActivity;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class CustomPagerView extends PagerAdapter {
    ArrayList<Xe> xes;
    Context context;
    LayoutInflater layoutInflater;

    public CustomPagerView(ArrayList<Xe> xes, Context context) {
        this.xes = xes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return xes.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.item_xe, container, false);

        ImageView imageXe = view.findViewById(R.id.image_xe);
        TextView tvMaXe = view.findViewById(R.id.tvmaxe);
        TextView tvTenXe = view.findViewById(R.id.tvtenxe);
        TextView tvDungTich = view.findViewById(R.id.tvdungtich);
        TextView tvSoLuong = view.findViewById(R.id.tvsoluongxe);
        TextView tvMaLoai_ctyxe_xe = view.findViewById(R.id.tvmaloai_ctyxe_xe);
        CardView cardView = (CardView) view.findViewById(R.id.card_view);


        Xe xe = xes.get(position);
//Co data thi show cai nay
        imageXe.setImageResource(MainActivity.getImageId(context, xe.getImage()));

        tvMaXe.setText(xe.getMaXe());
        tvTenXe.setText(xe.getTenXe());
        tvDungTich.setText(xe.getDungTich() + "cc");
        tvSoLuong.setText("Số Lượng: " + xe.getSoLuong());
        tvMaLoai_ctyxe_xe.setText(xe.getMaLoai());


        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Bạn Có Muốn Xoá ?").setTitle("Thông Báo");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                DBTenXe dbTenXe = new DBTenXe(view.getContext());
                                dbTenXe.Xoa(xes.get(position));
                                Custom_toast.makeText(view.getContext(), "Xoá Thành Công", Custom_toast.LENGTH_LONG, Custom_toast.SUCCESS).show();
                            }
                        });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder.create();
                alert11.show();
                return false;
            }
        });
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
