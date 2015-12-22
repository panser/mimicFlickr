package ua.org.gostroy.mimicFlickr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.mimicFlickr.model.Photo;

import java.util.List;

/**
 * Created by Sergey on 12/21/2015.
 */
@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findByNameLikeAndDescriptionLike(String name, String description);
}
