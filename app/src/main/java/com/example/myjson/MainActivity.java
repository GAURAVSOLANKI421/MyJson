package com.example.myjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String myurl="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myb = (Button)findViewById(R.id.button);
        myb.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        JsonObjectRequest weather = new JsonObjectRequest(Request.Method.GET, myurl, null, new Response.Listener<JSONObject>() {
@Override
public void onResponse(JSONObject weather) {
    try {
        String coood=weather.getString("temp");
        Log.i("coood", "onResponse: coood"+coood);
    } catch (JSONException e) {
        e.printStackTrace();
    }
}
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(String.valueOf(error), "onErrorResponse:there is an error ");
            }
        } );
        MySingelton.getInstance(MainActivity.this).addToRequestQue(weather);
}


        });
}}




