package loginproject

class UserController {

	def indexuser() { }
	def login ={

		//si un User a le bon userName et password, �a marche
		for(int i=1;i<=User.count();i++){
			if(params.username == User.get(i).getProperty("firstName") && params.password == User.get(i).getProperty("password")){
				flash.message = "login succed"
				session.user = "admin"
				redirect(action:'indexuser')
			}
		}
		//sinon �a marche pas
		render "login failed"


	}

	def logout ={
		session.user = null
		redirect(action: '../')


	}
}
