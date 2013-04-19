import loginproject.Question
import loginproject.Student
import loginproject.Stugroup
import loginproject.Teacher
import loginproject.User
import loginproject.UserController;

class BootStrap {

    def init = { servletContext ->
		
		
		User u1 = new User(id:7,firstName:"Quentin",lastName:"LeBoGoss",email:"Quentinou@hotmail.fr",password:"groscacamou")
		User u2 = new User(id:3,firstName:"Jack",lastName:"Danny",email:"JackDanny@hotmail.fr",password:"petitcaca")
		Teacher u3 = new Teacher(id:3,firstName:"Albert",lastName:"Einstein",email:"Einstein@cern.fr",password:"e=mc2")
		Stugroup u4 = new Stugroup(nom:"2.1")
		Question q1 = new Question(id:1,group:u4, question:"Quelle est la taille de mon p ... ?", type:"simple");
		
		
		if(!u1.save()){
			u1.errors.allErrors.each {e->println e}
		}
		
		if(!u2.save()){
			u2.errors.allErrors.each {e->println e}
		}
		if(!u3.save()){
			u3.errors.allErrors.each {e->println e}
		}
		if(!u4.save()){
			u4.errors.allErrors.each {e->println e}
		}
		
		if(!q1.save()){
			q1.errors.allErrors.each {e->println e}
		}
		
		
		
	
		/*println u1.getProperty("id")
		println u1.getProperty("firstName")
		println User.get(1).getProperty("firstName")*/
		
		for(int i=1;i<=User.count();i++){
			
			println User.get(i).getProperties()
			
		}
		
		Student stu1 = new Student(firstName:"Tom",lastName:"Sawyer",email:"TomSawyer@hotmail.fr",password:"Tomy",group:u4)
		Student stu2 = new Student(firstName:"Bob",lastName:"Lebricolo",email:"bob@hotmail.fr",password:"Boby", group:u4)
		
		if(!stu1.save()){
			stu1.errors.allErrors.each {e->println e}
		}
		
		if(!stu2.save()){
			stu2.errors.allErrors.each {e->println e}
		}
		
		/*stu1.getProperties();
		Student.get(1).getProperties();
		User.get(3).getProperties();*/
		
//		for(int i=1;i<=User.count();i++){
//			
//			println User.get(i).getProperties()
//		}
		println "attention"
//		println User.get(3).getProperties()
//		println Student.get(1).getProperties()
//	
		for(int i=1;i<=User.count();i++){
			
			println User.get(i).getProperties()
			println User.get(i).getClass()
		}
		
		for(int i=1;i<=Student.count();i++){
			
			println Student.get(i).getProperties();
		}
		println stu1.getProperty("id")
		
		
		
		
		/*for(int i=1;i<=Student.count();i++){
			
						println "le truc"
						
						println ((User)Student.get(i)).getProperties()
					}*/
		
		
		
		
		
		//user.class.equals( Etudiant.class )
    }
    def destroy = {
    }
}
