package com.example.demo.controller;

import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  @Autowired
  private HotelRepository hotelRepository;

  @GetMapping("/all")
  public ResponseEntity<List<Hotel>> getAllHotel() {
    List<Hotel> hotels = hotelRepository.findAll();
    if (Objects.isNull(hotels) || hotels.isEmpty()) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.ok(hotels);
    }
  }
  //Please check this
  @PutMapping
  public void update(@RequestBody Hotel hotel){
    hotelRepository.insert(hotel);
  }
  //Please check this
  @PostMapping
  public void save(@RequestBody Hotel hotel){
    hotelRepository.save(hotel);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") String id){
    hotelRepository.deleteById(id);
  }
  @GetMapping("/{id}")
  public Optional<Hotel> getById(@PathVariable("id") String id){
    Optional<Hotel> hotel=hotelRepository.findById(id);
    return  hotel;
  }
  @GetMapping("/price/{maxPrice}")
  public List<Hotel>getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
    List<Hotel> hotels=hotelRepository.findByPricePerNightLessThan(maxPrice);
    return hotels;
  }
  //Please check this
  @GetMapping("/address/{city}")
  public List<Hotel>getByCity(@PathVariable("city") String city){
    List<Hotel>hotels=hotelRepository.findByCity(city);
    return hotels;
  }
}
