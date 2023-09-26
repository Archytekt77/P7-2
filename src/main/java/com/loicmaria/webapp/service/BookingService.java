package com.loicmaria.webapp.service;

import com.loicmaria.webapp.form.BookingForm;
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

    public Booking convertBookingFormToBooking(Booking booking, BookingForm bookingForm){
        booking.setStatus(bookingForm.getStatus());
        booking.setExtraTime(bookingForm.isExtraTime());
        booking.setBook(apiProxy.getBook(bookingForm.getIdBook()));
        booking.setUser(apiProxy.getUser(bookingForm.getIdUser()));

        return booking;
    }

    public void createBooking(BookingForm bookingForm){
        Booking booking = convertBookingFormToBooking(new Booking(), bookingForm);
        apiProxy.createBooking(booking);
    }

    public Booking getBooking(int id){
        return apiProxy.getBooking(id);
    }

    public Collection<Booking> getBookings(){
        return apiProxy.getBookings();
    }

    public Booking updateBooking(int id, BookingForm bookingForm){
        Booking booking = convertBookingFormToBooking(apiProxy.getBooking(id), bookingForm);
        return apiProxy.updateBooking(id, booking);
    }

    public void deleteBooking(int id){
        apiProxy.deleteBooking(id);
    }
}
