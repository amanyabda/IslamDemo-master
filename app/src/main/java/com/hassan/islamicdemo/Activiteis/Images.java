package com.hassan.islamicdemo.Activiteis;

public class Images {

 private  int image;
 private String save,share,wall;

    public Images(int image, String save, String share, String wall) {
        this.image = image;
        this.save = save;
        this.share = share;
        this.wall = wall;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }
}
