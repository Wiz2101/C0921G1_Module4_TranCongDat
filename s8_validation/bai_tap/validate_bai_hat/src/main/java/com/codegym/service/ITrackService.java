package com.codegym.service;

import com.codegym.model.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ITrackService {
    Page<Track> findAll(Pageable pageable);
    Track findById(Long id);
    void save(Track track);
    void deleteById(Long id);
    Page<Track> findByNameContaining(String keyword,Pageable pageable);
}
