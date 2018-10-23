package es.pue.android.mymaps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnDisplayMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplayMap = (Button)findViewById(R.id.btnDisplayMap);

        btnDisplayMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMap();
            }
        });
    }

    private void displayMap(){
        double lat = 41.4920189;
        double lon = 2.3513412;

        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:" + lat + "," + lon));

        startActivity(i);
    }
}
