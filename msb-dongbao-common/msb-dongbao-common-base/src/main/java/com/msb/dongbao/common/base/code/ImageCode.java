package com.msb.dongbao.common.base.code;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 18:47
 * @Description: com.msb.dongbao.common.base.code
 * @Version: 1.0
 */
@Data
public class ImageCode {
    private String code;
    private ByteArrayInputStream image;
    private int weight = 400;
    private int height = 100;
    public static ImageCode getInstance()throws IOException{
        return new ImageCode();
    }
    private ImageCode() throws IOException {
        //图形缓冲区
        BufferedImage image = new BufferedImage(weight, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.createGraphics();
        graphics.setColor(new Color(229, 227, 222));
        graphics.fillRect(0,0,weight,height);
        graphics.setFont(new Font("宋体",Font.PLAIN, 30));
        Random random = new Random();
         this.code = "";
        for(int i = 0; i < 6; i++) {
          String s = String.valueOf(random.nextInt(10));
          this.code += s;
          graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
          graphics.drawString(s,weight/6*i+30,50);
        }
        //收笔
        graphics.dispose();
        ByteArrayInputStream inputStream = null;
        ByteOutputStream outputStream = new ByteOutputStream();

        //赋值给byteArrayInputStream
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        ImageIO.write(image,"jpeg",imageOutputStream);
        inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        this.image = inputStream;
    }
}
