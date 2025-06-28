package com.csrent.controller;

import com.csrent.dto.ReservationDTO;
import com.csrent.model.Reservation;
import com.csrent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin (origins = "*")
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
@GetMapping
    public ResponseEntity<List<Reservation>> getAll(){
        return ResponseEntity.ok(reservationService.getAll());
    }
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(reservationService.add(reservationDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Integer id) {
        Reservation reservation = reservationService.getById(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservation);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Integer id, @RequestBody ReservationDTO dto) {
        Reservation updated = reservationService.update(id, dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Integer id) {
        if (reservationService.findById(id).isPresent()) {
            reservationService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservación no encontrada");
        }
    }

}

