package ua.org.gostroy.mimicFlickr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.org.gostroy.mimicFlickr.model.Photo;
import ua.org.gostroy.mimicFlickr.service.PhotoService;
import ua.org.gostroy.mimicFlickr.web.model.criteria.PhotoCriteria;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Sergey on 12/21/2015.
 */
@Controller
@RequestMapping("/photo/")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @RequestMapping(path = {"", "list"},method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<Photo> getAll(@RequestHeader HttpHeaders httpHeaders) {
        List<Photo> photos = photoService.findAll();
        return photos;
    }

    @RequestMapping(path = {"search"},method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<Photo> getAllByCriteria(@ModelAttribute PhotoCriteria photoCriteria) {
        List<Photo> photos = photoService.findAllByCriteria(photoCriteria);
        return photos;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ResponseBody
    public Photo save(@RequestBody Photo photo) {
        Photo photoNew = photoService.save(photo);
        return null;
    }

    @RequestMapping(path = "list", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ResponseBody
    public List<Photo> saveAll(@RequestBody List<Photo> photos) {
        for(Photo photo : photos) {
            Photo photoNew = photoService.save(photo);
        }
        return null;
    }
}
