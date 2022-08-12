package sg.edu.rp.c346.id21012377.carparkavailability;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvCarpark;
    AsyncHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCarpark = findViewById(R.id.lvCarpark);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Carpark> alCarpark = new ArrayList<Carpark>();


        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            String total_Lots;
            String lot_type;
            String lots_available;
            String carpark_Number;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrCarpark_Data = firstObj.getJSONArray("carpark_data");
                    for(int i = 0; i < jsonArrCarpark_Data.length(); i++) {
                        JSONObject jsonObjCarpark_Data = jsonArrCarpark_Data.getJSONObject(i);
                        JSONArray jsonArrCarpark = jsonObjCarpark_Data.getJSONArray("carpark_info");
                        JSONObject jsonObjDetails = jsonArrCarpark.getJSONObject(0);
                        total_Lots = jsonObjDetails.getString("total_lots");
                        lot_type = jsonObjDetails.getString("lot_type");
                        lots_available = jsonObjDetails.getString("lots_available");
                        carpark_Number = jsonObjCarpark_Data.getString("carpark_number");
                        Carpark carpark = new  Carpark(carpark_Number,total_Lots,lots_available,lot_type);
                        alCarpark.add(carpark);
                    }
                }
                catch(JSONException e){

                }

                ArrayAdapter aaCarpark = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, alCarpark);
                lvCarpark.setAdapter(aaCarpark);

            }//end onSuccess
            });
        }
    }