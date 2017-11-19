package com.example.league95.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int max = 20;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Then ours list view
        final ListView listView = (ListView) findViewById(R.id.listView);
        //Create ArrayList
        final List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        final List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        //Array Adapter
        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,
                                               android.R.layout.simple_list_item_1,
                                                                             list);
        //connect listView now
        listView.setAdapter(arrayAdapter);
        //Text View
        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("0");
        //Initialize our seek bar first
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(20);
        //seekBar.setProgress(seekBar.getProgress() + 1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if (progress >= 0)
                {
                    for(int i = 0; i < list.size(); i++)
                    {
                        list.set(i, list2.get(i)*progress);
                    }
                }
                //We need to notify the adapter about the change
                arrayAdapter.notifyDataSetChanged();
                textView.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





    }
}
