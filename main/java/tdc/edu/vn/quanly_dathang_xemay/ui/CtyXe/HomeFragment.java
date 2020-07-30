package tdc.edu.vn.quanly_dathang_xemay.ui.CtyXe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.AdapterCustom.CustomRecyclerView;
import tdc.edu.vn.quanly_dathang_xemay.Ctyxe_new;
import tdc.edu.vn.quanly_dathang_xemay.DBClass.DBCtyXe;
import tdc.edu.vn.quanly_dathang_xemay.R;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class HomeFragment extends Fragment {

    Handler handler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<CtyXe> ctyXes = new ArrayList<>();
    private RecyclerView recyclerView;
    private View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_ctyxe, container, false);


        // ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(R.menu.menu_actionbar);

        setEvent(root);
        setControl();


        return root;
    }

    public void autoLoad() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    LoadDL();
                } catch (Exception e) {

                    e.printStackTrace();
                }
                handler.postDelayed(this, 3000);
            }
        }, 3000);
    }

    private void setControl() {
        autoLoad();

    }


    public void LoadDL() {

        DBCtyXe dbCtyXe = new DBCtyXe(getContext());

        ctyXes = dbCtyXe.get_ctyXes();
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        adapter = new CustomRecyclerView(ctyXes, this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void setEvent(View v) {
        recyclerView = v.findViewById(R.id.recy_view);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bar_them:
                Intent intent = new Intent(getContext(), Ctyxe_new.class);

                startActivity(intent);
                break;

        }

        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_actionbar, menu);

    }


}
