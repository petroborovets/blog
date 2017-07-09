package com.borosoft.borovets.service.impl;

import com.borosoft.borovets.service.PhotoService;
import com.borosoft.borovets.domain.Photo;
import com.borosoft.borovets.repository.PhotoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Photo.
 */
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService{

    private final Logger log = LoggerFactory.getLogger(PhotoServiceImpl.class);

    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    /**
     * Save a photo.
     *
     * @param photo the entity to save
     * @return the persisted entity
     */
    @Override
    public Photo save(Photo photo) {
        log.debug("Request to save Photo : {}", photo);
        return photoRepository.save(photo);
    }

    /**
     *  Get all the photos.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Photo> findAll() {
        log.debug("Request to get all Photos");
        return photoRepository.findAll();
    }

    /**
     *  Get one photo by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Photo findOne(Long id) {
        log.debug("Request to get Photo : {}", id);
        return photoRepository.findOne(id);
    }

    /**
     *  Delete the  photo by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Photo : {}", id);
        photoRepository.delete(id);
    }
}
