import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws AWTException, IOException, InterruptedException, DbxException {

        String ACCESS_TOKEN = "-SAvcNIHbxAAAAAAAAAAOVuLT1Rrfq45nrgi_3XeFUf1c8yLZ5dTWfMOW9ncZjto";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        MyThread thread = new MyThread();
        thread.run(client);






        //System.out.println("Сделан скриншот размером (" + image.getWidth() + " х " + image.getHeight() + ")");

    }
}

