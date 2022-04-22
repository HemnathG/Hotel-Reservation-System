package com.bridgelabz;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

    @Test
    public void givenHotelDetails_WhenValuesEnteredAreCorrect_ShouldReturnTrue()
    {
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Casagrand", 3, 110);
        hotelReservation.addHotel("RiverView", 4, 160);
        hotelReservation.addHotel("The Park", 5, 220);
        int hotelListSize = hotelReservation.getHotelListSize();
        hotelReservation.printHotelList();
        Assert.assertEquals(3, hotelListSize);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelName(){
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("RiverView", 4, 160);
        String hotelName = hotelReservation.getHotelList().get(0).getHotelName();
        Assert.assertEquals("RiverView", hotelName);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelRating(){
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("RiverView", 4, 160);
        int hotelRating = hotelReservation.getHotelList().get(0).getRating();
        Assert.assertEquals(4, hotelRating);
    }

    @Test
    public void givenHotelList_WhenAdded_shouldReturnProperHotelRegularCustomerCost(){
        HotelReservationIF hotelReservation = new HotelReservation();
        hotelReservation.addHotel("RiverView", 4, 160);
        int hotelRegularCustomerCost = (int) hotelReservation.getHotelList().get(0).getRegularCustomerCost();
        Assert.assertEquals(160, hotelRegularCustomerCost);
    }

    @Test
    public void givenHotelDetails_shouldReturnCheapestHotel(){

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Casagrand", 3, 110);
        hotelReservation.addHotel("RiverView", 4, 160);
        LocalDate startDate = LocalDate.of(2022, Month.APRIL, 10);
        LocalDate endDate = LocalDate.of(2022, Month.APRIL, 11);
        Hotel hotel = hotelReservation.getCheapestHotel(startDate, endDate);
        Assert.assertEquals("Casagrand", hotel.getHotelName());
    }
}