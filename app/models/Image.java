package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @Column(length = 1000)
    @JsonProperty("imageUrl")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="id")
    private Hotel hotel;

    public Image(String imageUrl){

        this.imageUrl=imageUrl;
    }

    public Image() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}



