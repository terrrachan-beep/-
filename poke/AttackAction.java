package poke;

public class AttackAction extends BA {
	pokemon defender;
	move move;
	public AttackAction(pokemon P1,pokemon P2, move move) {
		super(P1);
		this.defender=P2;
		this.move=move;
		// TODO Auto-generated constructor stub
	}
	@Override void execute() {
		entry e1=new entry();
    	System.out.print(this.actor.show_name());
    	int k=e1.damage(this.actor.get_move(0),
    			this.defender.get_type());
    	System.out.println(""+k+"點傷害");
    	defender.set_hp(0-k);
		System.out.println(this.actor.show_name()+":"
		+this.actor.show_hp());
		System.out.println(this.defender.show_name()+":"
		+this.defender.show_hp());
		System.out.println();
		if(this.defender.show_hp()==0) {
			System.out.println(
					this.defender.show_name()
					+"昏倒了...");
		}
	}
	
	@Override boolean check_hp() {
		if (this.defender.show_hp()==0) {
			return true;
		}
		return false;
	}
}
