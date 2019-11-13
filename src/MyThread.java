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

    private DbxClientV2 client;
    private long before;
    private long after;

    public MyThread(DbxClientV2 client){
        this.client = client;
    }

    public void run(){
        for(;;)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date now = new Date();

            try {
                BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ByteArrayOutputStream imageByte = new ByteArrayOutputStream();
                ImageIO.write(image, "png", imageByte);
                InputStream in = new ByteArrayInputStream(imageByte.toByteArray());
                before = System.currentTimeMillis();
                client.files().uploadBuilder("/" + dateFormat.format(now) + ".png").uploadAndFinish(in);
                after = System.currentTimeMillis();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(after - before);
            try{
                sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
