package com.jakuben.workshopweather.adapters;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jakuben.workshopweather.app.R;
import com.jakuben.workshopweather.models.Data;

import java.util.Calendar;
import java.util.List;

/**
 * Created by benjakuben on 6/9/14.
 */
public class DailyForecastAdapter extends ArrayAdapter<Data> {

    private Context mContext;
    private List<Data> mForecasts;

    public DailyForecastAdapter(Context context, List<Data> forecasts) {
        super(context, R.layout.daily_forecast_item, forecasts);
        mContext = context;
        mForecasts = forecasts;
    }

    @Override
    public int getCount() {
        return mForecasts.size();
    }

    @Override
    public Data getItem(int position) {
        return mForecasts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_forecast_item, null);
            holder = new ViewHolder();
            holder.container = (ViewGroup)convertView.findViewById(R.id.dailyForecastContainer);
            holder.dayNameLabel = (TextView)convertView.findViewById(R.id.day);
            holder.summaryLabel = (TextView)convertView.findViewById(R.id.summary);
            holder.highLowLabel = (TextView)convertView.findViewById(R.id.temperatures);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        Data dayData = mForecasts.get(position);
        String dayName = getDayName(position);

        holder.dayNameLabel.setText(dayName);
        holder.summaryLabel.setText(dayData.getSummary());
        holder.highLowLabel.setText(Math.round(dayData.getTemperatureMax().doubleValue()) + " / " +
                Math.round(dayData.getTemperatureMin().doubleValue()));

        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        float deviceWidth = displayMetrics.widthPixels;

        Animation translation = new TranslateAnimation(deviceWidth, 0, 0, 0);
        translation.setDuration(500);
        translation.setStartOffset(100 * position);
        holder.container.startAnimation(translation);

        return convertView;
    }

    private String getDayName(int position) {
        int day = (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + position) % 7;
        if (day == 0) {
            day = 7; // handle Saturday weirdness
        }
        switch(day) {
            case Calendar.SUNDAY:
                return "Sun";
            case Calendar.MONDAY:
                return "Mon";
            case Calendar.TUESDAY:
                return "Tue";
            case Calendar.WEDNESDAY:
                return "Wed";
            case Calendar.THURSDAY:
                return "Thu";
            case Calendar.FRIDAY:
                return "Fri";
            case Calendar.SATURDAY:
                return "Sat";
        }
        return "";
    }

    private static class ViewHolder {
        ViewGroup container;
        TextView dayNameLabel;
        TextView summaryLabel;
        TextView highLowLabel;
    }
}
