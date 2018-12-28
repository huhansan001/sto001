package com.yidu.service.lyq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.lyq.Distribute;
import com.yidu.bean.lyq.Game;
import com.yidu.dao.lyq.GameMapper;

@Service
public class GameService {
@Autowired
private GameMapper gameMapper;
public Map<String, Object> selectAllGame(String page,String rows){
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("code", 0);
	map.put("msg", "");
	map.put("cound",gameMapper.selectAllGame().size() );
	map.put("date", gameMapper.GAMELimit((Integer.parseInt(page)-1)*Integer.parseInt(rows),Integer.parseInt(rows)));
	return map;
	
}
public int insertGame(Game game) {
	return gameMapper.insertGame(game);
}
}
