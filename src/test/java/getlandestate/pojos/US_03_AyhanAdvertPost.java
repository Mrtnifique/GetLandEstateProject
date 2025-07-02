package getlandestate.pojos;

import java.util.List;

public class US_03_AyhanAdvertPost {
    private List<String> images;

    public US_03_AyhanAdvertPost() {}

    public US_03_AyhanAdvertPost(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
