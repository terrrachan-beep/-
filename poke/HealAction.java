package poke;

public class HealAction extends BA{
	int amount;
	public HealAction(pokemon P1,int amount) {
		// TODO Auto-generated constructor stub
		super(P1);
		this.actor=P1;
		this.amount=amount;
	}
	@Override void execute() {
		System.out.println(this.actor.show_name()
				+"使用傷藥, 回復了"
				+this.amount+"點hp");
		this.actor.set_hp(amount);
	}

}
