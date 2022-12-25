import java.util.*;
 class Main {
    static ArrayList<Reporting_system> Student_data=new ArrayList();
     static  Scanner scan=new Scanner(System.in);
 	
 	public static void main(String[] args) {
 		
 		
 		while(true){
 			screen.clr();
            System.out.println("Student Reporting System");
 			System.out.println("1.Add new student\n2.Add marks of student\n3.Reports\n4.Quit");
 			System.out.print("enter yur choice:");
 			switch(scan.nextInt()){
 			case(1):
                screen.clr();
                //scan.nextLine();
                while (true)
                {
                    screen.clr();
                    System.out.println("---Adding student---");
                    System.out.println("TYPE back to go back");
                    System.out.print("enter student name:");
                    String name=scan.next();
                    if(name.equals("back") || name.equals("BACK"))
                    {
                        
                        Main.main(null);
                    }
                    else 
                    {
                        Reporting_system r_s=new Reporting_system(name.toUpperCase());
                        Student_data.add(r_s);
                    }
                }
 				
 			case(2):
                screen.clr();
 				Reporting_system.Add_marks_of_student(Student_data);
                scan.next();
 				break;
 			case(3):
 				Reporting_system.Reports(Student_data);
 				//scan.next();
 				break;
 			case(4):
 				return;
 			}

 		}
 	}
 }