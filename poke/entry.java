package poke;

public class entry {
	double typechart[][]=new double[5][5];
	final static double typechart1[][]= {
		    {1.0, 1.0, 1.0, 1.0, 1.0},
		    {1.0, 0.5, 0.5, 1.0, 2.0},
		    {1.0, 2.0, 0.5, 1.0, 0.5},
		    {1.0, 1.0, 2.0, 0.5, 0.5},
		    {1.0, 0.5, 2.0, 1.0, 0.5}
		};
    move[] allmove=new move[5];
	String type[]=new String[5]; //0一般，1火，2水,3電系，4草
	public entry() {
		type[0]="一般";
		type[1]="火";
		type[2]="水";
		type[3]="電";
		type[4]="草";
		typechart[0][0]=1.0;
		typechart[0][1]=1.0;
		typechart[0][2]=1.0;
		typechart[0][3]=1.0;
		typechart[0][4]=1.0;
		typechart[1][0]=1.0;
		typechart[1][1]=0.5;
		typechart[1][2]=0.5;
		typechart[1][3]=1.0;
		typechart[1][4]=2.0;
		typechart[2][0]=1.0;
		typechart[2][1]=2.0;
		typechart[2][2]=0.5;
		typechart[2][3]=1.0;
		typechart[2][4]=0.5;
		typechart[3][0]=1.0;
		typechart[3][1]=1.0;
		typechart[3][2]=2.0;
		typechart[3][3]=0.5;
		typechart[3][4]=0.5;
		typechart[4][0]=1.0;
		typechart[4][1]=0.5;
		typechart[4][2]=2.0;
		typechart[4][3]=1.0;
		typechart[4][4]=0.5;
		this.set_move();
	}
	int checktype(String s) {
		int k=-1;
		for (int i=0;i<type.length;i++) {
			if (type[i].compareTo(s)==0) {
				k=i;
				break;
			}
		}
		return k;
	}
	void set_move() {
		this.allmove[0]=new move(1, "拍擊","一般",0,40,100,35);
		this.allmove[1]=new move(55, "水槍","水",2,40,100,25);
		this.allmove[2]=new move(51, "火花","火",2,40,40,25);
		this.allmove[3]=new move(9, "雷電拳","電",1,75,100,15);
		this.allmove[4]=new move(22, "藤鞭","草",2,45,100,25);
	}
	
	int damage(move m1, String type) {
		int type1=this.checktype(m1.show_type());
		int type2=this.checktype(type);
		double rate=this.c_table(type1, type2);
		double hit=Math.random();
		if (hit>(m1.show_accuracy()/100.0)) {
			System.out.println("發出的攻擊沒有命中...");
			System.out.print("造成了");
			return 0;
		}else {
			if (rate>1) {
				System.out.print("發出了"+m1.show_name()+"...結果非常有效");
			}else if(rate<1) {
				System.out.print("發出了"+m1.show_name()+"...結果不怎麼有效");
			}else {
				System.out.print("發出了"+m1.show_name()+"...");
			}
			System.out.println();
			System.out.print("造成了");
			return (int)(Math.round(m1.show_power()*rate));
		}
	}
	
	public static double c_table2(int att,int def) {
		return typechart1[att][def];
	}
	
	double c_table(int att,int def) {
		return typechart[att][def];
	}
}
