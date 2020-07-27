package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.MainActivity;
import tdc.edu.vn.quanly_dathang_xemay.R;

public class Custom_img_Ctyxe extends PagerAdapter {

    ArrayList<String> img_ctyxe;
    Context context;
    LayoutInflater layoutInflater;


    public Custom_img_Ctyxe(ArrayList<String> img_ctyxe, Context context) {
        this.img_ctyxe = img_ctyxe;
        this.context = context;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.item_img_ctyxe, container, false);
        ImageView imageCtyXe = view.findViewById(R.id.img_item_CtyXe);

        String img = img_ctyxe.get(position);


        imageCtyXe.setImageResource(MainActivity.getImageId(context, img));

        //imageXe.setImageResource(R.drawable.vinfast_logo);
        container.addView(view, 0);
        return view;
    }

    @Override
    public int getCount() {
        return img_ctyxe.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
