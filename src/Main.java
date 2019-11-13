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

        System.out.println("Кофе-машина");
        System.out.print("Введите сумму - ");
        Scanner scanner = new Scanner(System.in);
        int moneyAmount = scanner.nextInt();

        int[] drinkPrices = {150, 80, 20};
        String[] drinkNames = {"капучино", "эспрессо", "воду"};

        boolean  canBuyAnything = false;
        for(int i = 0; i < 3; i = i + 1)
        {
            if(moneyAmount >= drinkPrices[i]) {
                System.out.println("Вы можете купить " + drinkNames[i]);
                canBuyAnything = true;
            }
        }
        if(!canBuyAnything) {
            System.out.println("Недостаточно средств :( Учите Java и зарабатывайте много :)");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now = new Date();
        System.out.println("Сегодняшняя дата " + dateFormat.format(now));

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        System.out.println("Сделан скриншот размером (" + image.getWidth() + " х " + image.getHeight() + ")");
        ImageIO.write(image, "png", new File("/home/denis/" + dateFormat.format(now) + ".png"));
    }
}

