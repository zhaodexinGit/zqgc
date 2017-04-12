package com.rayootech.project.utils.img;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.gif4j.GifDecoder;
import com.gif4j.GifEncoder;
import com.gif4j.GifImage;
import com.gif4j.GifTransformer;
import com.jhlabs.image.*;

/**
 * 纯Java实现的图像处理
 * @author Winter Lau
 * @date 2010-4-26 上午09:45:56
 */
public class JavaImgHandler implements ImgHandler {
	
	public static void main(String[] args) {
		JavaImgHandler handler = new JavaImgHandler();
		File img = new File("D:\\test.png");
		handler.crop(img, new File("D:\\test_crop.jpg"), 0, 0, 500, 500, 100, 100);
		handler.rotate(img, new File("D:\\test_rotate.jpg"), 90);
		handler.scale(img, new File("D:\\test_scale_100.jpg"), 100);
		handler.scale(img, new File("D:\\test_scale_200_120.jpg"), 331, 320);
	}
		
	public int[] shrink(File src, File dest, int size) throws ImgException {
		try{
			BufferedImage orig_portrait = (BufferedImage)ImageIO.read(src);
			int w = orig_portrait.getWidth();
			int h = orig_portrait.getHeight();
			if(w <= size && h <= size){
				FileUtils.copyFile(src, dest);
				return new int[]{w,h};
			}
			else{
				double ratio = (w > h) ? (double)size/w : (double)size/h ;
				int w2 = (int)(w * ratio);
				int h2 = (int)(h * ratio);
				scale(src, dest, w2, h2);
				return new int[]{w2,h2};
			}
		}catch(IOException e){
			throw new ImgException("Exception occur when shrink image.", e);
		}
	}

	/** (non-Javadoc)
	 * @see my.img.ImgHandler#crop(java.io.File, java.io.File, int, int, int, int, int, int)
	 */
	public void crop(File src, File dest, 
			 int left, int top, int w2, int h2, int w, int h) throws ImgException 
	{
		if(!dest.getParentFile().exists())
			dest.getParentFile().mkdirs();
		try{
			String ext = FilenameUtils.getExtension(dest.getName()).toLowerCase();
			BufferedImage bi = (BufferedImage)ImageIO.read(src);
			
			MyScaleFilter scale = new MyScaleFilter(w2,h2);
			if(w2!=bi.getWidth()&&h2!=bi.getHeight()){
				BufferedImage bi_scale1 = new BufferedImage(w2,h2, (bi.getType()!=0)?bi.getType():BufferedImage.TYPE_INT_RGB);
				scale.filter(bi, bi_scale1);
				bi=bi_scale1;
			}
			if(top==0&&left==0){
				//MyScaleFilter scale = new MyScaleFilter(w,h);
				BufferedImage bi_scale = new BufferedImage(w,h, (bi.getType()!=0)?bi.getType():BufferedImage.TYPE_INT_RGB);
				scale.filter(bi, bi_scale);
				ImageIO.write(bi_scale, ext.equals("png")?"png":"jpeg", dest);
			}
			else{
				int height = Math.min(h, bi.getHeight());
				int width = Math.min(w, bi.getWidth());
				if(height <= 0) height = bi.getHeight();
				if(width <= 0) width = bi.getWidth();
				
				BufferedImage bi_crop = new BufferedImage(width,height, (bi.getType()!=0)?bi.getType():BufferedImage.TYPE_INT_RGB);				
				new CropFilter(left,top,width,height).filter(bi, bi_crop);
				BufferedImage bi_scale = new BufferedImage(w,h, (bi.getType()!=0)?bi.getType():BufferedImage.TYPE_INT_RGB);				
				new MyScaleFilter(w, h).filter(bi_crop, bi_scale);
				ImageIO.write(bi_scale, ext.equals("png")?"png":"jpeg", dest);
			}
		}catch(IOException e){
			throw new ImgException("Exception occur when crop image.", e);
		}
	}
	/** (non-Javadoc)
	 * @see my.img.ImgHandler#rotate(java.io.File, java.io.File, double)
	 */
	public void rotate(File src, File dest, double degrees) throws ImgException {
		if(!dest.getParentFile().exists())
			dest.getParentFile().mkdirs();

		try{
			String ext = FilenameUtils.getExtension(dest.getName()).toLowerCase();
			if ("gif".equalsIgnoreCase(ext)) {
				GifImage gifImage = GifDecoder.decode(src);
				GifImage newGif = GifTransformer.rotate(gifImage, degrees, false);
				GifEncoder.encode(newGif, dest);
			} else {
				BufferedImage bi = (BufferedImage)ImageIO.read(src);
				RotateFilter Rotate = new RotateFilter((float)Math.toRadians(degrees));
				BufferedImage bi_rotate = new BufferedImage(bi.getHeight(),bi.getWidth(), (bi.getType()!=0)?bi.getType():BufferedImage.TYPE_INT_RGB);
				Rotate.filter(bi, bi_rotate);
				ImageIO.write(bi_rotate, ext.equals("png")?"png":"jpeg", dest);
			}
		}catch(IOException e){
			throw new ImgException("Exception occur when scaling image.", e);
		}
	}

