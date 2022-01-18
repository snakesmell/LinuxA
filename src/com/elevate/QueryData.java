package com.elevate;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.file.service.ElevateService;


@RestController
@RequestMapping(value = "/queryData")
@Scope(value="singleton")
public class QueryData {
	
	@Autowired
	private ElevateService elevateService;
	
	@RequestMapping(value="/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Map<String, Object>> list = elevateService.list("30");
			
			
			JSONArray arry = new JSONArray();
			
			String add=request.getRemoteAddr(); 
			JSONArray datay = new JSONArray();
			JSONArray a1 = new JSONArray();
			JSONArray a2 = new JSONArray();
			JSONArray a3 = new JSONArray();
			JSONArray a4 = new JSONArray();
			JSONArray a5 = new JSONArray();
			JSONArray a6 = new JSONArray();
			JSONArray b1 = new JSONArray();
			int i=0;
			for (Map<String, Object> map : list) {
				String id   = String.valueOf(map.get("id"));
				String r1 = String.valueOf(map.get("r1"));
				String r2 = String.valueOf(map.get("r2"));
				String r3 = String.valueOf(map.get("r3"));
				String r4 = String.valueOf(map.get("r4"));
				String r5 = String.valueOf(map.get("r5"));
				String r6 = String.valueOf(map.get("r6"));
				String b11 = String.valueOf(map.get("b1"));
				
				datay.put(id);
				a1.put(Integer.parseInt(r1));
				a2.put(Integer.parseInt(r2));
				a3.put(Integer.parseInt(r3));
				a4.put(Integer.parseInt(r4));
				a5.put(Integer.parseInt(r5));
				a6.put(Integer.parseInt(r6));
				b1.put(Integer.parseInt(b11));
				
			}
			StringBuilder sb=new StringBuilder();
			sb.append("var datay ="+datay.toString());sb.append(";");
			sb.append("var datan1 ="+a1.toString());sb.append(";");
			sb.append("var datan2 ="+a2.toString());sb.append(";");
			sb.append("var datan3 ="+a3.toString());sb.append(";");
			sb.append("var datan4 ="+a4.toString());sb.append(";");
			sb.append("var datan5 ="+a5.toString());sb.append(";");
			sb.append("var datan6 ="+a6.toString());sb.append(";");
			sb.append("var data ="+b1.toString());sb.append(";");
			
			response.getWriter().append(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JSONArray arry = new JSONArray();
		arry.put("1");
		arry.put("2");
//		System.out.println(arry.toString());
		StringBuilder sb=new StringBuilder();
		sb.append("var datay ="+arry.toString());
		System.out.println(sb.toString());
	}
	
}
