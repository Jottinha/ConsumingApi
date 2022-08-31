package com.alura.imersaojava.stickers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Stickers {
    public void createStickers(InputStream imageUrl, String fileName, String apiName, String rating) throws IOException {
        //1° Read Image
        BufferedImage imageLoad = ImageIO.read(imageUrl);
        Image originalImage = imageLoad.getScaledInstance(750, 1200, imageLoad.SCALE_DEFAULT);

        //2° Create new Image higher with transparent block
        int width = 750, height = 1400;
        var newImage = new BufferedImage(width, height, Transparency.TRANSLUCENT);

        //3°Copy my original image(Banner) to my newImage
        Graphics2D graphicsPaint = (Graphics2D) newImage.getGraphics();
        graphicsPaint.drawImage(originalImage, 0,0,null);

        // Verify if rating of the movie is greater than 9
        boolean isGreaterThanNine = (Double.valueOf(rating) >= 9) ? true:false;

        //4° Write Font
        var writeFont = new Font("Comic Sans MS", Font.BOLD, 64);
        var color = (isGreaterThanNine)? Color.GREEN:Color.RED;
        graphicsPaint.setColor(color);
        graphicsPaint.setFont(writeFont);

        //5° Draw topzera in my image
        int newHeight = height - 100;
        int newWidth = (width / 2) - ((graphicsPaint.getFontMetrics().stringWidth("NOTA" + rating)) / 2);
        graphicsPaint.drawString("NOTA: " + rating, newWidth, newHeight);

        //Prepared to Draw new Image approved or fail in my Image output
        Image resizeImage = (isGreaterThanNine) ?
                approvalSticker("Aprovado.png") : approvalSticker("Reprovado.png");

        //6° Create folder if not exist
        Path path = Paths.get("Stickers-" + apiName);
        if (!Files.exists(path)){
            Files.createDirectory(path);
        }

        int newWidthApproval = (width / 2) + graphicsPaint.getFontMetrics().stringWidth("NOTA: " + rating) / 2;
        graphicsPaint.drawImage(resizeImage, newWidthApproval, 1100, null);

        //7° Print image
        ImageIO.write(newImage, "png", new File(fileName));
    }

    public Image approvalSticker(String approval) throws IOException {

        BufferedImage image = ImageIO.read(new File("Stickers-Refactor(Code)/ImagesFile/" + approval));
        Image resizeImage = image.getScaledInstance((750/2)/2,100, image.SCALE_DEFAULT);
        return resizeImage;
    }
}
