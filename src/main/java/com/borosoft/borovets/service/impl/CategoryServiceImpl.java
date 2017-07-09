package com.borosoft.borovets.service.impl;

import com.borosoft.borovets.service.CategoryService;
import com.borosoft.borovets.domain.Category;
import com.borosoft.borovets.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Category.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Save a category.
     *
     * @param category the entity to save
     * @return the persisted entity
     */
    @Override
    public Category save(Category category) {
        log.debug("Request to save Category : {}", category);
        return categoryRepository.save(category);
    }

    /**
     *  Get all the categories.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        log.debug("Request to get all Categories");
        return categoryRepository.findAll();
    }

    /**
     *  Get one category by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Category findOne(Long id) {
        log.debug("Request to get Category : {}", id);
        return categoryRepository.findOne(id);
    }

    /**
     *  Delete the  category by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        categoryRepository.delete(id);
    }
}
