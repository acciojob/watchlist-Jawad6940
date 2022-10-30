package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    //movie
    HashMap<String, Movie> movieHm = new HashMap<>();

    public void addMovieRepo(Movie movie) {
        movieHm.put(movie.getName(), movie);
    }

    public Movie getMovieByNameRepo(String name) {
        try {
            Movie curr = movieHm.get(name);
            return curr;
        } catch (Exception e) {
            return null;
        }
    }
        public List<Movie> findAllMoviesRepo () {
            List<Movie> list = new ArrayList<>();
            for (Movie movie : movieHm.values()
            ) {
                list.add(movie);

            }
            return list;
        }
        public void deleteMovie (String name){
            movieHm.remove(name);
        }

        //director
        HashMap<String, Director> directorHm=new HashMap<>();

    public void addDirectorRepo(Director director){
        directorHm.put(director.getName(),director);
    }


    public Director getDirectorByNameRepo(String name) {
        try {
            Director curr=directorHm.get(name);
            return curr;
        }
        catch (Exception e){
            return null;
        }

    }


    public List<Director> findAllDirectorsRepo() {
        List<Director> list= new ArrayList<>();
        for (Director director: directorHm.values()
        ) {
            list.add(director);

        }
        return list;
    }


    public void deleteDirector(String directorName) {
        directorHm.remove(directorName);
    }

    //pair
    HashMap<String,List<String>> pairHm=new HashMap<>();



    public void addMovieDirectorPairRepo(String movieName, String directorName) {
        List<String> movieList;
        if(pairHm.containsKey(directorName)){
            movieList = pairHm.get(directorName);
        }
        else {
            movieList = new ArrayList<>();

        }
        movieList.add(movieName);
        pairHm.put(directorName,movieList);

    }


    public List<String> getMoviesByDirectorNameRepo(String directorName) {
        if(pairHm.containsKey(directorName)) {
            for (String curr : pairHm.keySet()) {
                if (curr.equals(directorName)) {

                    return pairHm.get(curr);
                }
            }
        }
        return null;
    }


    public void deleteDirectorByNameRepo(String directorName) {

        if(pairHm.containsKey(directorName)){

            List<String> movieList=pairHm.get(directorName);
            for (String name:movieList
            ) {
                deleteMovie(name);
            }

            deleteDirector(directorName);
            pairHm.remove(directorName);
        }


    }


    public void deleteAllDirectorsRepo() {
        if(!pairHm.isEmpty()){
            for (String name:pairHm.keySet()){

                deleteDirectorByNameRepo(name);

            }

            pairHm.clear();
        }

    }
    }

