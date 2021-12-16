package com.msb.dongbao.portal.controller.code.util;

import com.octo.captcha.CaptchaFactory;
import com.octo.captcha.component.image.backgroundgenerator.UniColorBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.RandomTextPaster;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.word.FileDictionary;
import com.octo.captcha.component.word.wordgenerator.ComposeDictionaryWordGenerator;
import com.octo.captcha.engine.GenericCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;
import com.octo.captcha.service.image.ImageCaptchaService;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;

import java.awt.*;

/**
 * @Author: lsk
 * @Date: 2021/12/14 - 12 - 14 - 16:26
 * @Description: com.msb.dongbao.common.base.code.util
 * @Version: 1.0
 */
public class JCaptchaUtil {
    private static final ImageCaptchaService service = imageCaptchaService();
    public static ImageCaptchaService getService(){
        return service;
    }
    private static ImageCaptchaService imageCaptchaService(){
        //背景
        UniColorBackgroundGenerator backgroundGenerator = new UniColorBackgroundGenerator(100,50);
        //字  颜色
        RandomRangeColorGenerator textColor = new RandomRangeColorGenerator(new int[]{0,255},new int[]{0,255},new int[]{0,255});
        //设置字体个数
        RandomTextPaster randomTextPaster = new RandomTextPaster(4,5,textColor);
        //设置字体 TimesRoman courrier
        RandomFontGenerator randomFontGenerator = new RandomFontGenerator(20,30,new Font[]{new Font("TimesRoman",Font.PLAIN,20)});
        //组装图像
        ComposedWordToImage composedWordToImage = new ComposedWordToImage(randomFontGenerator,backgroundGenerator,randomTextPaster);
        ComposeDictionaryWordGenerator cdwg = new ComposeDictionaryWordGenerator(new FileDictionary("toddlist"));
        GimpyFactory gf = new GimpyFactory(cdwg,composedWordToImage);
        GenericCaptchaEngine gce = new GenericCaptchaEngine(new CaptchaFactory[]{gf});
        return new GenericManageableCaptchaService(gce,20,2000);
    }
}
