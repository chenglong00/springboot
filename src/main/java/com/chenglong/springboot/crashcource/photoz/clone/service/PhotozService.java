package com.chenglong.springboot.crashcource.photoz.clone.service;

import com.chenglong.springboot.crashcource.photoz.clone.model.Photoz;
import com.chenglong.springboot.crashcource.photoz.clone.repository.PhotozRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotozService {

    private final PhotozRepository photozRepository;

    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photoz> get() {
        return photozRepository.findAll();
    }

    public Photoz get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photoz save(String fileName, String contentType, byte[] data) {
        Photoz photo = new Photoz();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;

    }
}