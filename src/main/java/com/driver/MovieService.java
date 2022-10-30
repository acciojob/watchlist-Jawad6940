package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    //movie
    public void addMovieService(Movie movie) {
        movieRepository.addMovieRepo(movie);
    }


    public Movie getMovieByNameService(String name) {

        return movieRepository.getMovieByNameRepo(name);
    }


    public List<String> findAllMoviesService() {
        return movieRepository.findAllMoviesRepo();
    }

    public void addDirectorService(Director director) {
        movieRepository.addDirectorRepo(director);
    }


    //Director
    public Director getDirectorByNameService(String name) {
        return movieRepository.getDirectorByNameRepo(name);
    }



    public void addMovieDirectorPairService(String movieName, String directorName) {
        movieRepository.addMovieDirectorPairRepo(movieName, directorName);
    }


    public List<String> getMoviesByDirectorNameService(String directorName) {
        return movieRepository.getMoviesByDirectorNameRepo(directorName);
    }


    public void deleteDirectorByNameService(String directorName) {
        movieRepository.deleteDirectorByNameRepo(directorName);
    }


    public void deleteAllDirectorsService() {
        movieRepository.deleteAllDirectorsRepo();
    }
}

