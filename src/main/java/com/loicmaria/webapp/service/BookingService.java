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


    public void createBooking(int userId, int copyId){
        apiProxy.createBooking(userId, copyId);
    }

    public Booking extendBooking(int bookingId){
        return apiProxy.extendBooking(bookingId);
    }

    public Collection<Booking> findByUserAndStatus(int userId, String status){
        return apiProxy.getBookingsByUserAndStatus(userId, status);
    }


}
