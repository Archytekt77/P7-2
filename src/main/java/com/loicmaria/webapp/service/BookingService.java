package com.loicmaria.webapp.service;

import com.loicmaria.webapp.model.Booking;
import com.loicmaria.webapp.proxies.ApiProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Data
@Service
public class BookingService {
    
    @Autowired
    ApiProxy apiProxy;


    /*public void createBooking(int userId, int copyId){
        apiProxy.createBooking(userId, copyId);
    }*/

    public Booking extendBooking(Booking booking){
        return apiProxy.extendBooking(booking);
    }

    public Collection<Booking> findByUser_IdAndStatus(int userId, String status){
        return apiProxy.getBookingsByUser_IdAndStatus(userId, status);
    }


}
