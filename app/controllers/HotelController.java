package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.Security.Authenticator;
import dao.HotelDao;
import dao.ImageDao;
import models.Hotel;
import models.Image;
import models.User;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class HotelController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(HotelController.class);

    private HotelDao hotelDao;

    private ImageDao imageDao;

    @Inject
    public HotelController(HotelDao hotelDao, ImageDao imageDao) {
        this.hotelDao = hotelDao;
        this.imageDao = imageDao;
    }

    @Transactional
    @Authenticator
    public Result createHotel() {

        final JsonNode json = request().body().asJson();
        final Hotel hotel = Json.fromJson(json, Hotel.class);

        final User user = (User) ctx().args.get("user");
        hotel.setUser(user);

//        final Optional<Hotel> existingHotel= hotelDao.findHotel(hotel.getName(),hotel.getLocation());
//        if(existingHotel.isPresent()){
//            return badRequest("Hotel exists already");
//        }

        final Boolean present = hotelDao.findHotel(hotel.getName(),hotel.getLocation());
        if(present == true){
            return badRequest("Hotel already exists");
        }
        else {

            final Hotel newHotel = hotelDao.create(hotel);

            for (String url : hotel.getImageUrls()) {
                final Image image = new Image(url);
                image.setImageUrl(url);
                image.setHotel(newHotel);
                imageDao.create(image);
            }

            final JsonNode result = Json.toJson(newHotel);

            return ok(result);
        }
    }


    @Transactional
    public Result getHotelByUsername() {

        final JsonNode json = request().body().asJson();
        final Hotel hotel = Json.fromJson(json, Hotel.class);
        final String username = json.get("username").asText();

        LOGGER.debug("img url is ");
        Collection<Hotel> hotels = hotelDao.searchByUsername(username);


        for (Hotel h : hotels) {
            String[] images = imageDao.getImageById(h.getId());
            h.setImageUrls(images);
        }

        final JsonNode result = Json.toJson(hotels);
        return ok(result);

    }


        @Transactional
    public Result getHotelById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }


        final Optional<Hotel> findhotel = hotelDao.read(id);

        if (findhotel.isPresent()) {
            final JsonNode result = Json.toJson(findhotel.get());
            final Hotel hotel = Json.fromJson(result, Hotel.class);
            String[] images = imageDao.getImageById(id);
            hotel.setImageUrls(images);
            final JsonNode finalresult = Json.toJson(hotel);
            return ok(finalresult);
        } else {
            return notFound();
        }

    }



    @Transactional
    public Result updateHotelById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final JsonNode json = request().body().asJson();
        final Hotel newHotel = Json.fromJson(json, Hotel.class);

        newHotel.setId(id);

        if(null!=newHotel.getImageUrls()) {

            for (String url : newHotel.getImageUrls()) {
                final Image image = new Image(url);
                image.setImageUrl(url);
                image.setHotel(newHotel);
                imageDao.create(image);
            }
        }
        final Hotel updatedHotel = hotelDao.update(newHotel);

        String[] images = imageDao.getImageById(id);
        updatedHotel.setImageUrls(images);

        final JsonNode result = Json.toJson(updatedHotel);
        return ok(result);
    }

    @Transactional
    public Result deleteHotelById(Integer id) {

        if (null == id) {
            return badRequest("Id must be provided");
        }

        final Optional<Hotel> findhotel = hotelDao.read(id);


        if (findhotel.isPresent()) {
            final JsonNode result = Json.toJson(findhotel.get());
            final Hotel hotel = Json.fromJson(result, Hotel.class);
            String[] images = imageDao.getImageById(id);
            hotel.setImageUrls(images);

            for(String url: hotel.getImageUrls()){
                imageDao.delete(url);
            }

        }

        final Hotel hotel = hotelDao.delete(id);

        final JsonNode result = Json.toJson(hotel);
        return ok(result);
    }

    @Transactional
    public Result getAllHotels() {

        Collection<Hotel> hotels = hotelDao.all();

        for (Hotel h : hotels) {
            String[] images = imageDao.getImageById(h.getId());
            h.setImageUrls(images);
        }

        final JsonNode result = Json.toJson(hotels);
        return ok(result);
    }


    @Transactional
    public Result searchHotels(String location, Integer maxP){

        final JsonNode json = request().body().asJson();
        final String roomType = json.get("type").asText();

        Collection<Hotel> hotels = hotelDao.search(location, maxP, roomType);

        for (Hotel h : hotels) {
            String[] images = imageDao.getImageById(h.getId());
            h.setImageUrls(images);
        }

        final JsonNode result = Json.toJson(hotels);
        return ok(result);
    }

}




