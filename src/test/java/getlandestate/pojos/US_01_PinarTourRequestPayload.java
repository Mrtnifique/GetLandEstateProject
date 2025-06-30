package getlandestate.pojos;

public class US_01_PinarTourRequestPayload {

    private String tourDate;
    private String tourTime;
    private String message;
    private int advertId;



    // Getter ve Setter'lar
    public String getTourDate() {
        return tourDate;
    }

    public void setTourDate(String tourDate) {
        this.tourDate = tourDate;
    }

    public String getTourTime() {
        return tourTime;
    }

    public void setTourTime(String tourTime) {
        this.tourTime = tourTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAdvertId() {
        return advertId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    // toString metodu (loglama için faydalı)
    @Override
    public String toString() {
        return "US_01_PinarTourRequestPayload{" +
                "tourDate='" + tourDate + '\'' +
                ", tourTime='" + tourTime + '\'' +
                ", message='" + message + '\'' +
                ", advertId=" + advertId +
                '}';
    }
}
