package getlandestate.pojos;

import java.io.Serializable;

public class US_01_PinarTourRequestPut implements Serializable {
	private String tourDate;
	private String tourTime;
	private String message;
	private int advertId;

	public US_01_PinarTourRequestPut() {
	}

	public US_01_PinarTourRequestPut(String tourDate, String tourTime, String message, int advertId) {
		this.tourDate = tourDate;
		this.tourTime = tourTime;
		this.message = message;
		this.advertId = advertId;
	}

	public void setTourDate(String tourDate){
		this.tourDate = tourDate;
	}

	public String getTourDate(){
		return tourDate;
	}

	public void setTourTime(String tourTime){
		this.tourTime = tourTime;
	}

	public String getTourTime(){
		return tourTime;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setAdvertId(int advertId){
		this.advertId = advertId;
	}

	public int getAdvertId(){
		return advertId;
	}

	@Override
	public String toString() {
		return "US_01_PinarTourRequestPut{" +
				"tourDate='" + tourDate + '\'' +
				", tourTime='" + tourTime + '\'' +
				", message='" + message + '\'' +
				", advertId=" + advertId +
				'}';
	}

}