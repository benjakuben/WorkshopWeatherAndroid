package com.jakuben.workshopweather.services;

import com.jakuben.workshopweather.models.Forecast;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/*
 * Define a service for getting forecast information using Retrofit by Square
 */
public interface ForecastService {
    @GET("/forecast/{key}/{latitude},{longitude}")
    public void getForecastAsync(
            @Path("key") String key,
            @Path("latitude") String lat,
            @Path("longitude") String longitude,
            Callback<Forecast> callback
    );
}