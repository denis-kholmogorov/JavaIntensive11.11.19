import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws AWTException, IOException, InterruptedException {

        String keyToken = "-SAvcNIHbxAAAAAAAAAAOVuLT1Rrfq45nrgi_3XeFUf1c8yLZ5dTWfMOW9ncZjto";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now = new Date();
        System.out.println("Сегодняшняя дата " + dateFormat.format(now));

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        System.out.println("Сделан скриншот размером (" + image.getWidth() + " х " + image.getHeight() + ")");
        ImageIO.write(image, "png", new File("/home/denis/" + dateFormat.format(now) + ".png"));
    }
}

