package com.boot.thinking.time;

import com.boot.thinking.util.VerifyCodeUtil;
import com.boot.thinking.util.VerifyImageUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Random;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestVerify {

    private static void testCode() throws IOException {
        byte[] newImages = VerifyCodeUtil.getVerifyImg();
        FileOutputStream fout = new FileOutputStream("C:/Users/Administrator/Desktop/verigy.png");
        fout.write(newImages);
        fout.close();

    }
    @Test
    public void testImg() throws Exception {
        Map<String, byte[]> pictureMap;
        File templateFile;  //模板图片
        File targetFile;  //
        Random random = new Random();
        int templateNo = random.nextInt(4) + 1;
        int targetNo = random.nextInt(20) + 1;

        InputStream stream = getClass().getClassLoader().getResourceAsStream("static/templates/" + 1 + ".png");
        templateFile = new File(templateNo + ".png");
        FileUtils.copyInputStreamToFile(stream, templateFile);

        stream = getClass().getClassLoader().getResourceAsStream("static/targets/" + 1 + ".jpg");
        targetFile = new File(targetNo + ".jpg");
        FileUtils.copyInputStreamToFile(stream, targetFile);
        pictureMap = VerifyImageUtil.pictureTemplatesCut(templateFile, targetFile, "png", "jpg");
        byte[] oriCopyImages = pictureMap.get("oriCopyImage");
        byte[] newImages = pictureMap.get("newImage");

        FileOutputStream fout = new FileOutputStream("D:\\ddd\\oriCopyImage4.png");
        //将字节写入文件
        try {
            fout.write(oriCopyImages);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fout.close();

        FileOutputStream newImageFout = new FileOutputStream("D:\\ddd\\newImage4.png");
        //将字节写入文件
        newImageFout.write(newImages);
        newImageFout.close();
    }
}
