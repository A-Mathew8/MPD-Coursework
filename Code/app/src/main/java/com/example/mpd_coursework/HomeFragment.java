package com.example.mpd_coursework;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private String result = "";
    private String url1 = "";
    private String urlSource = ( "http://quakes.bgs.ac.uk/feeds/MhSeismology.xml");
    private ArrayList<Earthquake> list;
    private Earthquake eq;



    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_home, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        Log.e("MyTag", "In on Click");
        new ShowDialogAsyncTask().execute(urlSource);
        Log.e("MyTag", "After start progress");

    }

    public class ShowDialogAsyncTask extends AsyncTask<String, String, String>
    {


        @Override
        protected void onPreExecute()
        {


        }

        @Override
        protected String doInBackground(String... urlSource)
        {
            // update the UI immediately after the task is executed
            super.onPreExecute();
            URL aurl;
            URLConnection urlConnection;
            BufferedReader in;
            String inputLine = "";

            list = new ArrayList<Earthquake>();
            Log.e("MyTag", "In Run");

            try
            {
                Log.e("MyTag", "In Try");
                aurl = new URL(urlSource[0]);
                urlConnection = aurl.openConnection();
                in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                Log.e("MyTag", "After Ready");

                while((inputLine = in.readLine()) != null)
                {
                    result = result + inputLine;
                    Log.e("MyTag", inputLine);
                }
                in.close();
                if(result != null)
                {
                    Parser parser = new Parser();
                    list = parser.parseData(result);
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", list);

                SearchFragment sf = new SearchFragment();
                sf.setArguments(bundle);

                Log.e("MyTag", "Bundle is: " + bundle);

            }
            catch (MalformedURLException e) {
                Log.e("MyTag", "Error: " + e.toString());
            } catch (IOException e) {
                Log.e("MyTag", "IO Error: " + e.toString());
            }
            return null;
        }


        @Override
        protected void onPostExecute(String result)
        {
            super.onPostExecute(result);

            EarthquakeAdapter adapter = new EarthquakeAdapter(getActivity(), list);
            ListView listView = getActivity().findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }

    }
}