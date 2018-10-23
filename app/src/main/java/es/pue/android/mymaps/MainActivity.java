package es.pue.android.mymaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etLatitude;
    EditText etLongitude;
    GeoCoord coord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLatitude = (EditText)findViewById(R.id.etLatitude);
        etLongitude = (EditText)findViewById(R.id.etLongitude);

        Button btnSendInfo = (Button)findViewById(R.id.btnSendInfo);
        btnSendInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coord = getData();
                sendInfo(coord);
            }
        });
    }

    private GeoCoord getData(){
        String latitude = etLatitude.getText().toString();
        String longitude = etLongitude.getText().toString();

        GeoCoord coord = new GeoCoord(latitude, longitude);
        return coord;
    }

    private void sendInfo(GeoCoord info){
        Intent i = new Intent(this, MapActivity.class);
        i.putExtra("GeoCoord", info);
        startActivity(i);
    }
}
