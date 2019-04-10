package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import dao.ImageDao;
import models.Image;
import play.Logger;
import play.api.mvc.MultipartFormData;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ImageStore;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public class ImagesController extends Controller {

    private final static Logger.ALogger LOGGER = Logger.of(ImagesController.class);

    private ImageStore imageStore;
    private ImageDao imageDao;

    @Inject
    public ImagesController(ImageStore imageStore, ImageDao imageDao) {

        this.imageStore = imageStore;
        this.imageDao = imageDao;

    }

//    public Result uploadImage() {
//
//        final Http.MultipartFormData<File> body = request().body().asMultipartFormData();
//        if (null == body) {
//            return badRequest("Not multipart request");
//        }
//
//        final Http.MultipartFormData.FilePart<File> image = body.getFile("file");
//        if (null == image) {
//            return badRequest("No file found");
//        }
//
//        if (!image.getContentType().equals("image/png")) {
//            return badRequest("only PNG format supported");
//        }
//
//        final Path source = image.getFile().toPath();
//
//        String imageId = imageStore.save(source);
//
//        final String downloadUrl = routes.ImagesController.downloadImage(imageId).absoluteURL(request());
//
//        final ObjectNode result = Json.newObject();
//        result.put("image_url", downloadUrl);
//        //result.put("imageId", imageId);
//
//        return ok(result);
//    }

    public Result uploadImage(){

        ArrayList<String> Images = new ArrayList();

        List<Http.MultipartFormData.FilePart<Object>> myFiles = request().body().asMultipartFormData().getFiles();

        Iterator itr = myFiles.iterator();
        while(itr.hasNext()){

            Http.MultipartFormData.FilePart<File> item  = (Http.MultipartFormData.FilePart) itr.next();
            final Path source = item.getFile().toPath();
            String imageId = imageStore.save(source);
            final String downloadUrl = routes.ImagesController.downloadImage(imageId).absoluteURL(request());
            Images.add(downloadUrl);

        }

        LOGGER.debug(Images.toString());

        //final JsonNode result = Json.toJson(Images);

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode array = mapper.valueToTree(Images);
        final ObjectNode Result = Json.newObject();
        Result.putArray("image_url").addAll(array);

        return ok(Result);
    }

    public Result downloadImage(String id) {

        final File file = imageStore.getImageById(id);
        if (null == file) {
            return notFound("Image not found");
        }

        return ok(file);
    }

    public Result deleteImage(String id) {

        final boolean deleted = imageStore.deleteImageById(id);
        if (!deleted) {
            return notFound("Image not found");
        }

        return ok();
    }

    @Transactional
    public Result deleteImageByUrl(){

        final JsonNode json = request().body().asJson();
        final Image image = Json.fromJson(json,Image.class);
        final String imageUrl = json.get("imageUrl").asText();

        imageDao.delete(imageUrl);

        return ok();
    }


}
