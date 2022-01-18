package com.file.name;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.file.service.FileService;


@RestController
@PropertySource("classpath:application.yml")
@RequestMapping(value = "/query")
@Scope(value="singleton")
public class QueryFile {
	
	@Value("${filepath}")
    public String filepath;
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value="/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			List<Map<String, Object>> list = fileService.list();
			JSONArray arry = new JSONArray();
			
			String add=request.getRemoteAddr(); 
			
			for (Map<String, Object> map : list) {
				String id   = String.valueOf(map.get("id"));
				String path = String.valueOf(map.get("filepath"));
				String name = String.valueOf(map.get("filename"));
				JSONObject obj = new JSONObject();
				obj.put("name", name);
				obj.put("path", path);
				obj.put("id", id);
//				obj.put("url", );
				arry.put(obj);
			}
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(arry.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 文件删除
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("path");
		String path = request.getParameter("path");
		try {
			Map<String, Object> map = fileService.listbyid(path);
			path=(String) map.get("filepath");
		    File file = new File(path);  
			if (file.isFile() && file.exists()) {  
		        file.delete();  
		    }  
			
			int flag = fileService.deletebyid(id);
			
			response.getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/view")
	public void view(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getParameter("path");
		Map<String, Object> map = fileService.listbyid(path);
		
		path=(String) map.get("filepath");
		
		System.out.println(path);
		 try {
			    File file = new File(path);
			    if (file.exists()) {
				     DataOutputStream temps = new DataOutputStream(response.getOutputStream());
				     DataInputStream in = new DataInputStream(new FileInputStream(path));
				     byte[] b = new byte[2048];
				     while ((in.read(b)) != -1) {
					      temps.write(b);
					      temps.flush();
				     }
				     in.close();
				     temps.close();
			    } else {
			    	System.out.println("文件不存在!");
			    }
			 } catch (Exception e) {
			    e.printStackTrace();
		     }
		
	}
}
