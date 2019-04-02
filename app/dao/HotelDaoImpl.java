package dao;

import controllers.HotelController;
import models.Amenities;
import models.Hotel;
import models.Image;
import play.db.jpa.JPAApi;
import play.libs.F;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import play.Logger;

public class HotelDaoImpl implements HotelDao {

    private final static Logger.ALogger LOGGER = Logger.of(HotelController.class);

    final JPAApi jpaApi;

    @Inject
    public HotelDaoImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    public Hotel create(Hotel hotel) {

        if (null == hotel) {
            throw new IllegalArgumentException("Book must be provided");
        }

        jpaApi.em().persist(hotel);
        return hotel;
    }

    public Optional<Hotel> read(Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("Id must be provided");
        }

        final Hotel hotel = jpaApi.em().find(Hotel.class, id);
        return hotel != null ? Optional.of(hotel) : Optional.empty();

    }


//    public Optional<Hotel> findHotel(String name, String location){
//
//
//        if((null==name)||(null==location)){
//            throw new IllegalArgumentException("Name or Location must be provided");
//        }
//
//        TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where name = '" + name + "' AND location = '" + location + "'",Hotel.class);
//        query.setMaxResults(1);
//        final Hotel hotel = query.getResultList();
//        return hotel != null ? Optional.of(hotel) : Optional.empty();
//    }


    public Collection<Hotel> searchByUsername(String username){

        if(null == username) {
            throw new IllegalArgumentException("username must be provided");
        }

        LOGGER.debug(username);
        TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where username = '" + username + "'", Hotel.class);
        List<Hotel> hotels = query.getResultList();
        return hotels;
    }


    public Collection<Hotel> search(String location, Integer maxP, String roomType) {

        LOGGER.debug(location);

        LOGGER.debug(String.valueOf(maxP));

        final String room = roomType;
        LOGGER.debug(room);

        if(room.compareTo("single")==0){

            LOGGER.debug("Inside single");

            if ((null == location) && (null == maxP)) {

                LOGGER.debug("Inside single1");

                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b", Hotel.class);
                List<Hotel> hotels = query.getResultList();

                return hotels;
            } else if (null == maxP) {

                LOGGER.debug("Inside single2");

                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where (location like '" + location + "%' OR name like '" +location+ "%')", Hotel.class);
                List<Hotel> hotels = query.getResultList();
                return hotels;
            } else if (null == location) {

                LOGGER.debug("Inside single3");

                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where sprice BETWEEN 0 AND '"+maxP+"'  ", Hotel.class);
                List<Hotel> hotels = query.getResultList();
                return hotels;
            } else {

                LOGGER.debug("Inside single4");

                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where (location like '" + location + "%' OR name like '" +location+ "%') AND (sprice BETWEEN 0 AND '"+maxP+"') ", Hotel.class);
                List<Hotel> hotels = query.getResultList();
                return hotels;
            }

        }
        else if(room.compareTo("double")==0){

            if ((null == location) && (null == maxP)) {

                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b", Hotel.class);
                List<Hotel> hotels = query.getResultList();

                return hotels;
            } else if (null == maxP) {
                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where (location like '" + location + "%' OR name like '" +location+ "%')", Hotel.class);
                List<Hotel> hotels = query.getResultList();
                return hotels;
            } else if (null == location) {
                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where dprice BETWEEN 0 AND '"+maxP+"'  ", Hotel.class);
                List<Hotel> hotels = query.getResultList();
                return hotels;
            } else {
                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where (location like '" + location + "%' OR name like '" +location+ "%') AND (dprice BETWEEN 0 AND '"+maxP+"') ", Hotel.class);
                List<Hotel> hotels = query.getResultList();
                return hotels;
            }

        }
        else {

            if ((null == location) && (null == maxP)) {

                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b", Hotel.class);
                List<Hotel> hotels = query.getResultList();

                return hotels;
            } else if (null == maxP) {
                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where (location like '" + location + "%' OR name like '" + location + "%')", Hotel.class);
                List<Hotel> hotels = query.getResultList();
                return hotels;
            } else if (null == location) {
                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where suprice BETWEEN 0 AND '" + maxP + "'  ", Hotel.class);
                List<Hotel> hotels = query.getResultList();
                return hotels;
            } else {
                TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where (location like '" + location + "%' OR name like '" + location + "%') AND (suprice BETWEEN 0 AND '" + maxP + "') ", Hotel.class);
                List<Hotel> hotels = query.getResultList();
                return hotels;
            }
        }
    }


//    public Collection<Hotel> Trial(String location, Integer minP, Integer maxP){
//
//        LOGGER.debug(location);
//        LOGGER.debug(String.valueOf(minP));
//        LOGGER.debug(String.valueOf(maxP));
//
//        TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b where (location = '" + location + "') AND (price BETWEEN '"+minP+"' AND '"+maxP+"') ", Hotel.class);
//        List<Hotel> hotels = query.getResultList();
//        return hotels;
//
//    }


    public Hotel update(Hotel hotel) {

        if (null == hotel) {
            throw new IllegalArgumentException("Book must be provided");
        }

        if (null == hotel.getId()) {
            throw new IllegalArgumentException("Book id must be provided");
        }

        final Hotel existingHotel = jpaApi.em().find(Hotel.class, hotel.getId());
        if (null == existingHotel) {
            return null;
        }

        final Integer amenid = existingHotel.getAmenities().getId();

        final Amenities existingAmenities = jpaApi.em().find(Amenities.class,amenid);


        if(null!=hotel.getName()) {

            existingHotel.setName(hotel.getName());
        }
        if(null!=hotel.getLocation()) {

            existingHotel.setLocation(hotel.getLocation());
        }
        if(null!=hotel.getSprice()) {

            existingHotel.setSprice(hotel.getSprice());
        }
        if(null!=hotel.getDprice()) {

            existingHotel.setDprice(hotel.getDprice());
        }
        if(null!=hotel.getSuprice()) {

            existingHotel.setSuprice(hotel.getSuprice());
        }
        if(null!=hotel.getRating()) {

            existingHotel.setRating(hotel.getRating());
        }
        if(null!=hotel.getUrl()) {

            existingHotel.setUrl(hotel.getUrl());
        }

        if(null!=hotel.getLatitude()) {

            existingHotel.setLatitude(hotel.getLatitude());
        }

        if(null!=hotel.getLongitude()) {

            existingHotel.setLongitude(hotel.getLongitude());
        }

        if(null!=hotel.getDescription()) {

            existingHotel.setDescription(hotel.getDescription());
        }

        if(null!=hotel.getAmenities()) {

            existingHotel.setAmenities(hotel.getAmenities());

        }


        existingHotel.setName(hotel.getName());


        jpaApi.em().remove(existingAmenities);


        jpaApi.em().persist(existingHotel);

        return existingHotel;
    }

    public Hotel delete(Integer id) {

        if (null == id) {
            throw new IllegalArgumentException("Book id must be provided");
        }

        final Hotel existingHotel = jpaApi.em().find(Hotel.class, id);



        if (null == existingHotel) {
            return null;
        }


        jpaApi.em().remove(existingHotel);

        return existingHotel;
    }

    public Collection<Hotel> all() {

        TypedQuery<Hotel> query = jpaApi.em().createQuery("SELECT b FROM Hotel b", Hotel.class);
        List<Hotel> hotels = query.getResultList();

        return hotels;
    }

}
