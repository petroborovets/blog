package com.borosoft.borovets.service;

import com.borosoft.borovets.domain.Tag;
import java.util.List;

/**
 * Service Interface for managing Tag.
 */
public interface TagService {

    /**
     * Save a tag.
     *
     * @param tag the entity to save
     * @return the persisted entity
     */
    Tag save(Tag tag);

    /**
     *  Get all the tags.
     *
     *  @return the list of entities
     */
    List<Tag> findAll();

    /**
     *  Get the "id" tag.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Tag findOne(Long id);

    /**
     *  Delete the "id" tag.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
