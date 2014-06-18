package com.jakuben.workshopweather.services;

import com.jakuben.workshopweather.models.Forecast;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by benjakuben on 6/7/14.
 */
public class ForecastServiceClient {

    private static final String API_URL = "https://api.forecast.io/";
    private static final String API_KEY = "49aabc829e12b795569e85bde5933ac3";

    private static final ForecastServiceClient INSTANCE = new ForecastServiceClient();
    private static ForecastService sService;

    private ForecastServiceClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_URL)
                    .setLogLevel(RestAdapter.LogLevel.FULL) // Optional for development!
                    .build();
        sService = restAdapter.create(ForecastService.class);
    }

    public static ForecastServiceClient getInstance() {
        return INSTANCE;
    }

    /*
     * Create an async call to the forecast service
     */
    public void getForecastData(double latitude, double longitude, Callback<Forecast> callback) {
       sService.getForecastAsync(API_KEY,
                Double.toString(latitude),
                Double.toString(longitude),
                callback);
    }
}
