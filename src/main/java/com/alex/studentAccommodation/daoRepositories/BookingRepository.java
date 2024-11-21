package com.alex.studentAccommodation.daoRepositories;

import com.alex.studentAccommodation.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
