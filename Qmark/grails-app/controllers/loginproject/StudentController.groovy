package loginproject

class StudentController {

    def scaffold = Student

	
	def ajouterReponse ={
		def userInstance= User.get(params.iduser) 
		[userInstance:userInstance]
		
		Question questionInstance=Question.get(params.idquestion)
		[questionInstance:questionInstance]
		
		Answer rep = new Answer(reponse:params.reponse,student:userInstance,question:questionInstance)
		
		if(!rep.save()){
			rep.errors.allErrors.each {e->println e}
		}
		userInstance.addToReponses(rep)
		if(!userInstance.save()){
			userInstance.errors.allErrors.each {e->println e}
		}
		
		
		[params : params]
		redirect(action: '../user/indexstudent',params:params)
	}
	
	def creerStudent ={
		
		for(int i=1;i<= Stugroup.count();i++){
			
					if(Stugroup.get(i).getProperty("nom")){
						def StudentInstance = new Student(firstName:params.firstName,lastName:params.lastName,email:params.email,password:params.password,group:Stugroup.get(i))
						if(!StudentInstance.save()){
							StudentInstance.errors.allErrors.each {e->println e}
						}
						[params : params]
						redirect(action: '../',params:params)
					}
		
		}
		render "Stugroup failed"
		
		
	}
	def indexCreerStudent ={
		
	}
	
}
