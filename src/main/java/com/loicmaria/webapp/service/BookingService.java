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
    @Autowired
    UserService userService;
    @Autowired
    CopyService copyService;

    public void createBooking(int userId, int copyId){
        apiProxy.createBooking(userId, copyId);
    }


}
