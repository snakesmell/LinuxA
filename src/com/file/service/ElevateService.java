package com.file.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ElevateService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * 查询所有数据
     * @return
     */
    public List<Map<String, Object>> list(String limit){
    	List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM ( SELECT * FROM doubleball order by id desc  LIMIT "+limit +" )a ORDER BY a.id asc ");
        return list;
    }
    /**
     * 删除
     * @param id
     * @return
     */
    public int deletebyid(String id){
    	int flag = jdbcTemplate.update("DELETE from filepath WHERE id ="+id);
        return flag;
    }
    
    
    public Map<String, Object> listbyid(String id){
    	Map<String, Object> map = jdbcTemplate.queryForMap("select * FROM filepath where id="+id);
        return map;
    }
    
    /**
     * 插入数据
     * @param path
     * @return
     */
    public int save(String path,String filename,String ftype) {
    	int flag = jdbcTemplate.update(" INSERT INTO filepath (filepath,filename,ftype) VALUES ('"+path+"','"+filename+"','"+ftype+"') ");
    	return flag;
    }
}
