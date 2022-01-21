package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TrackDto implements Validator {
    private Long id;
    private String name;
    private String artist;
    private String genre;

    public TrackDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TrackDto trackDto = (TrackDto) target;
        String name = trackDto.getName();
        if (!name.matches("^(\\w\\s?){0,799}\\w$")){
            errors.rejectValue("name","name.rejected","Name must not be empty. It must not contain special characters!");
        }

        String artist = trackDto.getArtist();
        if (!artist.matches("^(\\w\\s?){0,299}\\w$")){
            errors.rejectValue("artist","artist.rejected","Artist must not be empty. It must not contain special characters!");
        }

        String genre = trackDto.getGenre();
        if (!genre.matches("^(\\w,?\\s?){0,999}\\w$")){
            errors.rejectValue("genre","genre.rejected","Genre must not be empty. It must not contain special characters!");
        }

    }
}
