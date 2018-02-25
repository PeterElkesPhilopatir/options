package where.example.com.options;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class contactFragment extends Fragment {

    public contactFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        final ArrayList<String > contacts = (ArrayList<String>) getArguments().getSerializable("kk");

        TextView numbers = (TextView)rootView.findViewById(R.id.numbers);
        ArrayList<String >updated_contacts = new ArrayList<>();
        // this for loop is to remove additional numbers as some digits is added and it did not belong to phone number
        int start  ;
        String number;
        for (int i =0 ; i<contacts.size();i++)
        {
            start =  new Integer(0);
            if (!contacts.isEmpty()) {
                start = contacts.get(i).indexOf(";");
                Log.i("contacts fragment line", contacts.get(i));
                number = new String();
                if (start!=0) {
                    number=contacts.get(i).substring(start+1);
                    updated_contacts.add(number);
                    Log.i("updated contacts", updated_contacts.get(i) );
                }
                else
                {
                    number=contacts.get(i);
                    updated_contacts.add(number);
                }
            }
        }
        // this to add all the array in a string to be shown in TextView as we didn't need a list as we are not going to show it later
        String all_num = new String();
        all_num = updated_contacts.get(0).toString();
        Log.i("allnum before", all_num );
        for (int i  = 1 ;i < updated_contacts.size() ; i++) {
            all_num = all_num + "\n"+updated_contacts.get(i).toString();
            Log.i("allnum after", all_num );
        }
        numbers.setText(all_num);
        return rootView;
    }
}
