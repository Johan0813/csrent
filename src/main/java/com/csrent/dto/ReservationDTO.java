package com.csrent.dto;

import java.time.LocalDate;

public class ReservationDTO {
    private String emailuser;
    private Integer idSpace;
    private LocalDate date;
    private String status;

    public ReservationDTO() {
    }

    public ReservationDTO(String emailuser, Integer idSpace, LocalDate date, String status) {
        this.emailuser = emailuser;
        this.idSpace = idSpace;
        this.date = date;
        this.status = status;
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }

    public Integer getIdSpace() {
        return idSpace;
    }

    public void setIdSpace(Integer idSpace) {
        this.idSpace = idSpace;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
