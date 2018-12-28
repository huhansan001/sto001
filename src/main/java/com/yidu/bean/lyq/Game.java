package com.yidu.bean.lyq;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Game implements Serializable{
	private String LeagueOfLegends ;//英雄联盟(LOL)
	private String CrossFire ;//穿越火线(CF)
	private String DungeonFighter;//地下城与勇士(DNF)
	private String TheViralFactor ;//逆战
	private String QQAerodyne ;//QQ飞车
	private String StimulateTheBattlefield ;//绝地求生(刺激战场)
	private String BallBallBattle;//球球大作战
	private String HonorOfKings ;//王者荣耀
	private String Landowner;//欢乐斗地主
	public String getLeagueOfLegends() {
		return LeagueOfLegends;
	}
	public void setLeagueOfLegends(String leagueOfLegends) {
		LeagueOfLegends = leagueOfLegends;
	}
	public String getCrossFire() {
		return CrossFire;
	}
	public void setCrossFire(String crossFire) {
		CrossFire = crossFire;
	}
	public String getDungeonFighter() {
		return DungeonFighter;
	}
	public void setDungeonFighter(String dungeonFighter) {
		DungeonFighter = dungeonFighter;
	}
	public String getTheViralFactor() {
		return TheViralFactor;
	}
	public void setTheViralFactor(String theViralFactor) {
		TheViralFactor = theViralFactor;
	}
	public String getQQAerodyne() {
		return QQAerodyne;
	}
	public void setQQAerodyne(String qQAerodyne) {
		QQAerodyne = qQAerodyne;
	}
	public String getStimulateTheBattlefield() {
		return StimulateTheBattlefield;
	}
	public void setStimulateTheBattlefield(String stimulateTheBattlefield) {
		StimulateTheBattlefield = stimulateTheBattlefield;
	}
	public String getBallBallBattle() {
		return BallBallBattle;
	}
	public void setBallBallBattle(String ballBallBattle) {
		BallBallBattle = ballBallBattle;
	}
	public String getHonorOfKings() {
		return HonorOfKings;
	}
	public void setHonorOfKings(String honorOfKings) {
		HonorOfKings = honorOfKings;
	}
	public String getLandowner() {
		return Landowner;
	}
	public void setLandowner(String landowner) {
		Landowner = landowner;
	}
	@Override
	public String toString() {
		return "Game [LeagueOfLegends=" + LeagueOfLegends + ", CrossFire=" + CrossFire + ", DungeonFighter="
				+ DungeonFighter + ", TheViralFactor=" + TheViralFactor + ", QQAerodyne=" + QQAerodyne
				+ ", StimulateTheBattlefield=" + StimulateTheBattlefield + ", BallBallBattle=" + BallBallBattle
				+ ", HonorOfKings=" + HonorOfKings + ", Landowner=" + Landowner + "]";
	}
	
}
