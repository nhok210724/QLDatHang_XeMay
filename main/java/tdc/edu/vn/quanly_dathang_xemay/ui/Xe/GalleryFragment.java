package tdc.edu.vn.quanly_dathang_xemay.ui.Xe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.CustomPagerView;
import tdc.edu.vn.quanly_dathang_xemay.Add_Edit_Xe;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBTenXe;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class GalleryFragment extends Fragment {

    static Handler handler = new Handler();
    ArrayList<Xe> xes = new ArrayList<>();


    ViewPager viewPager;

    Button btnedit;
    int index = -1;
    boolean checkEdit = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_xe, container, false);
        setControl(root);
        setEvent();


        return root;
    }
/*
    public void autoLoad() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    HienThiDL();
                } catch (Exception e) {

                    e.printStackTrace();
                }
                handler.postDelayed(this, 3000);
            }
        }, 3000);
    }
*/


    public void HienThiDL() {
        DBTenXe dbTenXe = new DBTenXe(getContext());
        xes = dbTenXe.getDL();
        viewPager.setAdapter(new CustomPagerView(xes, getActivity()) {
        });
        viewPager.setPadding(130, 0, 130, 0);

    }

    private void setControl(View root) {
        viewPager = root.findViewById(R.id.viewpager);
        btnedit = root.findViewById(R.id.btnEditXe);

    }

    private void setEvent() {
        HienThiDL();


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

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEdit = true;
                Intent intent = new Intent(getContext(), Add_Edit_Xe.class);


                intent.putExtra("check", checkEdit);
                intent.putExtra("vitri", viewPager.getCurrentItem());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bar_them1:
                checkEdit = false;
                Intent intent = new Intent(getContext(), Add_Edit_Xe.class);
                ArrayList<String> tenimg = new ArrayList<>();
                for (Xe xe : xes) {
                    tenimg.add(xe.getImage());
                }
                intent.putExtra("key", tenimg);
                intent.putExtra("check", checkEdit);
                startActivity(intent);
                break;
            case R.id.reload:
                HienThiDL();
                Toast.makeText(getContext(), "Cập Nhật Danh Sách", Toast.LENGTH_LONG).show();
                break;
        }

        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_addactionbar, menu);

    }
}
