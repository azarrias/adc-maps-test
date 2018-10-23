package es.pue.android.mymaps;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    private Button btnDisplayMap;

    List<String> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent i = getIntent();
        Parcelable parcelableData = i.getParcelableExtra("GeoCoord");
        final GeoCoord coord = (GeoCoord)parcelableData;

        btnDisplayMap = (Button)findViewById(R.id.btnDisplayMap);

        btnDisplayMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayMap(Double.valueOf(coord.getLatitude()),
                        Double.valueOf(coord.getLongitude()));
            }
        });

        cities.add("Barcelona");
        cities.add("Basilea");
        cities.add("Berlin");
        cities.add("Madrid");
        cities.add("Lucerna");

        ListView citiesView = (ListView)findViewById((R.id.lstCitites));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                cities);

        citiesView.setAdapter(adapter);
    }

    private void displayMap(double lat, double lon){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:" + lat + "," + lon));

        startActivity(i);
    }
}
