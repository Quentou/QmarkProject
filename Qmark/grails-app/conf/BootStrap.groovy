import loginproject.User
import loginproject.UserController;

class BootStrap {

    def init = { servletContext ->
		
		
		User u1 = new User(id:7,firstName:"Quentin",lastName:"LeBoGoss",email:"Quentinou@hotmail.fr",password:"groscacamou")
		User u2 = new User(id:3,firstName:"Jack",lastName:"Danny",email:"JackDanny@hotmail.fr",password:"petitcaca")
		
		
		if(!u1.save()){
			u1.errors.allErrors.each {e->println e}
		}
		
		if(!u2.save()){
			u1.errors.allErrors.each {e->println e}
		}
		
		
		
	
		/*println u1.getProperty("id")
		println u1.getProperty("firstName")*/
		//println User.get(1).getProperty("firstName")
		
		for(int i=1;i<=User.count();i++){
			
			println User.get(i).getProperties()
		}
		
		
    }
    def destroy = {
    }
}
