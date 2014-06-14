package com.jakuben.workshopweather.app;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.jakuben.workshopweather.adapters.DailyForecastAdapter;
import com.jakuben.workshopweather.models.Forecast;
import com.jakuben.workshopweather.services.ForecastServiceClient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ListActivity {

    // TODO: Weather icons
    // TODO: Parallax in current conditions
    // TODO: Animate 7 day forecast listview

    public static final String TAG = MainActivity.class.getSimpleName();

    private double mLatitude = 36.099869;
    private double mLongitude = -115.171347;

    protected TextView mCurrentTempLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get data
        ForecastServiceClient.getInstance().getForecastData(mLatitude, mLongitude, mForecastCallback);

        // Set views
        mCurrentTempLabel = (TextView)findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected Callback<Forecast> mForecastCallback = new Callback<Forecast>() {
        @Override
        public void success(Forecast forecast, Response response) {
            Log.i(TAG, "Current temp: " + forecast.getCurrently().getTemperature());
            mCurrentTempLabel.setText(forecast.getCurrently().getTemperature().toString());

            DailyForecastAdapter adapter = new DailyForecastAdapter(MainActivity.this, forecast.getDaily().getData());
            setListAdapter(adapter);
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Toast.makeText(MainActivity.this, retrofitError.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };
}
