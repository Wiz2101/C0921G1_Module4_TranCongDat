package com.codegym.repository;

import com.codegym.model.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrackRepository extends JpaRepository<Track,Long> {
    Page<Track> findAllByNameContaining (String keyword, Pageable pageable);
}
