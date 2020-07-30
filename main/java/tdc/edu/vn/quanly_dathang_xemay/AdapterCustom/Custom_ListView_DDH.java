package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.Add_Edit_ddh;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.DonDatHang;

public class Custom_ListView_DDH extends BaseAdapter {
    ArrayList<DonDatHang> donDatHangs;
    Context context;
    boolean CheckEdit = false;

    public Custom_ListView_DDH(ArrayList<DonDatHang> donDatHangs, Context context) {
        this.donDatHangs = donDatHangs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return donDatHangs.size();
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
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_ddh, parent, false);
        //ánh xạ các đối tượng
        TextView textView = convertView.findViewById(R.id.tvMaHD);
        TextView textView1 = convertView.findViewById(R.id.tvNgayLap);
        Button button = convertView.findViewById(R.id.btnEdit_DDH);


        DonDatHang donDatHang = donDatHangs.get(position);

        textView.setText(donDatHang.getMaDDH());
        textView1.setText(donDatHang.getNgayLap() + "");

        Animation animation = AnimationUtils.loadAnimation(parent.getContext(), R.anim.bounce);
        convertView.startAnimation(animation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEdit = true;
                Intent intent = new Intent(context, Add_Edit_ddh.class);
                intent.putExtra("posion", position);
                intent.putExtra("check", CheckEdit);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
