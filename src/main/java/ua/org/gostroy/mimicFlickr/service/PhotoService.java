package ua.org.gostroy.mimicFlickr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import ua.org.gostroy.mimicFlickr.model.Photo;
import ua.org.gostroy.mimicFlickr.repository.PhotoRepository;
import ua.org.gostroy.mimicFlickr.web.model.criteria.PhotoCriteria;

import javax.servlet.ServletContext;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sergey on 12/21/2015.
 */
@Service
@Transactional
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    ServletContext servletContext;
    @Value("${application.message.appUploadDir:}")
    private String appUploadDir;

    @Transactional(readOnly = true)
    public Photo findById(final Long id) {
        Photo photo = photoRepository.findOne(id);
        return photo;
    }

    @Transactional(readOnly = true)
    public List<Photo> findAll() {
        List<Photo> photos = photoRepository.findAll();
        return photos;
    }

    @Transactional(readOnly = true)
    public List<Photo> findAllByCriteria(PhotoCriteria photoCriteria) {
        List<Photo> photos = photoRepository.findByNameLikeAndDescriptionLike(photoCriteria.getName(), photoCriteria.getDescription());
        return photos;
    }

    @Transactional
    public Photo save(final Photo photo) {
        if (photo.getBase64() != null) {
            String dirPath = servletContext.getRealPath("/") + appUploadDir + System.getProperty("file.separator");
            Path path = Paths.get(dirPath);

            Path fullPath = findFileName(dirPath, photo.getName());
            photo.setName(fullPath.getFileName().toString());

            try {
                Files.createDirectories(path);
                FileOutputStream fos = new FileOutputStream(fullPath.toFile());
                byte[] decoded = Base64.getDecoder().decode(photo.getBase64());
                fos.write(decoded);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        if(photo.getCreateTime() == null){
            photo.setCreateTime(new Date());
        }

        Photo photoNew = photoRepository.save(photo);
        return photoNew;
    }

    public Photo update(final Photo photo) {
        Photo photoNew = photoRepository.save(photo);
        return photoNew;
    }

    public void delete(final Photo photo) {
        photoRepository.delete(photo);
    }


    private Path findFileName(final String dir, final String fileName){

        String[] tokens = fileName.split("\\.(?=[^\\.]+$)");
        String baseName = tokens[0];
        String extension = tokens[1];

        Path ret = Paths.get(dir, String.format("%s.%s", baseName, extension));
        if (!Files.exists(ret))
            return ret;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ret = Paths.get(dir, String.format("%s%d.%s", baseName, i, extension));
            if (!Files.exists(ret))
                return ret;
        }
        throw new IllegalStateException("What the...");
    }
}