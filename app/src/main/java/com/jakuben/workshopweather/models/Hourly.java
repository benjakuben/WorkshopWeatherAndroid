
package com.jakuben.workshopweather.models;

import java.util.List;

public class Hourly{
   	private List data;
   	private String icon;
   	private String summary;

 	public List getData(){
		return this.data;
	}
	public void setData(List data){
		this.data = data;
	}
 	public String getIcon(){
		return this.icon;
	}
	public void setIcon(String icon){
		this.icon = icon;
	}
 	public String getSummary(){
		return this.summary;
	}
	public void setSummary(String summary){
		this.summary = summary;
	}
}
