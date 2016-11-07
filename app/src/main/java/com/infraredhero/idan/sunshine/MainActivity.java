package com.infraredhero.idan.sunshine;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);


            String[] forecastArray = {
                    "Today - Clear 27/20",
                    "Tomorrow - Clear 29/20",
                    "Weds - Clear 30/21",
                    "Thurs - Cloudy 25/18",
                    "Fri- Cloudy 24/17",
                    "Sat - Rain 20/17",
                    "Sun - Rain 19/16"
            };
            ArrayList<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));
            ArrayAdapter<String> mForecastAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,
                    weekForecast);
            ListView listView = (ListView) rootView.findViewById(R.id.list_item_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }

}
