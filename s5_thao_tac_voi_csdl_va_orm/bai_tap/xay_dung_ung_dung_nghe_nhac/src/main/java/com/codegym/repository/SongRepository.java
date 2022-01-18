package com.codegym.repository;

import com.codegym.model.Song;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class SongRepository implements ISongRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = entityManager.createQuery("SELECT s FROM Song as s", Song.class);
        return query.getResultList();
    }

    @Override
    public void saveOrUpdate(Song song) {
        if (song.getId() != null) {
            entityManager.merge(song);
        } else {
            entityManager.persist(song);
        }
    }

    @Override
    public Song findById(Long id) {
        TypedQuery<Song> query = entityManager.createQuery("SELECT s FROM Song as s where s.id = :id", Song.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    @Modifying
    @Transactional
    @Override
    public void edit(Song song) {
        System.out.println("test");
        Query query = entityManager
                .createQuery("UPDATE Song as s SET s.songName = :songName, s.singer = :singer, s.songType = :songType," +
                        " s.songPath = :link WHERE s.id = :id");
        query.setParameter("id", song.getId());
        query.setParameter("songName", song.getSongName());
        query.setParameter("singer", song.getSinger());
        query.setParameter("songType", song.getSongType());
        query.setParameter("link", song.getSongPath());
        query.executeUpdate();
    }

    @Override
    public void delete(Long id) {
       Song song = findById(id);
       if (song != null){
           entityManager.remove(song);
       }
    }
}
