package dao;

import models.Hotel;

import java.util.Collection;
import java.util.Optional;


public interface HotelDao extends CrudDao<Hotel, Integer> {

    Collection<Hotel> search(String location,Integer maxP);
    Collection<Hotel> searchByUsername(String username);
//    Optional<Hotel> findHotel(String name, String location);

}



/*
package dao;

import com.google.inject.Inject;
import models.Hotel;
import play.db.jpa.JPAApi;

import java.util.Collection;

public interface HotelDao extends CrudDao<Hotel, Integer>{
    Collection<Hotel> createHotel(Collection<Hotel> foodItems);

}*/