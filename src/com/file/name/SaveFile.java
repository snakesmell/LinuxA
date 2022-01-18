package com.file.name;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.service.FileService;

@RestController
@PropertySource("classpath:application.yml")
@RequestMapping(value = "/store")
@Scope(value="singleton")
public class SaveFile {
	
	@Value("${filepath}")
    public String filepath;
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value="/file")
	public void saveFile(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(123);
//		Object obj = fileService.getAll();
//		fileService.save(null);
//		System.out.println(obj);
	}
	
	/**
     * */
    @RequestMapping("fileUpload")
    @ResponseBody 
    public void fileUpload(@RequestParam("fileName") MultipartFile file,@RequestParam("ftype") String ftype, HttpServletResponse response) {
    	try {
	    	if(file.isEmpty()){
	        	response.getWriter().print(1);
	        }
	        String fileName = file.getOriginalFilename();
	        
	        int size = (int) file.getSize();
	        System.out.println(fileName + "-->" +ftype+"---"+ size);
	        
	        String path = filepath + "/" + fileName;
	        File dest = new File(path);
	        if(!dest.getParentFile().exists()){ 
	            dest.getParentFile().mkdir();
	        }
            file.transferTo(dest); 
            fileService.save(path,fileName,ftype);//保存文件
         // 设置302状态码
            response.setStatus(302);
            // 设置location响应头
            response.setHeader("location", "/ThePage/line.html");
            // 注意：一次重定向，向服务器发送两次请求
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
