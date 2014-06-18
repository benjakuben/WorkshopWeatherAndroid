package com.jakuben.workshopweather.app;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.jakuben.workshopweather.adapters.DailyForecastAdapter;
import com.jakuben.workshopweather.models.Forecast;
import com.jakuben.workshopweather.services.ForecastServiceClient;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ListActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private double mLatitude = 36.099869;
    private double mLongitude = -115.171347;

    @InjectView(R.id.textView) protected TextView mCurrentTempLabel;
    @InjectView(R.id.imageView) protected ImageView mCurrentWeatherImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        // Get weather data
        ForecastServiceClient.getInstance().getForecastData(mLatitude, mLongitude, mForecastCallback);

        trackScreenView();
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
            mCurrentTempLabel.setText(forecast.getCurrently().getTemperature().toString() + "\u00b0");
            mCurrentWeatherImage.setImageResource(getIconId(forecast.getCurrently().getIcon()));

            animateCurrentConditions();

            DailyForecastAdapter adapter = new DailyForecastAdapter(MainActivity.this, forecast.getDaily().getData());
            setListAdapter(adapter);
        }

        @Override
        public void failure(RetrofitError retrofitError) {
            Toast.makeText(MainActivity.this, retrofitError.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private int getIconId(String icon) {
        if (icon.equalsIgnoreCase("clear-day")) {
            return R.drawable.sun;
        }
        else if (icon.equalsIgnoreCase("clear-night")) {
            return R.drawable.moon;
        }
        else if (icon.equalsIgnoreCase("rain")) {
            return R.drawable.rain;
        }
        else if (icon.equalsIgnoreCase("snow")) {
            return R.drawable.snow;
        }
        else if (icon.equalsIgnoreCase("sleet")) {
            return R.drawable.snow;
        }
        else if (icon.equalsIgnoreCase("wind")) {
            return R.drawable.tornado;
        }
        else if (icon.equalsIgnoreCase("fog")) {
            return R.drawable.haze;
        }
        else if (icon.equalsIgnoreCase("cloudy")) {
            return R.drawable.cloud;
        }
        else if (icon.equalsIgnoreCase("partly-cloudy-day")) {
            return R.drawable.partly_sunny;
        }
        else if (icon.equalsIgnoreCase("partly-cloudy-night")) {
            return R.drawable.partly_moon;
        }
        else if (icon.equalsIgnoreCase("hail")) {
            return R.drawable.hail;
        }
        else if (icon.equalsIgnoreCase("thunderstorm")) {
            return R.drawable.storm;
        }
        else if (icon.equalsIgnoreCase("tornado")) {
            return R.drawable.tornado;
        }

        return R.drawable.partly_sunny;
    }

    private void animateCurrentConditions() {
        Animation translation = new TranslateAnimation(0, 0, -500, 0);
        translation.setDuration(500);
        mCurrentWeatherImage.startAnimation(translation);

        Animation translation2 = new TranslateAnimation(0, 0, -500, 0);
        translation2.setDuration(500);
        translation2.setStartOffset(200);
        mCurrentTempLabel.startAnimation(translation2);
    }

    private void trackScreenView() {
        // Get tracker.
        Tracker t = ((WorkshopApplication)getApplication()).getTracker(WorkshopApplication.TrackerName.APP_TRACKER);

        // Set screen name.
        // Where path is a String representing the screen name.
        t.setScreenName(MainActivity.class.getSimpleName());

        // Send a screen view.
        t.send(new HitBuilders.AppViewBuilder().build());
    }
}
