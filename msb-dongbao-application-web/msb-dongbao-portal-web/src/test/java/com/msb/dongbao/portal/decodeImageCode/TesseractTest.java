package com.msb.dongbao.portal.decodeImageCode;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * @Author: lsk
 * @Date: 2021/12/13 - 12 - 13 - 20:10
 * @Description: com.msb.dongbao.portal.decodeImageCode
 * @Version: 1.0
 */
public class TesseractTest {

    public static void main(String[] args) throws TesseractException {
        ITesseract iTesseract = new Tesseract();
        //语言包，加载进来
        iTesseract.setDatapath("D:\\googleDownload\\dongbaoLanguagePackage");
        iTesseract.setLanguage("eng");
        //绝对路径
        File file = new File("C:\\Users\\lsk\\IdeaProjects\\msb-dongbao-mall-parent\\msb-dongbao-application-web\\msb-dongbao-portal-web\\src\\test\\java\\com\\msb\\dongbao\\portal\\decodeImageCode\\imageCode.jpg");
        String s = iTesseract.doOCR(file);
        System.out.println("识别之后的数字是：" + s);
    }
}



