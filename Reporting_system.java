import java.util.*;
class Reporting_system{
	static Scanner scan=new Scanner(System.in);
	String Student_name;
	int sem1_english;
	int sem1_science;
	int sem1_maths;
	int sem2_english;
	int sem2_science;
	int sem2_maths;
	int total_average;
	static boolean second_sem_finished=false;//to find recent semester
	Reporting_system(String name){
		Student_name=name;
		System.out.println("Student added successfully");
		try{
			Thread.sleep(500);
		}
		catch(Exception e){}
	}

	static void Add_marks_of_student(ArrayList<Reporting_system> Student_data){
		screen.clr();
		System.out.println("------MARK ENTRY-----");
		System.out.println("1.Semester 1\n2.semester 2\n3.to go back");
		System.out.print("enter your choice:");
		int ch=scan.nextInt();
		if(ch==1){
			screen.clr();
			System.out.println("--SEMESTER 1--");
			System.out.println("1.English\n2.Maths\n3.Science\n4.to go back");
			System.out.print("choose subject:");
			switch(scan.nextInt()){
			case(1):
				screen.clr();
				System.out.printf("%-20s - %s","Student Name","Enter English mark(out of 100)\n");
				for(Reporting_system i:Student_data){
						System.out.printf("%-20s - ",i.Student_name);
						i.sem1_english=scan.nextInt();
					}
					System.out.println("Data updated");
				break;
			case(2):
				screen.clr();
				System.out.printf("%-20s - %s","Student Name","Enter Maths mark(out of 100)\n");
				for(Reporting_system i:Student_data){
						System.out.printf("%-20s - ",i.Student_name);
						i.sem1_maths=scan.nextInt();
					}
					System.out.println("Data updated");
				break;
			case(3):
				screen.clr();
				System.out.printf("%-20s - %s","Student Name","Enter Science mark(out of 100)\n");
				for(Reporting_system i:Student_data){
						System.out.printf("%-20s - ",i.Student_name);
						i.sem1_science=scan.nextInt();
					}
					System.out.println("Data updated");
				break;
			default:
				Add_marks_of_student(Student_data);
			}
		}
		else if (ch==2){
			second_sem_finished=true;
			screen.clr();
			System.out.println("--SEMESTER 2--");
			System.out.println("1.English\n2.Maths\n3.Science\n4.to go back");
			System.out.print("choose subject:");
			switch(scan.nextInt()){
			case(1):
				screen.clr();
				System.out.println("--Semester 2--");
				System.out.printf("%-20s - %s","Student Name","Enter English mark\n");
				for(Reporting_system i:Student_data){
						System.out.printf("%-20s - ",i.Student_name);
						i.sem2_english=scan.nextInt();	
				}
				System.out.println("Data updated");
				break;
			case(2):
				screen.clr();
				System.out.printf("%-20s - %s","Student Name","Enter Maths mark(out of 100)\n");
				for(Reporting_system i:Student_data){
						System.out.printf("%-20s - ",i.Student_name);
						i.sem2_maths=scan.nextInt();
					}
					System.out.println("Data updated");
				break;
			case(3):
				screen.clr();
				System.out.printf("%-20s - %s","Student Name","Enter Science mark(out of 100)\n");
				for(Reporting_system i:Student_data){
						System.out.printf("%-20s - ",i.Student_name);
						i.sem2_science=scan.nextInt();
					}
					System.out.println("Data updated");
				break;
			default:
				Add_marks_of_student(Student_data);
			}

		}
		else {
			Main.main(null);
		}
		Add_marks_of_student(Student_data);
	}
	static void Reports(ArrayList<Reporting_system> Student_data){
		screen.clr();
		String Consistent_Student1="";
		String Consistent_Student2="";
		int Consistent_Student1_Average=0;
		int Consistent_Student2_Average=0;
		int overall_mark=Student_data.size()*300;
		int Whole_class_total_mark=0;
		int Average_mark_in_maths=0;
		int Average_mark_in_english=0;
		int Average_mark_in_science=0;
		for (Reporting_system i: Student_data){
				int sem1_total=i.sem1_maths+i.sem1_english+i.sem1_science;
				int sem2_total=i.sem2_science+i.sem2_maths+i.sem2_english;
				int total=sem1_total+sem2_total;
				if((total/6)>Consistent_Student1_Average){
					Consistent_Student1_Average=(total)/6;
					Consistent_Student1=i.Student_name;
				}
				else if((total/6)==Consistent_Student1_Average){
					Consistent_Student2_Average=(total)/6;
					Consistent_Student2=i.Student_name;
				}

				else if((((total)/6)<Consistent_Student1_Average) && (((total)/6)>Consistent_Student2_Average)){
					Consistent_Student2_Average=(total)/6;
					Consistent_Student2=i.Student_name;
				}
				if(second_sem_finished)
					Whole_class_total_mark+=sem2_total;
				else 
					Whole_class_total_mark+=sem1_total;
				Average_mark_in_maths+=i.sem1_maths+i.sem2_maths;
				Average_mark_in_science+=i.sem1_science+i.sem2_science;
				Average_mark_in_english+=i.sem1_science+i.sem2_science;
		}
		int divider=2;
		if(second_sem_finished==false)
		{
			divider=1;
		}
		try{
				System.out.println("Average Percentage of whole class in recent semester : "+(Whole_class_total_mark*100)/overall_mark+"%");
				System.out.println("Average Mark of Student in Maths : "+Average_mark_in_maths/(Student_data.size()*divider));
				System.out.println("Average Mark of Student in english : "+Average_mark_in_english/(Student_data.size()*divider));
				System.out.println("Average Mark of Student in Science : "+Average_mark_in_science/(Student_data.size()*divider));
				
				//System.out.println("Top 2 consistency student : "+Consistent_Student2);
				
				System.out.println("--------------------------------------------------------------------");
				System.out.println("-----------Average of Each Students in Each Subject-----------------");
				System.out.println("--------------------------------------------------------------------");
				System.out.printf("%-15s %-10s %-10s %-10s %-15s\n","Student Name","English","Maths","Science","Total Average");
				System.out.println("---------------------------------------------------------------------");
				for(Reporting_system i:Student_data){
					System.out.printf("%-15s %-10d %-10d %-10d %-15d\n",i.Student_name,((i.sem1_english+i.sem2_english)/divider),((i.sem1_maths+i.sem2_maths)/divider),((i.sem1_science+i.sem2_science)/divider),(i.sem1_science+i.sem1_english+i.sem1_maths+i.sem2_maths+i.sem2_science+i.sem2_english)/(divider*3));
				}
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Top 2 consistency students\n"+"1."+Consistent_Student1 +"\n2."+Consistent_Student2);

				System.out.println("");
				System.out.println("type anything and press enter to go back:");
				scan.next();
			}
		catch(Exception ex)
		{
			System.out.println("----DATA NOT FOUND----");
			System.out.println("type anything and press enter to go back:");
			scan.next();
		}
	}
}