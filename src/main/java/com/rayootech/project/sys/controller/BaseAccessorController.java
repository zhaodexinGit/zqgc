package com.rayootech.project.sys.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rayootech.project.sys.entity.BaseAccessor;
import com.rayootech.project.sys.entity.NlbCompanyNews;
import com.rayootech.project.sys.service.BaseAccessorService;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.PropertyUtil;
import com.rayootech.project.utils.Sequence;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;

/**
 * 
 * <B>功能简述</B><br>
 * 诺兰帮附件管理
 * 
 * @date 
 * @author caolei
 * @since [project/v1.0]
 */
@Controller
@RequestMapping("front_sys/accessor")
public class BaseAccessorController {

	@Autowired
	private BaseAccessorService baseAccessorService;
	private static final Logger log = LoggerFactory.getLogger(BaseAccessorController.class);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 公司附件列表页
	 * 
	 * @param request
	 * @param pageData
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "accessorList")
	public String accessorList(HttpServletRequest request, Page<BaseAccessor> pageData, ModelMap modelMap) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		modelMap.put("pageData", baseAccessorService.accessorList(pageData, params));
		return "front_sys/accessor/accessor";
	}
	/**
	 * 列表(json数据)
	 * 
	 * @param request
	 * @param pageData
	 * @return
	 */
	@RequestMapping(value = "getAccessorList")
	@ResponseBody
	public String getAccessorList(HttpServletRequest request, PageJson<NlbCompanyNews> pageData) {
//		Map<String, Object> params = Utils.reqParamToGenericMap(request);
//		return nlbCompanyProfileService.nlbmmList(pageData, params);
		return null;
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到添加界面
	 * 
	 * @author caolei
	 * @return
	 */
	@RequestMapping("toAddAccessor")
	public String toAddAccessor() {
		return "front_sys/accessor/accessor-add";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 诺兰帮动态上传方法
	 * 
	 * @author 
	 * @return
	 */
	@RequestMapping(value = "uploadAccessor" ,method = RequestMethod.POST)
	public String uploadAccessor(MultipartHttpServletRequest multipartRequest,  
            HttpServletResponse response) throws IOException {
		return "front_sys/accessor/accessor-update";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到诺兰帮附近详情界面
	 * 
	 * @author yongweif
	 * @return
	 */
	@RequestMapping("toDetail")
	public String toDetail(HttpServletRequest request,String id, ModelMap modelMap) {
		BaseAccessor accessor = baseAccessorService.getById(id);
		modelMap.put("accessor",accessor);
		return "front_sys/accessor/accessor-detail";
	}
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到诺兰帮动态修改界面
	 * 
	 * @author caolei
	 * @return
	 */
	@RequestMapping("toUpdateAccessor")
	public String toUpdateAccessor(HttpServletRequest request,String id, ModelMap modelMap) {
		BaseAccessor accessor = baseAccessorService.getById(id);
		modelMap.put("accessor",accessor);
//		modelMap.put("user", JSON.toJSONString(nlbCompanyProfileService.(userId)));
		return "front_sys/accessor/accessor-update";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveAccessor")
	@ResponseBody
	public String saveAccessor(BaseAccessor accessor) {
		return baseAccessorService.saveAccessor(accessor);
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "updateAccessor")
	@ResponseBody
	public String updateAccessor(BaseAccessor accessor) {
		return baseAccessorService.updateAccessor(accessor);
	}
	

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteAccessor")
	@ResponseBody
	public String deleteAccessor(String id, HttpServletRequest request) {
		//上传文件存放目录
		String uploadDir = PropertyUtil.getProperty("upload.path");
		//系统部署路径
		String path = request.getSession().getServletContext().getRealPath("/")+uploadDir;
		return baseAccessorService.deleteAccessor(id, path);
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除前台文件
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getDeleteAccessor")
	@ResponseBody
	public String getDeleteAccessor(String id, HttpServletRequest request) {
		//上传文件存放目录
		String uploadDir = PropertyUtil.getProperty("upload.path");
		//系统部署路径
		String path = request.getSession().getServletContext().getRealPath("/")+uploadDir;
		return baseAccessorService.deleteAccessor(id, path);
	}
	
	
	
	/**
	 * 文件上传
	 * @param file jsp页面上传的文件（name=uploadFile）
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "upload")  
    public void upload(@RequestParam(value = "uploadFile", required = false) MultipartFile file, 
    		HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{  
  
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		try {
			//文件地址
			String uploadDir = PropertyUtil.getProperty("upload.path");
			String path = request.getSession().getServletContext().getRealPath("/")+uploadDir;
			//文件名称
			String sourceFile = file.getOriginalFilename();
			//文件类型
			String fileType = sourceFile.substring(sourceFile.lastIndexOf(".") + 1);
			// 目标文件名称
			String fileName = Sequence.getSequenceNumber();
			//文件
			File targetFile = new File(path, fileName+"."+fileType);
			
			//如果文件夹不存在则创建
			String temp = "";
	        for(int i=0 ; i<path.split("/").length ; i++){
	        	if(i>0)
	        		temp += "/";
	        	temp += path.split("/")[i];
	            File dir =new File(temp);
	            if  (!dir.exists()  && !dir.isDirectory())
	            	dir.mkdir();
	        }
  
	        //保存 文件
            file.transferTo(targetFile);
            
            //记录上传文件信息
            BaseAccessor accessor = new BaseAccessor();
            String baid = Sequence.getSequence();
			String dpid = request.getParameter("dpid");
			String businessCode = request.getParameter("businesscode");
			accessor.setBAID(baid);
			accessor.setBUSINESSCODE(businessCode);
			accessor.setBUSINESSNAME(fileName);
			accessor.setDPID(dpid);
			accessor.setFILENAME(fileName+"."+fileType);
			accessor.setFILEPATH(path);
			accessor.setFILETYPE(fileType);
			baseAccessorService.saveAccessor(accessor);

			//返回页面信息
			writer.write("{\"status\":\"true\",\"baid\":\""+baid+"\",\"imageSrc\":\"" + uploadDir+"/"+fileName+"."+fileType+"\"}");
			writer.flush();
			writer.close();
        } catch (Exception e) {  
        	log.error("upload BaseAccessorController is error : ", e);
			writer.write("{status:false}");
			writer.flush();
			writer.close();
        }  
    }  
	
	
	/**
	 * 文件上传
	 * @param file jsp页面上传的文件（name=uploadFile）
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "getUpload")  
    public void getUpload(@RequestParam(value = "uploadFile", required = false) MultipartFile file, 
    		HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{  
  
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		try {
			//文件地址
			String uploadDir = PropertyUtil.getProperty("upload.path");
			String path = request.getSession().getServletContext().getRealPath("/")+uploadDir;
			//文件名称
			String sourceFile = file.getOriginalFilename();
			//文件类型
			String fileType = sourceFile.substring(sourceFile.lastIndexOf(".") + 1);
			// 目标文件名称
			String fileName = Sequence.getSequenceNumber();
			//文件
			File targetFile = new File(path, fileName+"."+fileType);
			
			//如果文件夹不存在则创建
			String temp = "";
	        for(int i=0 ; i<path.split("/").length ; i++){
	        	if(i>0)
	        		temp += "/";
	        	temp += path.split("/")[i];
	            File dir =new File(temp);
	            if  (!dir.exists()  && !dir.isDirectory())
	            	dir.mkdir();
	        }
  
	        //保存 文件
            file.transferTo(targetFile);
            
            //记录上传文件信息
            BaseAccessor accessor = new BaseAccessor();
            String baid = Sequence.getSequence();
			String dpid = request.getParameter("dpid");
			String businessCode = request.getParameter("businesscode");
			accessor.setBAID(baid);
			accessor.setBUSINESSCODE(businessCode);
			accessor.setBUSINESSNAME(fileName);
			accessor.setDPID(dpid);
			accessor.setFILENAME(fileName+"."+fileType);
			accessor.setFILEPATH(path);
			accessor.setFILETYPE(fileType);
			baseAccessorService.saveAccessor(accessor);

			//返回页面信息
			writer.write("{\"status\":\"true\",\"baid\":\""+baid+"\",\"imageSrc\":\"" + uploadDir+"/"+fileName+"."+fileType+"\"}");
			writer.flush();
			writer.close();
        } catch (Exception e) {  
        	log.error("upload BaseAccessorController is error : ", e);
			writer.write("{status:false}");
			writer.flush();
			writer.close();
        }  
    }  

	/**
	 * 下载文件
	 * @param request HTTP请求对象
	 * @param response HTTP响应对象
	 * @param freq 表单请求数据对象
	 */
	@RequestMapping(value = "/downloadFile")  	
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		// 创建表单响应数据对象
		try {
			String baid = (String)request.getParameter("baid");
			BaseAccessor accessor = baseAccessorService.getById(baid);
			String filename = accessor.getFILEPATH() + accessor.getFILENAME();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(filename));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			response.reset();
			// 设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition","attachment;filename=\"" + 
					new String(accessor.getBUSINESSNAME().getBytes("GB2312"),"ISO8859_1") + "\"");
			OutputStream out = new BufferedOutputStream(response.getOutputStream());
			out.write(buffer);
			out.flush();
			out.close();
		} catch (Exception e) {
			log.error("downloadFile BaseAccessorController is error : ", e);
		}
	}
	
}
