package com.coolapps.yo.tuto4u;

public class TutorData {
    private String text1;
    private String text2;
    private Integer image;

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public Integer getImage() {
        return image;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TutorData{" +
                "text1='" + text1 + '\'' +
                ", text2='" + text2 + '\'' +
                ", image=" + image +
                '}';
    }
}
