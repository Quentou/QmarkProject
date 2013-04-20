package loginproject

class TeacherController {

    def scaffold = Teacher
	
	def ajouterGroup ={
		
		//[params : params]
		
		def userInstance = User.get(params.id)
		[userInstance:userInstance]
		
		
		for(int i=1;i<=Stugroup.count();i++){
			if(params.groupName == Stugroup.get(i).getProperty("nom")){
				
				userInstance.addToStugroups(Stugroup.get(i))
				if(!userInstance.save()){
					userInstance.errors.allErrors.each {e->println e}
				}
				[params : params]
				redirect(action: '../user/indexteacher',params:params)
			}
		}
		render "groupe inexistant"
		
	}
	
	def creerGroup={
		def newGroup = new Stugroup(nom:params.groupName)
		if(!newGroup.save()){
			newGroup.errors.allErrors.each {e->println e}
		}
		[newGroup:newGroup,params:params]
		redirect(action: '../user/indexteacher')
	}
	
	def ajouterQuestion ={
		
		Question questionIstance = new Question(question: params.question,createur: params.nomCreateur)
		if(!questionIstance.save()){
			questionIstance.errors.allErrors.each {e->println e}
		}
		for(int i=1;i<=Stugroup.count();i++){
			if(params.groupName == Stugroup.get(i).getProperty("nom")){
				
				Stugroup.get(i).addToQuestions(questionIstance)
				if(!Stugroup.get(i).save()){
					Stugroup.get(i).errors.allErrors.each {e->println e}
				}
				[params : params]
				redirect(action: '../user/indexteacher',params:params)
			}
		}
		render "groupe inexistant"
		
		
	}
	
}
