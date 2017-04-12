package com.rayootech.project.utils.img;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageProcess {

    /**
     * 对图片进行缩放
     * 
     * @param srcImgFileName
     * @throws IOException
     */
    public void zoomImage(String srcImgFileName) throws IOException {
        // 读入文件
        File _file = new File(srcImgFileName);
        // 构造Image对象
        BufferedImage src = javax.imageio.ImageIO.read(_file);
        int width = src.getWidth();
        int height = src.getHeight();

        // 边长缩小为二分之一
        BufferedImage tag = new BufferedImage(width / 2, height / 2, BufferedImage.TYPE_INT_RGB);
        // 绘制缩小后的图
        tag.getGraphics().drawImage(src, 0, 0, width / 2, height / 2, null);
        FileOutputStream out = new FileOutputStream("d:\\temp\\targetIMG1-4.jpg");
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(tag);
        out.close();

        // 边长扩大为2倍
        tag = new BufferedImage(width * 2, height * 2, BufferedImage.TYPE_INT_RGB);
        tag.getGraphics().drawImage(src, 0, 0, width * 2, height * 2, null);
        out = new FileOutputStream("d:\\temp\\targetIMGx2.jpg");
        encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(tag);
        out.close();

    }

    /**
     * 将图片分成九块
     * 
     * @param srcImageFile
     * @throws IOException
     */
    public void cut(String srcImageFile) throws IOException {
        Image img;
        ImageFilter cropFilter;
        String dir = null;
        // 读取源图像
        BufferedImage src = ImageIO.read(new File(srcImageFile));
        int destWidth = src.getWidth() / 3;
        int destHeight = src.getHeight() / 3;
        // 循环
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 四个参数分别为图像起点坐标和宽高
                cropFilter = new CropImageFilter(j * destWidth, i * destHeight, destWidth, destHeight);
                img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(src.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, null); // 绘制小图
                g.dispose();
                // 输出为文件
                dir = "d:\\temp\\cut_image_" + i + "_" + j + ".jpg";
                File f = new File(dir);
                ImageIO.write(tag, "JPEG", f);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String imgFileName = "D:\\test.jpg";
        ImageProcess iZoom = new ImageProcess();

        iZoom.zoomImage(imgFileName);
        iZoom.cut(imgFileName);
    }
}

