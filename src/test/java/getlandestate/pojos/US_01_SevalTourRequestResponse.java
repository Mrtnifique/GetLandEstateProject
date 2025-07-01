package getlandestate.pojos;

public class US_01_SevalTourRequestResponse {

    private int id;
    private String tourDate;
    private String tourTime;
    private String message;
    private String status;
    private int advertId;
    private String createdAt;
    private String updatedAt;

    // Default constructor
    public US_01_SevalTourRequestResponse() {
    }

    // Parameterized constructor
    public US_01_SevalTourRequestResponse(int id, String tourDate, String tourTime, String message,
                                          String status, int advertId, String createdAt, String updatedAt) {
        this.id = id;
        this.tourDate = tourDate;
        this.tourTime = tourTime;
        this.message = message;
        this.status = status;
        this.advertId = advertId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAdvertId() {
        return advertId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "US_01_SevalTourRequestResponse{" +
               "id=" + id +
               ", tourDate='" + tourDate + '\'' +
               ", tourTime='" + tourTime + '\'' +
               ", message='" + message + '\'' +
               ", status='" + status + '\'' +
               ", advertId=" + advertId +
               ", createdAt='" + createdAt + '\'' +
               ", updatedAt='" + updatedAt + '\'' +
               '}';
    }
}