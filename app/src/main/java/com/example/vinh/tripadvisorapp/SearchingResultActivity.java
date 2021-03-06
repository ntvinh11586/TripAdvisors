package com.example.vinh.tripadvisorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class SearchingResultActivity extends AppCompatActivity {

    String [] aPlace = {"Ben Thanh Market", "Dragon Wharf", "Independence Palace",
            "Notre-Dame Cathedral Basilica of Saigon", "Saigon Zoo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching_result);

        ListView lv = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.activity_searching_result, R.id.textView, aPlace);

        lv.setAdapter(adapter);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                //Toast.makeText(getApplicationContext(), (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                // String locationName = (String) ((TextView) view).getText();
                String locationName = (String) parent.getItemAtPosition(position);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("locationName", locationName);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }


}
