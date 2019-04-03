package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Basic
    @JsonProperty("name")
    private String name;

    @Basic
    @JsonProperty("location")
    private String location;

    @Basic
    @JsonProperty("sprice")
    private Integer sprice;

    @Basic
    @JsonProperty("dprice")
    private Integer dprice;

    @Basic
    @JsonProperty("suprice")
    private Integer suprice;

    @Basic
    @Column(length = 7000)
    @JsonProperty("address")
    private String address;


    @Basic
    @JsonProperty("rating")
    private String rating;

    @Basic
    @Column(length = 7000)
    @JsonProperty("description")
    private String description;

    @Basic
    @JsonProperty("latitude")
    private String latitude;

    @Basic
    @JsonProperty("longitude")
    private String longitude;

    @Basic
    @JsonProperty("url")
    private String url;

//    @Basic
//    @JsonProperty("amenities")
//    private String amenities;

    @Transient
    @JsonProperty("imageUrls")
    private String[] imageUrls;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("amenities")
    private Amenities amenities;


    public Hotel(Integer id, String name, String location, String rating, String description, String url, String[] imageUrls, Integer sprice, Integer dprice, Integer suprice, String address, String latitude, String longitude)
    {
        this.id=id;
        this.name = name;
        this.location = location;
        this.sprice = sprice;
        this.dprice = dprice;
        this.suprice = suprice;
        this.rating = rating;
        this.description=description;
        this.url=url;
       // this.amenities=amenities;
        this.imageUrls = imageUrls;
        this.address = address;
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public Hotel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSprice() {
        return sprice;
    }

    public void setSprice(Integer sprice) {
        this.sprice = sprice;
    }

    public Integer getDprice() {
        return dprice;
    }

    public void setDprice(Integer dprice) {
        this.dprice = dprice;
    }

    public Integer getSuprice() {
        return suprice;
    }

    public void setSuprice(Integer suprice) {
        this.suprice = suprice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

