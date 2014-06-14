
package com.jakuben.workshopweather.models;

public class Currently{
   	private Number apparentTemperature;
   	private Number cloudCover;
   	private Number dewPoint;
   	private Number humidity;
   	private String icon;
   	private Number nearestStormBearing;
   	private Number nearestStormDistance;
   	private Number ozone;
   	private Number precipIntensity;
   	private Number precipProbability;
   	private Number pressure;
   	private String summary;
   	private Number temperature;
   	private Number time;
   	private Number visibility;
   	private Number windBearing;
   	private Number windSpeed;

 	public Number getApparentTemperature(){
		return this.apparentTemperature;
	}
	public void setApparentTemperature(Number apparentTemperature){
		this.apparentTemperature = apparentTemperature;
	}
 	public Number getCloudCover(){
		return this.cloudCover;
	}
	public void setCloudCover(Number cloudCover){
		this.cloudCover = cloudCover;
	}
 	public Number getDewPoint(){
		return this.dewPoint;
	}
	public void setDewPoint(Number dewPoint){
		this.dewPoint = dewPoint;
	}
 	public Number getHumidity(){
		return this.humidity;
	}
	public void setHumidity(Number humidity){
		this.humidity = humidity;
	}
 	public String getIcon(){
		return this.icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
 	public Number getNearestStormBearing(){
		return this.nearestStormBearing;
	}
	public void setNearestStormBearing(Number nearestStormBearing){
		this.nearestStormBearing = nearestStormBearing;
	}
 	public Number getNearestStormDistance(){
		return this.nearestStormDistance;
	}
	public void setNearestStormDistance(Number nearestStormDistance){
		this.nearestStormDistance = nearestStormDistance;
	}
 	public Number getOzone(){
		return this.ozone;
	}
	public void setOzone(Number ozone){
		this.ozone = ozone;
	}
 	public Number getPrecipIntensity(){
		return this.precipIntensity;
	}
	public void setPrecipIntensity(Number precipIntensity){
		this.precipIntensity = precipIntensity;
	}
 	public Number getPrecipProbability(){
		return this.precipProbability;
	}
	public void setPrecipProbability(Number precipProbability){
		this.precipProbability = precipProbability;
	}
 	public Number getPressure(){
		return this.pressure;
	}
	public void setPressure(Number pressure){
		this.pressure = pressure;
	}
 	public String getSummary(){
		return this.summary;
	}
	public void setSummary(String summary){
		this.summary = summary;
	}
 	public Number getTemperature(){
		return Math.round(this.temperature.doubleValue());
	}
	public void setTemperature(Number temperature){
		this.temperature = temperature;
	}
 	public Number getTime(){
		return this.time;
	}
	public void setTime(Number time){
		this.time = time;
	}
 	public Number getVisibility(){
		return this.visibility;
	}
	public void setVisibility(Number visibility){
		this.visibility = visibility;
	}
 	public Number getWindBearing(){
		return this.windBearing;
	}
	public void setWindBearing(Number windBearing){
		this.windBearing = windBearing;
	}
 	public Number getWindSpeed(){
		return this.windSpeed;
	}
	public void setWindSpeed(Number windSpeed){
		this.windSpeed = windSpeed;
	}
}
