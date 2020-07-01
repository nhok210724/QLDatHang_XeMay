package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.EditCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class CustomGridView extends BaseAdapter {
    Context context;
    int idLayout;
    ArrayList<CtyXe> ctyXes;

    public CustomGridView(Context context, int idLayout, ArrayList<CtyXe> ctyXes) {
        this.context = context;
        this.idLayout = idLayout;
        this.ctyXes = ctyXes;
    }

    @Override
    public int getCount() {
        if (ctyXes.size() != 0) {
            return ctyXes.size();
        }
        return 0;
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
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);

        }
        ImageView imgLogo = convertView.findViewById(R.id.img_ctyxe);
        TextView tvMaLoai = convertView.findViewById(R.id.maLoai);
        TextView tvTenLoai = convertView.findViewById(R.id.tenLoai);
        TextView tvXuatXu = convertView.findViewById(R.id.xuatXu);
Button btnEdit = convertView.findViewById(R.id.btnEdit);

        CtyXe ctyXe = ctyXes.get(position);
        tvMaLoai.setText(ctyXe.getMaLoai());
        tvTenLoai.setText(ctyXe.getTenLoai());
        tvXuatXu.setText(ctyXe.getXuatXu());

        imgLogo.setImageResource(R.drawable.img_mercedes);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditCtyXe.class);

            }
        });
        return convertView;
    }


}