	/** (non-Javadoc)
	 * @see my.img.ImgHandler#scale(java.io.File, java.io.File, int, int, boolean)
	 */
	public void scale(File src, File dest, int w, int h) throws ImgException {
		if(!dest.getParentFile().exists())
			dest.getParentFile().mkdirs();
		try{
			if(w <= 0 && h <= 0){
				FileUtils.copyFile(src, dest);
				return ;
			}
			String ext = FilenameUtils.getExtension(dest.getName()).toLowerCase();
			if ("gif".equalsIgnoreCase(ext)) {
				GifImage gifImage = GifDecoder.decode(src);
				GifImage newGif = GifTransformer.resize(gifImage, w, h, false);
				GifEncoder.encode(newGif, dest);
			}
			else{
				BufferedImage bi = (BufferedImage)ImageIO.read(src);
				MyScaleFilter scale = new MyScaleFilter(w,h);
				BufferedImage bi_scale = new BufferedImage(w,h, (bi.getType()!=0)?bi.getType():BufferedImage.TYPE_INT_RGB);
				scale.filter(bi, bi_scale);
				ImageIO.write(bi_scale, ext.equals("png")?"png":"jpeg", dest);
			}
		}catch(IOException e){
			throw new ImgException("Exception occur when scaling image.", e);
		}
	}

	/** (non-Javadoc)
	 * @see my.img.ImgHandler#scale(java.io.File, java.io.File, int, boolean)
	 */
	public void scale(File src, File dest, int size) throws ImgException {
		if(!dest.getParentFile().exists())
			dest.getParentFile().mkdirs();

		try{
			String ext = FilenameUtils.getExtension(dest.getName()).toLowerCase();
			if ("gif".equalsIgnoreCase(ext)) {
				GifImage gifImage = GifDecoder.decode(src);
				GifImage newGif = GifTransformer.resize(gifImage, size, size, false);
				GifEncoder.encode(newGif, dest);
			} else {
				BufferedImage bi = (BufferedImage) ImageIO.read(src);
				int w = bi.getWidth();
				int h = bi.getHeight();
				int max_size = Math.min(w, h);

				//剪裁
				BufferedImage bi_crop = newImg(bi, max_size,max_size);
				new CropFilter((w - max_size)/2,(h - max_size)/2,max_size,max_size).filter(bi,bi_crop);
				
				//缩小
				MyScaleFilter scale = new MyScaleFilter(size,size);
				BufferedImage bi_scale = newImg(bi_crop, size, size);
				scale.filter(bi_crop, bi_scale);
				
				ImageIO.write(bi_scale, ext.equals("png")?"png":"jpeg", dest);
			}
		}catch(IOException e){
			throw new ImgException("Exception occur when scaling image.", e);
		}
	}
	
	private BufferedImage newImg(BufferedImage src, int width, int height) {
		ColorModel dstCM = src.getColorModel();
		return new BufferedImage(dstCM, dstCM.createCompatibleWritableRaster( width, height ), dstCM.isAlphaPremultiplied(), null);
	}
	/*public void crop(File src, File dest, 
	 int left, int top, int width,int height, 
	 int w, int h) throws ImgException 
	{
		if(!dest.getParentFile().exists())
		dest.getParentFile().mkdirs();
		try{
		String ext = FilenameUtils.getExtension(dest.getName()).toLowerCase();
		BufferedImage bi = (BufferedImage)ImageIO.read(src);
		height = Math.min(height, bi.getHeight());
		width = Math.min(width, bi.getWidth());
		if(height <= 0) height = bi.getHeight();
		if(width <= 0) width = bi.getWidth();
		top = Math.min(Math.max(0, top), bi.getHeight()-height);
		left = Math.min(Math.max(0, left), bi.getWidth()-width);
		
		if(top==0&&left==0&&width==bi.getWidth()&&height==bi.getHeight()){
		MyScaleFilter scale = new MyScaleFilter(w,h);
		BufferedImage bi_scale = new BufferedImage(w,h, (bi.getType()!=0)?bi.getType():BufferedImage.TYPE_INT_RGB);
		scale.filter(bi, bi_scale);
		ImageIO.write(bi_scale, ext.equals("png")?"png":"jpeg", dest);
		}
		else{
		BufferedImage bi_crop = new BufferedImage(width,height, (bi.getType()!=0)?bi.getType():BufferedImage.TYPE_INT_RGB);				
		new CropFilter(left,top,width,height).filter(bi, bi_crop);
		BufferedImage bi_scale = new BufferedImage(w,h, (bi.getType()!=0)?bi.getType():BufferedImage.TYPE_INT_RGB);				
		new MyScaleFilter(w, h).filter(bi_crop, bi_scale);
		ImageIO.write(bi_scale, ext.equals("png")?"png":"jpeg", dest);
		}
		}catch(IOException e){
		throw new ImgException("Exception occur when crop image.", e);
		}
	}
		*/
}
