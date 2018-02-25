package where.example.com.options;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class option extends AppCompatActivity {

    //public static final int PICK_CONTACT = 3;
    public final static String SER_CURSOR= "where.example.com.option.ser";
    public static final int REQUEST_CODE_PICK_CONTACT = 1;
    public static final int  MAX_PICK_CONTACT= 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.blackColor), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        ImageView fb = findViewById(R.id.fb_icon);
        fb.setImageResource(R.drawable.fb);

        ImageView fb2 = findViewById(R.id.fb_icon2);
        fb2.setImageResource(R.drawable.fb);

        ImageView contacts = findViewById(R.id.contact_icon);
        contacts.setImageResource(R.drawable.contacts);


        View contacts_txt = findViewById(R.id.contacts_relative);
     contacts_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
//             Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);

//             startActivityForResult(intent , PICK_CONTACT);
         launchMultiplePhonePicker();
         }
     });

    }

    private void launchMultiplePhonePicker() {

        Intent phonebookIntent = new Intent("intent.action.INTERACTION_TOPMENU");
        phonebookIntent.putExtra("additional", "phone-multi");
        phonebookIntent.putExtra("maxRecipientCount", MAX_PICK_CONTACT);
        phonebookIntent.putExtra("FromMMS", true);
        startActivityForResult(phonebookIntent, REQUEST_CODE_PICK_CONTACT);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode==RESULT_OK)
        {

            if(requestCode == REQUEST_CODE_PICK_CONTACT  )
            {

                Bundle bundle =  data.getExtras();

                String result= bundle.getString("result");
                ArrayList<String> contacts = bundle.getStringArrayList("result");
                Log.i("ana hna aho", contacts.get(0));
                Intent intent = new Intent(this,contactActivity.class);
                intent.putExtra(SER_CURSOR , contacts);
                startActivity(intent);


            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
//    @Override
//    public void onActivityResult(int reqCode, int resultCode, Intent data) {
//        super.onActivityResult(reqCode, resultCode, data);
//
//        switch (reqCode) {
//            case (PICK_CONTACT) :
//                if (resultCode == Activity.RESULT_OK) {
//                    Uri contactData = data.getData();
//                    Cursor c =  managedQuery(contactData, null, null, null, null);
//
//                    if (c.moveToFirst()) {
//                        String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//
//                    }
//                }
//                break;
//        }
//    }

}
