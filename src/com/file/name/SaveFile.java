package com.file.name;

import java.io.File;
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
    public String fileUpload(@RequestParam("fileName") MultipartFile file){
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        
        String path = filepath + "/" + fileName;
        File dest = new File(path);
        if(!dest.getParentFile().exists()){ 
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); 
            fileService.save(path,fileName);//保存文件
            return "true";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
    }
}
