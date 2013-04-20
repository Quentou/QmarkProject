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
	
}
