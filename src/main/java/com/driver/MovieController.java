package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    //movie only
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody() Movie movie){
        movieService.addMovieService(movie);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
//    @PostMapping("/add-movies")
//    public ResponseEntity addMovies(@RequestBody() List<Movie> movie){
//        for (Movie curr:movie
//        ) {
//            movieService.addMovieService(curr);
//        }
//        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
//    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getMovieByNameService(name), HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMoviesService(),HttpStatus.FOUND);
    }

    //director


    //director only
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody() Director director){
        movieService.addDirectorService(director);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
    @PostMapping("/add-directors")
    public ResponseEntity addDirectors(@RequestBody() List<Director> director){
        for (Director curr:director
        ) {
            movieService.addDirectorService(curr);
        }
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getDirectorByNameService(name), HttpStatus.OK);
    }
    @GetMapping("/get-all-directors")
    public ResponseEntity findAllDirectors(){
        return new ResponseEntity<>(movieService.findAllDirectorsService(),HttpStatus.FOUND);
    }

    //pair
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
        return new ResponseEntity<>(movieService.getMoviesByDirectorNameService(director),HttpStatus.OK);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName,
                                                       @RequestParam("directorName") String directorName){
        try {
            movieService.addMovieDirectorPairService(movieName,directorName);
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("directorName") String directorName){
        try {
            movieService.deleteDirectorByNameService(directorName);
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping ("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        try {
            movieService.deleteAllDirectorsService();
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
