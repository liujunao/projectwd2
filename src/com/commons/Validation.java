package com.commons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by lenovo on 2017/7/7.
 */
public class Validation {

    public static final char[] chars = {'2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    public static Random random = new Random();

    public String getRandomString(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1;i < 4;i++){
            stringBuffer.append(chars[random.nextInt(chars.length)]);
        }
        return stringBuffer.toString();
    }
    public Color getRandomColor(){
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    public Color getReverseColor(Color color){
        return new Color(255 - color.getRed(),255 - color.getGreen(),255 - color.getBlue());
    }

    String text = getRandomString();

    public String getText() {
        return text;
    }

    public BufferedImage getImage(int width,int height){
        Color color = getRandomColor();
        Color reverse = getReverseColor(color);

        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        graphics2D.setColor(color);
        graphics2D.fillRect(0,0,width,height);
        graphics2D.setColor(reverse);
        graphics2D.drawString(text,10,22);
        for (int i = 0,n = random.nextInt(80);i < n;i++){
            graphics2D.drawRect(random.nextInt(width),random.nextInt(height),1,1);
        }
        return bufferedImage;
    }

    public static void output(BufferedImage bufferedImage, OutputStream outputStream) throws IOException {
        ImageIO.write(bufferedImage,"JPEG",outputStream);
    }

}
