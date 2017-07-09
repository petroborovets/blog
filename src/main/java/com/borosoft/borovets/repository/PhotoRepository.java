package com.borosoft.borovets.repository;

import com.borosoft.borovets.domain.Photo;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import java.util.List;

/**
 * Spring Data JPA repository for the Photo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {

    @Query("select photo from Photo photo where photo.createdBy.login = ?#{principal.username}")
    List<Photo> findByCreatedByIsCurrentUser();
    
}
