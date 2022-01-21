package com.codegym.service;

import com.codegym.model.Track;
import com.codegym.repository.ITrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrackService implements ITrackService {
    @Autowired
    ITrackRepository trackRepository;


    @Override
    public Page<Track> findAll(Pageable pageable) {
        return trackRepository.findAll(pageable);
    }

    @Override
    public Track findById(Long id) {
        return trackRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Track track) {
        trackRepository.save(track);
    }

    @Override
    public void deleteById(Long id) {
        trackRepository.deleteById(id);
    }

    @Override
    public Page<Track> findByNameContaining(String keyword,Pageable pageable) {
        return trackRepository.findAllByNameContaining(keyword,pageable);
    }
}
