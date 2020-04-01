package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DBsender implements CommandLineRunner {
    @Autowired
    private HotelRepository hotelRepository;
    public DBsender(HotelRepository hotelRepository){
        this.hotelRepository=hotelRepository;
    }
    @Override
    public void run(String... strings) throws Exception{
        Hotel marriot=new Hotel(
                "Marriot",130,
                new Address("Paris","France"),
                Arrays.asList(
                        new Review("John",8,false),
                        new Review("Mary",10,true)
                )
        );
        Hotel ibis=new Hotel(
                "Ibis",190,
                new Address("Bangalore","India"),
                Arrays.asList(
                        new Review("Danish",7,true)
                )
        );
        Hotel sofitel=new Hotel(
                "Sofitel",200,
                new Address("Delhi","India"),
                new ArrayList<>()
        );
        //drop all hotel
        this.hotelRepository.deleteAll();
        //add our hotel to database
        List<Hotel>hotels= Arrays.asList(marriot,ibis,sofitel);
        this.hotelRepository.saveAll(hotels);
    }
}
