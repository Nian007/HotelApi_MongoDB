package com.example.demo.controller;

import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  @Autowired private HotelRepository hotelRepository;

  @GetMapping("/all")
  public ResponseEntity<List<Hotel>> getAllHotel() {
    List<Hotel> hotels = hotelRepository.findAll();
    if (Objects.isNull(hotels) || hotels.isEmpty()) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.ok(hotels);
    }
  }
}
