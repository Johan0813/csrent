package com.csrent.service;

import com.csrent.dto.ReservationDTO;
import com.csrent.model.Reservation;
import com.csrent.model.Space;
import com.csrent.model.User;
import com.csrent.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final SpaceService spaceService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserService userService, SpaceService spaceService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.spaceService = spaceService;
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation add(ReservationDTO reservationDTO) {
        User user = userService.getUserByEmail(reservationDTO.getEmailuser());
        Space space = spaceService.getSpace(reservationDTO.getIdSpace());
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setSpace(space);
        reservation.setDateReservation(reservationDTO.getDate());
        reservation.setStatus(reservationDTO.getStatus());

        return reservationRepository.save(reservation);
    }

    public Reservation getById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation update(Integer id, ReservationDTO dto) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        if (reservation == null) return null;

        User user = userService.getUserByEmail(dto.getEmailuser());
        Space space = spaceService.getSpace(dto.getIdSpace());

        if (user != null) reservation.setUser(user);
        if (space != null) reservation.setSpace(space);
        if (dto.getDate() != null) reservation.setDateReservation(dto.getDate());
        if (dto.getStatus() != null) reservation.setStatus(dto.getStatus());

        return reservationRepository.save(reservation);
    }
}
