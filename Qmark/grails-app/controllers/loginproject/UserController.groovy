package loginproject

class UserController {

    def indexuser() { }
	def login ={
		if(params.username == "admin" && params.password == "pass"){
			flash.message = "login succed"
			session.user = "admin"
			redirect(action:'indexuser')
		}
		else{
			render "login failed"
			
		}
		
		
	}
	
	def logout ={
		session.user = null
		redirect(action: '../')
		
		
	}
}
