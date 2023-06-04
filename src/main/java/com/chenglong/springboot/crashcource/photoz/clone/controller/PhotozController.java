package com.chenglong.springboot.crashcource.photoz.clone.controller;

import com.chenglong.springboot.crashcource.photoz.clone.model.Photoz;
import com.chenglong.springboot.crashcource.photoz.clone.service.PhotozService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotozController {

    private final PhotozService photozService;

    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Iterable<Photoz> get() {
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photoz get(@PathVariable Integer id) {
        Photoz photo = photozService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id) {
        photozService.remove(id);
    }

    @PostMapping("/photoz")
    public Photoz create(@RequestPart("data") MultipartFile file) throws IOException {
        Photoz photo = photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}
