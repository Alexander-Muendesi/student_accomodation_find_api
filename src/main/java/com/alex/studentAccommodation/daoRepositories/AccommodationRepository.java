package com.alex.studentAccommodation.daoRepositories;

import com.alex.studentAccommodation.entities.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccommodationRepository extends JpaRepository<Accommodation, UUID> {

}
