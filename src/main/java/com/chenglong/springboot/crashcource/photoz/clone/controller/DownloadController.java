package com.chenglong.springboot.crashcource.photoz.clone.controller;

import com.chenglong.springboot.crashcource.photoz.clone.model.Photoz;
import com.chenglong.springboot.crashcource.photoz.clone.service.PhotozService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class DownloadController {

    private final PhotozService photozService;

    public DownloadController(PhotozService photozService) {
        this.photozService = photozService;
    }

    // response entity has headers and metadata
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {

        // dependency injection
        Photoz photo = photozService.get(id);
        if (photo == null) throw new ResponseStatusException(NOT_FOUND);

        byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        // set contentType
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        // attachment for download, or inline for display
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();
        // set should it display
        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
