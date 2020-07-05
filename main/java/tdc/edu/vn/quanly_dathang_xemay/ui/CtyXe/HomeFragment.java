package tdc.edu.vn.quanly_dathang_xemay.ui.CtyXe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.CustomRecyclerView;
import tdc.edu.vn.quanly_dathang_xemay.EditCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class HomeFragment extends Fragment  {

    private ArrayList<CtyXe> ctyXes = new ArrayList<>();
    private RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private Button btnEdit;
    private View root;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_ctyxe, container, false);
        KhoiTao();
        recyclerView = root.findViewById(R.id.recy_view);


        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        adapter = new CustomRecyclerView(ctyXes, this.getContext());


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return root;
    }




    private void KhoiTao() {
        CtyXe ctyXe = new CtyXe("mercedes_logo", "MERCE", "Mercedes", "Bắc Mỹ");
        CtyXe ctyXe1 = new CtyXe("bmw_logo", "BMW", "BMW", "Đức");
        CtyXe ctyXe2 = new CtyXe("vinfast_logo", "VF", "VinFast", "Việt Nam");


        ctyXes.add(ctyXe);
        ctyXes.add(ctyXe1);
        ctyXes.add(ctyXe2);
    }


}
