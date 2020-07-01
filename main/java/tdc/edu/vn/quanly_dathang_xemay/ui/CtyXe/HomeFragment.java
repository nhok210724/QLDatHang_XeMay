package tdc.edu.vn.quanly_dathang_xemay.ui.CtyXe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.CustomGridView;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class HomeFragment extends Fragment {

    ArrayList<CtyXe> ctyXes = new ArrayList<>();
    GridView gridView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_ctyxe, container, false);

        gridView = root.findViewById(R.id.gridItem);
        KhoiTao();
        CustomGridView customGridView = new CustomGridView(getActivity(), R.layout.item_custom_gridview, ctyXes);
        gridView.setAdapter(customGridView);

        return root;
    }


    private void KhoiTao() {
        CtyXe ctyXe = new CtyXe("ABC");
        ctyXe.setTenLoai("Mec");
        ctyXe.setXuatXu("Tung Cua");

        ctyXes.add(ctyXe);
    }

}
