package poke;

public class BattleAction {
    pokemon attacker;
    pokemon defender;
    move move;
    
    BattleAction(
    	    pokemon attacker,
    	    pokemon defender,
    	    move move
    	) {
    	    this.attacker = attacker;
    	    this.defender = defender;
    	    this.move = move;
    	}
    int perform() {
    	entry e1=new entry();
    	System.out.print(this.attacker.show_name());
    	int k=e1.damage(this.attacker.get_move(0),
    			this.defender.get_type());
    	System.out.println(""+k+"點傷害");
    	return k;
    }
}
