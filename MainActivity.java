package where.example.com.options;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button options = findViewById(R.id.options);
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityChangeIntent = new Intent(MainActivity.this, option.class);

                // currentContext.startActivity(activityChangeIntent);

                MainActivity.this.startActivity(activityChangeIntent);
            }

        });


        final Button edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityChangeIntent = new Intent(MainActivity.this, EditProfile.class);

                // currentContext.startActivity(activityChangeIntent);

                MainActivity.this.startActivity(activityChangeIntent);
            }

        });

    }
}
