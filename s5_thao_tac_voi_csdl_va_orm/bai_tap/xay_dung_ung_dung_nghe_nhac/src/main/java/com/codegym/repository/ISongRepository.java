package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    void saveOrUpdate(Song song);
    Song findById(Long id);
    void edit (Song song);
    void delete (Long id);
}
