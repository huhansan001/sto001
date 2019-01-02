package com.yidu.controller.lyq;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.bean.lyq.Distribute;
import com.yidu.bean.lyq.Game;
import com.yidu.service.lyq.GameService;

@Controller
public class GameAction {
@Autowired
private GameService gameService;

@RequestMapping("selectAllGame.action")
public @ResponseBody Map<String,Object> selectAllGame(String page,String limit){
	return gameService.selectAllGame(page, limit);
}
@RequestMapping("insertGame.action")
public @ResponseBody int  insertGame(@ModelAttribute com.yidu.bean.lyq.Game game){
	return gameService.insertGame(game);
}
}
