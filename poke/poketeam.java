package poke;
import java.util.*;
public class poketeam {
	ArrayList<pokemon> team=new ArrayList();
	pokemon activePokemon;
	public poketeam() {
		// TODO Auto-generated constructor stub
	}
	void add(pokemon p1) {
		this.team.add(p1);
	}
	pokemon get(int index) {
		return this.team.get(index);
	}
	pokemon selectNextPokemon() {
		  for (int i = 0; i < team.size(); i++) {
		    pokemon p = team.get(i);
		    if (p.show_hp() > 0 && p != activePokemon)
		      return p;
		  }
		  return null;
	}
	void switchPokemon() {
	    pokemon next = selectNextPokemon();
	    if (next != null) {
	        activePokemon = next;
	        System.out.println(next.show_name()+ " 進入了!");
	    } else {
	        activePokemon = null;
	        System.out.println("沒有可用的寶可夢了，你昏倒了..");
	    }
	}
	void setActive(pokemon p) {
	    activePokemon = p;
	}

}
