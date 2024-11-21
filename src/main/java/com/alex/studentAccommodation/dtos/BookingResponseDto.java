package com.alex.studentAccommodation.dtos;

import com.alex.studentAccommodation.constants.BookingStatus;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public class BookingResponseDto {
    private UUID bookingId;
    private UUID studentId;
    private UUID accommodationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BookingStatus status;
    private Timestamp createdAt;

    public BookingResponseDto(){}

    public BookingResponseDto(UUID bookingId, UUID studentId, UUID accommodationId, LocalDate startDate, LocalDate endDate, BookingStatus status, Timestamp createdAt) {
        this.bookingId = bookingId;
        this.studentId = studentId;
        this.accommodationId = accommodationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(UUID accommodationId) {
        this.accommodationId = accommodationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "BookingResponseDto{" +
                "bookingId=" + bookingId +
                ", studentId=" + studentId +
                ", accommodationId=" + accommodationId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
