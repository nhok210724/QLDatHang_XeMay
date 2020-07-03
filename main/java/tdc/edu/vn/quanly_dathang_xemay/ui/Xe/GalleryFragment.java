package tdc.edu.vn.quanly_dathang_xemay.ui.Xe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.CustomPagerView;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class GalleryFragment extends Fragment {
    ArrayList<Xe> xes = new ArrayList<>();

    ViewPager viewPager;
    int index = -1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_xe, container, false);
        KhoiTao();

        viewPager = root.findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerView(xes, getActivity()) {
        });
        viewPager.setPadding(130, 0, 130, 0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                index = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return root;
    }

    private void KhoiTao() {
        Xe xe = new Xe("ABC", "mercedes1", "MEC1",
                "Mercedes Benz 2018", 250, 20);
        Xe xe1 = new Xe("ABC", "mercedes2", "MEC2",
                "Mercedes Benz 2017", 280, 11);
        xes.add(xe);
        xes.add(xe1);
    }


}
