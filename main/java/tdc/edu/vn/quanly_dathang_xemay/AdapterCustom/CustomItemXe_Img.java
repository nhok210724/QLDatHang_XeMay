package tdc.edu.vn.quanly_dathang_xemay.AdapterCustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.MainActivity;
import tdc.edu.vn.quanly_dathang_xemay.R;

public class CustomItemXe_Img extends PagerAdapter {
    ArrayList<String> img_xe;
    Context context;
    LayoutInflater layoutInflater;
    CardView cardView;

    public CustomItemXe_Img(ArrayList<String> img_xe, Context context) {
        this.img_xe = img_xe;
        this.context = context;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.item_img_xe, container, false);
        ImageView imageXe = view.findViewById(R.id.img_item);
        cardView = view.findViewById(R.id.card_view);

        String tenimg = img_xe.get(position);
        imageXe.setImageResource(MainActivity.getImageId(context, tenimg));
        container.addView(view, 0);
        return view;
    }

    @Override
    public int getCount() {
        return img_xe.size();
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
