package where.example.com.options;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class contactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        contactFragment frag;
        ArrayList<String> contacts = (ArrayList<String>) getIntent().getSerializableExtra(option.SER_CURSOR);
        Log.v("contacts is here", contacts.get(0));
        if (savedInstanceState == null) {
            Bundle bund = new Bundle();
            bund.putSerializable("kk", contacts);
            frag = new contactFragment();
            frag.setArguments(bund);
            FragmentManager man = getFragmentManager();
            FragmentTransaction tran = man.beginTransaction();
            tran.add(R.id.containerr, frag);
            tran.commit();
        } else {
            Bundle bund = new Bundle();
            bund.putSerializable("kk", contacts);
            frag = new contactFragment();
            frag.setArguments(bund);
            FragmentManager man = getFragmentManager();
            FragmentTransaction tran = man.beginTransaction();
            tran.replace(R.id.containerr, frag);
            tran.commit();
        }
    }

}
