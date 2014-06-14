
package com.jakuben.workshopweather.models;

import java.util.List;

public class Flags{
   	private List darkskyStations;
   	private List isdStations;
   	private List lampStations;
   	private List madisStations;
   	private List sources;
   	private String units;

 	public List getDarkskyStations(){
		return this.darkskyStations;
	}
	public void setDarkskyStations(List darkskyStations){
		this.darkskyStations = darkskyStations;
	}
 	public List getIsdStations(){
		return this.isdStations;
	}
	public void setIsdStations(List isdStations){
		this.isdStations = isdStations;
	}
 	public List getLampStations(){
		return this.lampStations;
	}
	public void setLampStations(List lampStations){
		this.lampStations = lampStations;
	}
 	public List getMadisStations(){
		return this.madisStations;
	}
	public void setMadisStations(List madisStations){
		this.madisStations = madisStations;
	}
 	public List getSources(){
		return this.sources;
	}
	public void setSources(List sources){
		this.sources = sources;
	}
 	public String getUnits(){
		return this.units;
	}
	public void setUnits(String units){
		this.units = units;
	}
}
