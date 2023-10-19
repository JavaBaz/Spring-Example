package com.github.javabaz.springexample.util;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageUtil {
    public static byte[] readImageFile(String imagePath) {
        File file = new File(imagePath);
        if(!isFileAnImage(imagePath))
            return null;
        if (file.exists() && file.isFile()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[(int) file.length()];
                int bytesRead = fis.read(buffer);
                if (bytesRead == -1) {
                    return null;
                }
                return buffer;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static void writeImageFile(String destinationPath, byte[] imageBytes) throws IOException {
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
        File outputFile = new File(destinationPath);
        ImageIO.write(image, "jpg", outputFile);
    }

    public static boolean isFileAnImage(String imagePath){

        File f = new File(imagePath);
        String mimetype= new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];
        return type.equals("image");
    }

}
