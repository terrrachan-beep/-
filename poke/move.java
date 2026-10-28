package poke;

public class move {
	private int number;
	private String name;
	private String type;
	private int cate;
	private int power;
	private int accuracy;
	private int pp;
	private int current_pp;
	public move(int number,
			String name,
			String type,
			int cate,
			int power,
			int accuracy,
			int pp) {
		this.number=number;
		this.name=name;
		this.type=type;
		this.cate=cate;
		this.power=power;
		this.accuracy=accuracy;
		this.pp=pp;
		this.current_pp=pp;
		// TODO Auto-generated constructor stub
	}
	void set_curr_pp(int value) {
		this.current_pp=value;
	}
	int show_number() {
		return this.number;
	}
	String show_name() {
		return this.name;
	}
	String show_type() {
		return this.type;
	}
	int show_cate() {
		return this.cate;
	}
	int show_power() {
		return this.power;
	}
	int show_accuracy() {
		return this.accuracy;
	}
	int show_pp() {
		return this.pp;
	}
	int show_curr_pp() {
		return this.current_pp;
	}
}
