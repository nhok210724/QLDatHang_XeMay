package tdc.edu.vn.quanly_dathang_xemay.ui.LogOut;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import tdc.edu.vn.quanly_dathang_xemay.MainActivity;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.ui.CtyXe.HomeFragment;

public class LogOut extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.logout,container,false);
        Intent intent = new Intent(getContext(),MainActivity.class);
        startActivity(intent);
        return view;
    }
}
