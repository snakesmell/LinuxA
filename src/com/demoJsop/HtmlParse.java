package com.demoJsop;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.demo.db.MySQLDemo;

public class HtmlParse {

	public static void main(String[] args) {
		for(int i=2016001;i<20161160;i++) {
			HtmlParse.parse(String.valueOf(i));
		}
//		HtmlParse.parse("2016102");
	}
	public static void parse(String no) {
		Document doc;
		try {
			String url="https://www.cjcp.com.cn/kaijiang/ssq/index.php?qh="+no;
			System.out.println(url);
			doc = Jsoup.connect(url).get();
//			System.out.println(doc.toString());
//			String title = doc.title();
//			System.out.println(title);
			Elements temp = doc.getElementsByClass("num_div");
			ListIterator<Element> iter = temp.listIterator();
			List<String> list = temp.eachText();
//			for (String string : list) {
//				System.out.println(string);
//			}
			System.out.println(list.get(0));
			String val=list.get(0);
			String r1 = val.substring(0, 2);
			String r2 = val.substring(2, 4);
			String r3 = val.substring(4, 6);
			String r4 = val.substring(6, 8);
			String r5 = val.substring(8, 10);
			String r6 = val.substring(10, 12);
			String r7 = val.substring(12, 14);
			MySQLDemo.insert(no, 
					String.valueOf(Integer.parseInt(r1)), 
					String.valueOf(Integer.parseInt(r2)), 
					String.valueOf(Integer.parseInt(r3)), 
					String.valueOf(Integer.parseInt(r4)), 
					String.valueOf(Integer.parseInt(r5)), 
					String.valueOf(Integer.parseInt(r6)), 
					String.valueOf(Integer.parseInt(r7))
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
