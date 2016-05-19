
public class BaseballPlayer {

	/*
	 * Has-a:
	 * 
	 * Jersey Number
	 * Name
	 * Handedness
	 * 
	 * Behaviors:
	 * 
	 * records hits/RBI
	 * total hits/ RBI
	 * total games played
	 * 
	 */
	
	private int jerseyNum;
	private String name;
	private String handedness;
	private int gamesPlayed;
	private int totalHits = 0;
	private int totalRBI = 0;
	private int[] totalStats = new int[]{totalHits, totalRBI};
	
	public BaseballPlayer (String name, int jerseyNum, String handedness, int gamesPlayed, int[] totalStats){
		this.name = name;
		this.jerseyNum = jerseyNum;
		this.handedness = handedness;
		this.gamesPlayed = gamesPlayed;
		this.totalStats = totalStats;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getJerseyNum(){
		return this.jerseyNum;
	}
	
	public String getHandedness(){
		return this.handedness;
	}
	
	public int getGamesPlayed(){
		return this.gamesPlayed;
	}
	
	public int[] getTotalStats(){
		return this.totalStats;
	}
	
	public void setJerseyNum(int newNum){
		this.jerseyNum = newNum;
	}

	public void setName(String newName){
		this.name = newName;
	}
	
	public void setHandedness(String newHandedness){
		this.handedness = newHandedness;
	}
	
	public void setGamesPlayed(int newGamesPlayed){
		this.gamesPlayed = newGamesPlayed;
	}
	
	public void recordGame(int newHits, int newRBI){
		this.gamesPlayed++;
		int[] stats = new int[]{newHits, newRBI};
		addToTotal(stats);
	}
	
	public int[] addToTotal(int[] stats){
		this.totalStats[0] = this.totalStats[0] + stats[0];
		this.totalStats[1] = this.totalStats[1] + stats[1];
		return totalStats;
	}
	
	public String toString(){
		return name + " bats and throws " + handedness + ", wears the number " + jerseyNum + " and has played " + gamesPlayed + " games; accumulating " + totalStats[0] + " hits and " + totalStats[1] + " RBI";
	}
	
	public static void main (String args[]){
		BaseballPlayer dustin = new BaseballPlayer("Dustin Ward", 13, "right handed", 21, new int[]{28,15});
		BaseballPlayer justin = new BaseballPlayer("Justin Krul", 21, "left handed", 21, new int[]{20,16});
		System.out.println(dustin);
		System.out.println(justin);
		dustin.recordGame(20, 13);
		justin.recordGame(13, 10);
		System.out.println(java.util.Arrays.toString(dustin.getTotalStats()));
		System.out.println(java.util.Arrays.toString(justin.getTotalStats()));
		System.out.println(dustin);
		System.out.println(justin);
	}
}
