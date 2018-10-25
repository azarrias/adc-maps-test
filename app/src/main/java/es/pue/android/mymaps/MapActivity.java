package es.pue.android.mymaps;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapActivity extends AppCompatActivity {

    private List<String> cities;

    Map<String, GeoCoord> citiesDict = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        loadData();
        Set<String> dictKeys = citiesDict.keySet();

        cities = new ArrayList<>(dictKeys);

        ListView citiesView = (ListView)findViewById((R.id.lstCities));

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = cities.get(position);
                Toast.makeText(MapActivity.this, "Ciudad:" + selectedCity, Toast.LENGTH_LONG).show();
                GeoCoord gc = citiesDict.get(selectedCity);
                displayMap(gc);
            }
        };

        citiesView.setOnItemClickListener(listener);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.item_list,
                R.id.textView,
                cities);

        citiesView.setAdapter(adapter);
    }

    private void loadData(){
        citiesDict.put("Barcelona", new GeoCoord(String.valueOf(41.3947688),
                String.valueOf(2.0787282)));
        citiesDict.put("Basilea", new GeoCoord(String.valueOf(47.5545753),
                String.valueOf(7.524419)));
        citiesDict.put("Berlin", new GeoCoord(String.valueOf(52.5065132),
                String.valueOf(13.144537)));
        citiesDict.put("New Orleans", new GeoCoord(String.valueOf(30.0326995),
                String.valueOf(-90.1627783)));
        citiesDict.put("Tokio", new GeoCoord(String.valueOf(35.6730184),
                String.valueOf(139.4301774)));
    }

    private void displayMap(double lat, double lon){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:" + lat + "," + lon));

        startActivity(i);
    }

    private void displayMap(GeoCoord coord){
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("geo:" + coord.getLatitude() + "," + coord.getLongitude()));

        startActivity(i);
    }
}
