package com.msb.dongbao.common.base.code;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.Data;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

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
        //使用数字作为验证码
//        graphics.setColor(new Color(229, 227, 222));
//        graphics.fillRect(0,0,weight,height);
//        graphics.setFont(new Font("宋体",Font.PLAIN, 30));
//        Random random = new Random();
//         this.code = "";
//        for(int i = 0; i < 6; i++) {
//          String s = String.valueOf(random.nextInt(10));
//          this.code += s;
//          graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//          graphics.drawString(s,weight/6*i+30,50);
//        }

//        //使用加减乘除来验证
//        Random random = new Random();
//        int n1= random.nextInt(20);
//        int n2= random.nextInt(20);
//        graphics.setColor(new Color(229, 227, 222));
//        graphics.setFont(new Font("宋体",Font.PLAIN, 30));
//        graphics.fillRect(0,0,weight,height);
//        graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//        graphics.drawString(n1 + " ",(weight/6)*0 + 4, 60);
//        int flage = (int)random.nextInt(4);
//        String calculate = null;
//        switch (flage){
//            case 0: calculate = "+";
//            case 1: calculate = "-";
//            case 2: calculate = "*";
//        }
//        graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//        graphics.drawString(calculate,(weight/6)*1 + 4, 60);
//        graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//        graphics.drawString(n2 + " ",(weight/6)*2 + 4, 60);
//        graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//        graphics.drawString( "=",(weight/6)*3 + 4, 60);
//        graphics.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//        graphics.drawString( "?",(weight/6)*4 + 4, 60);
//        int ans = flage == 0 ? (n1 + n2): (flage == 1 ? (n1 - n2): (n1 * n2));
//        this.code = String.valueOf(ans);
        //使用框架

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
