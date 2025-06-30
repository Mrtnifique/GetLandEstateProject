package getlandestate.pojos;

import java.io.Serializable;
import java.util.List;

public class US_01_PinarTourRequestResponse implements Serializable {
    // POST yanıtı için ortak alanlar
    private int id;
    private String tourDate;
    private String tourTime;
    private String status;

    // GET /tour-requests/customer yanıtı için ek alanlar
    private List<Content> content;
    private int totalPages;
    private int totalElements;
    private boolean last;
    private int size;
    private int number;
    private boolean first;
    private int numberOfElements;
    private boolean empty;


    // İç sınıf: Content
    public static class Content {
        private int id;
        private String tourDate;
        private String tourTime;
        private String status;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "id=" + id +
                    ", tourDate='" + tourDate + '\'' +
                    ", tourTime='" + tourTime + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    // Getter & Setter'lar
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTourDate() { return tourDate; }

    public void setTourDate(String tourDate) { this.tourDate = tourDate; }

    public String getTourTime() { return tourTime; }

    public void setTourTime(String tourTime) { this.tourTime = tourTime; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    @Override
    public String toString() {
        return "US_01_PinarTourRequestResponse{" +
                "id=" + id +
                ", tourDate='" + tourDate + '\'' +
                ", tourTime='" + tourTime + '\'' +
                ", status='" + status + '\'' +
                ", content=" + content +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", last=" + last +
                ", size=" + size +
                ", number=" + number +
                ", first=" + first +
                ", numberOfElements=" + numberOfElements +
                ", empty=" + empty +
                '}';
    }
}
