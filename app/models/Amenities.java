package models;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class  Amenities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Basic
    @JsonProperty("wifi")
    private Boolean wifi;

    @Basic
    @JsonProperty("handicapped")
    private Boolean handicapped;

    @Basic
    @JsonProperty("pets")
    private Boolean pets;

    @Basic
    @JsonProperty("ocheckin")
    private Boolean ocheckin;

    @Basic
    @JsonProperty("bar")
    private Boolean bar;

    @Basic
    @JsonProperty("gym")
    private Boolean gym;

    @Basic
    @JsonProperty("parking")
    private Boolean parking;

    @Basic
    @JsonProperty("breakfast")
    private Boolean breakfast;

    @Basic
    @JsonProperty("pool")
    private Boolean pool;

    @Basic
    @JsonProperty("business")
    private Boolean business;

    @Basic
    @JsonProperty("medical")
    private Boolean medical;

    @Basic
    @JsonProperty("playarea")
    private Boolean playarea;

    @Basic
    @JsonProperty("library")
    private Boolean library;

    @Basic
    @JsonProperty("theatre")
    private Boolean theatre;

    @Basic
    @JsonProperty("laundry")
    private Boolean laundry;

    @Basic
    @JsonProperty("iron")
    private Boolean iron;

    @Basic
    @JsonProperty("fridge")
    private Boolean fridge;

    @Basic
    @JsonProperty("refreshments")
    private Boolean refreshments;

    @Basic
    @JsonProperty("connrooms")
    private Boolean connrooms;

    @Basic
    @JsonProperty("airConditioning")
    private Boolean airConditioning;


    public Amenities(Integer id, Boolean wifi, Boolean handicapped, Boolean pets, Boolean ocheckin, Boolean bar, Boolean gym, Boolean parking, Boolean breakfast, Boolean pool, Boolean business, Boolean medical, Boolean playarea, Boolean library, Boolean theatre, Boolean laundry, Boolean iron, Boolean fridge, Boolean refreshments, Boolean airConditioning,  Boolean connrooms){

        this.id=id;
        this.wifi=wifi;
        this.handicapped=handicapped;
        this.pets=pets;
        this.ocheckin=ocheckin;
        this.bar=bar;
        this.gym=gym;
        this.parking=parking;
        this.breakfast=breakfast;
        this.pool=pool;
        this.business=business;
        this.medical=medical;
        this.playarea=playarea;
        this.library=library;
        this.theatre=theatre;
        this.laundry=laundry;
        this.iron=iron;
        this.fridge=fridge;
        this.refreshments=refreshments;
        this.airConditioning=airConditioning;
        this.connrooms=connrooms;
    }

    public Amenities() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getHandicapped() {
        return handicapped;
    }

    public void setHandicapped(Boolean handicapped) {
        this.handicapped = handicapped;
    }

    public Boolean getPets() {
        return pets;
    }

    public void setPets(Boolean pets) {
        this.pets = pets;
    }

    public Boolean getOcheckin() {
        return ocheckin;
    }

    public void setOcheckin(Boolean ocheckin) {
        this.ocheckin = ocheckin;
    }

    public Boolean getBar() {
        return bar;
    }

    public void setBar(Boolean bar) {
        this.bar = bar;
    }

    public Boolean getGym() {
        return gym;
    }

    public void setGym(Boolean gym) {
        this.gym = gym;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Boolean getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

    public Boolean getPool() {
        return pool;
    }

    public void setPool(Boolean pool) {
        this.pool = pool;
    }

    public Boolean getBusiness() {
        return business;
    }

    public void setBusiness(Boolean business) {
        this.business = business;
    }

    public Boolean getMedical() {
        return medical;
    }

    public void setMedical(Boolean medical) {
        this.medical = medical;
    }

    public Boolean getPlayarea() {
        return playarea;
    }

    public void setPlayarea(Boolean playarea) {
        this.playarea = playarea;
    }

    public Boolean getLibrary() {
        return library;
    }

    public void setLibrary(Boolean library) {
        this.library = library;
    }

    public Boolean getTheatre() {
        return theatre;
    }

    public void setTheatre(Boolean theatre) {
        this.theatre = theatre;
    }

    public Boolean getLaundry() {
        return laundry;
    }

    public void setLaundry(Boolean laundry) {
        this.laundry = laundry;
    }

    public Boolean getIron() {
        return iron;
    }

    public void setIron(Boolean iron) {
        this.iron = iron;
    }

    public Boolean getFridge() {
        return fridge;
    }

    public void setFridge(Boolean fridge) {
        this.fridge = fridge;
    }

    public Boolean getRefreshments() {
        return refreshments;
    }

    public void setRefreshments(Boolean refreshments) {
        this.refreshments = refreshments;
    }

    public Boolean getConnrooms() {
        return connrooms;
    }

    public void setConnrooms(Boolean connrooms) {
        this.connrooms = connrooms;
    }

    public Boolean getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Boolean airConditioning) {
        this.airConditioning = airConditioning;
    }
}

