package poke;
import java.util.*;

public class main_class {
	
	pokemon selectNextPokemon(ArrayList<pokemon> members, pokemon activePokemon) {
	    for (int i = 0; i < members.size(); i++) {
	        pokemon p = members.get(i);
	        if (p.show_hp() > 0 && p != activePokemon) {
	            return p;
	        }
	    }
	    return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		entry e1=new entry();
		ArrayList<pokemon> team1= new ArrayList();
		ArrayList<pokemon> team2= new ArrayList();
		pokemon P1=new pokemon("小火龍","火",50,4,45);
		P1.moves[0]=new move(1, "拍擊","一般",0,40,100,35);
		P1.show_move(0);
		team1.add(P1);
		P1=new pokemon("皮卡丘","水",50,3,65);
		P1.moves[0]=new move(84, "電擊","電",0,40,100,30);
		P1.show_move(0);
		team1.add(P1);
		P1=new pokemon("走路草","草",30,4,55);
		P1.moves[0]=new move(22, "藤鞭","草",0,45,100,25);
		P1.show_move(0);
		team1.add(P1);
		System.out.println(team1.size());

		P1=new pokemon("小火龍","火",50,4,45);
		P1.moves[0]=new move(1, "拍擊","一般",0,40,100,35);
		P1.show_move(0);
		team2.add(P1);
		P1=new pokemon("皮卡丘","水",50,3,65);
		P1.moves[0]=new move(84, "電擊","電",0,40,100,30);
		P1.show_move(0);
		team2.add(P1);
		P1=new pokemon("走路草","草",30,4,55);
		P1.moves[0]=new move(22, "藤鞭","草",0,45,100,25);
		P1.show_move(0);
		team2.add(P1);
		System.out.println(team2.size());
		int i1=0,i2=0;
		pokemon currP1=team1.get(i1);
		pokemon currP2=team2.get(i2);
		main_class m1=new main_class();
		pokemon nextP1=m1.selectNextPokemon(team1, currP1);
		pokemon nextP2=m1.selectNextPokemon(team2, currP2);
		do {
			boolean c1=false,c2=false;
			while ((currP1.show_hp()>0)&(currP2.show_hp()>0)) {
				
				try {
					CircularQueue sq=new CircularQueue(5);
					if (c1==true) {
						System.out.println(currP1.show_name()+"加入，無法動作...");
						BA a2=new AttackAction(currP2,currP1,currP2.moves[0]);
						sq.enqueue(a2);
						c1=false;
					}else if (c2==true) {
						System.out.println(currP2.show_name()+"加入，無法動作...");
						BA a1=new AttackAction(currP1,currP2,currP1.moves[0]);
						sq.enqueue(a1);
						c2=false;
					}else {
						if (currP1.get_speed()>currP2.get_speed()) {
							BA a1=new AttackAction(currP1,currP2,currP1.moves[0]);
							BA a2=new AttackAction(currP2,currP1,currP2.moves[0]);
							sq.enqueue(a1);
							sq.enqueue(a2);
							BA a3=new HealAction(currP1,10);
							sq.enqueue(a3);
						}else {
							BA a2=new AttackAction(currP1,currP2,currP1.moves[0]);
							BA a1=new AttackAction(currP2,currP1,currP2.moves[0]);
							sq.enqueue(a1);
							sq.enqueue(a2);
						}
					}
					for (int i=sq.front;i<sq.rear;i++) {
						BA run=sq.dequeue();
						run.execute();
						if (run.check_hp()==true) {
							break;
						}
					}
					if (currP1.show_hp()==0) {
						currP1=nextP1;
						nextP1=m1.selectNextPokemon(team1, nextP1);
						c1=true;
					}else if (currP2.show_hp()==0) {
						currP2=nextP2;
						nextP2=m1.selectNextPokemon(team2, nextP2);
						c2=true;
					}
				}catch (IllegalArgumentException e) {
					System.out.println("Wrong queue size!");
					System.exit(1);
				}
				if ((currP1==null)||(currP2==null))
					break;
			}
		}while ((nextP1!=null)&&(nextP2!=null));
		
		/*
		while ((team1.size()>0)&&(team2.size()>0)) {
			pokemon currP1=team1.remove(0);
			System.out.println(team1.size());
			pokemon currP2=team2.remove(0);
			System.out.println(team2.size());
			while ((currP1.show_hp()>0)&(currP2.show_hp()>0)) {
				try {
					CircularQueue sq=new CircularQueue(5);
					if (currP1.get_speed()>currP2.get_speed()) {
						BA a1=new AttackAction(currP1,currP2,currP1.moves[0]);
						BA a2=new AttackAction(currP2,currP1,currP2.moves[0]);
						sq.enqueue(a1);
						sq.enqueue(a2);
						BA a3=new HealAction(currP1,10);
						sq.enqueue(a3);
					}else {
						BA a2=new AttackAction(currP1,currP2,currP1.moves[0]);
						BA a1=new AttackAction(currP2,currP1,currP2.moves[0]);
						sq.enqueue(a1);
						sq.enqueue(a2);
					}
					for (int i=sq.front;i<sq.rear;i++) {
						BA run=sq.dequeue();
						run.execute();
						if (run.check_hp()==true) {
							break;
						}
					}
					if (currP1.show_hp()==0)
						if (team1.size()>0)
							currP1=team1.remove(0);
						else 
							break;
					else if (currP2.show_hp()==0)
						if (team2.size()>0)
							currP2=team2.remove(0);
						else
							break;
				}catch (IllegalArgumentException e) {
					System.out.println("Wrong queue size!");
					System.exit(1);
				}
			}
			if ((team1.size()>0)&&(team2.size()>0))
				System.out.println("meow");
			else
				break;
		}
		/*
		entry e1=new entry();
		pokemon P1=new pokemon("小火龍","火",50,4,45);
		System.out.println(P1.show_hp());
		P1.moves[0]=new move(1, "拍擊","一般",0,40,100,35);
		P1.show_move(0);
		
		pokemon P2=new pokemon("妙蛙種子","草",50,1,30);
		System.out.println(P2.show_hp());
		P2.moves[0]=new move(22, "藤鞭","草",0,45,100,25);
		P2.show_move(0);
		System.out.println();
		while ((P1.show_hp()>0)&(P2.show_hp()>0)) {
			try {
				CircularQueue sq=new CircularQueue(5);
				if (P1.get_speed()>P2.get_speed()) {
					BA a1=new AttackAction(P1,P2,P1.moves[0]);
					BA a2=new AttackAction(P2,P1,P2.moves[0]);
					sq.enqueue(a1);
					sq.enqueue(a2);
					BA a3=new HealAction(P1,10);
					sq.enqueue(a3);
				}else {
					BA a2=new AttackAction(P1,P2,P1.moves[0]);
					BA a1=new AttackAction(P2,P1,P2.moves[0]);
					sq.enqueue(a1);
					sq.enqueue(a2);
					BA a3=new HealAction(P1,10);
					sq.enqueue(a3);
				}
				for (int i=sq.front;i<sq.rear;i++) {
					BA run=sq.dequeue();
					run.execute();
					if (run.check_hp()==true) {
						break;
					}
				}
			}catch (IllegalArgumentException e) {
				System.out.println("Wrong queue size!");
				System.exit(1);
			}
		}
		/*
		System.out.println(e1.checktype("火"));
		System.out.println(e1.c_table(e1.checktype("火"), 
				e1.checktype("草")));

		System.out.println(entry.c_table2(1,4)); //(O)
		
		System.out.print("小火龍");
		System.out.println(e1.damage(e1.allmove[2],"草")+"點傷害");
		System.out.print("小火龍");
		System.out.println(e1.damage(P1.moves[0],"草")+"點傷害");
		*/
		/*
		Pokemon team1[]=new Pokemon[100];
		for (int i=0;i<6;i++) {
			team1[i]=new Pokemon("小火龍"+i,"火系",50,4);
		}
		//走訪
		for (int i=0;i<6;i++) {
			System.out.println(team1[i].show_hp());
		}*/
	}

}
