package com.yidu.dao.lyq;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yidu.bean.lyq.Game;

@Repository
public interface GameMapper {
 @Select("select * from game")
 public List<Game> selectAllGame();
 @Select("select*from game limit #{page},#{rows}")
 public List<Game> GAMELimit(@Param("page") int page,@Param("rows") int rows);
 @Insert("insert into game values(#{LeagueOfLegends},#{CrossFire},#{DungeonFighter},#{TheViralFactor},#{QQAerodyne},#{StimulateTheBattlefield},#{BallBallBattle},#{HonorOfKings},#{Landowner})")
 public int insertGame(Game game);
}
