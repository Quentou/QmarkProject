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
		def userInstance= User.get(params.id)
		
		def newGroup = new Stugroup(nom:params.groupName)
		if(!newGroup.save()){
			newGroup.errors.allErrors.each {e->println e}
		}
		[newGroup:newGroup,userInstance:userInstance,params:params]
		redirect(action: '../user/indexteacher',params:params)
	}
	
	def ajouterQuestion ={
		
		def userInstance= User.get(params.id)
		for(int i=1;i<=Stugroup.count();i++){
			println Stugroup.get(i)
			if(Stugroup.get(i).hasProperty("nom")){
			
				if(params.groupName == Stugroup.get(i).getProperty("nom")){
				Question questionInstance = new Question(question: params.question,createur: params.nomCreateur,group:Stugroup.get(i),type:params.typeq,reponse:params.vraiereponse)
				if(!questionInstance.save()){
					questionInstance.errors.allErrors.each {e->println e}
				}
				
				/*
				 * Stugroup.get(i).addToQuestions(questionInstance)
				if(!Stugroup.get(i).save()){
					Stugroup.get(i).errors.allErrors.each {e->println e}
				}*/
				
				
				
				if(params.typeq == "QCM"){
					println "on passe dans QCM"
					println "questionInstance:"
					println questionInstance
					[params : params,questionInstance : questionInstance]
					redirect(action: '../teacher/ajouteQcm')
				}
				else{
					println "aha"
					Stugroup.get(i).addToQuestions(questionInstance)
					if(!Stugroup.get(i).save()){
						Stugroup.get(i).errors.allErrors.each {e->println e}
					}
					[params : params,questionInstance:questionInstance,userInstance:userInstance]
					redirect(action: '../user/indexteacher',params: params)
				}
				
				}
			}
		}
		
		render "groupe inexistant"
		
		
	}
	
	def ajouteQcm ={
		
		def questionInstance=params.questionInstance
		[questionInstance:questionInstance]
		println "questionInstance dans ajouteQCM"
		println questionInstance
		[questionInstance:questionInstance,params:params]
		
		
	}
	
	def ajouteQuestionQcm={
		
		def questionInstance = params.questionInstance
		println questionInstance
		if(params.reponse){
			println "on passe dans reponse"
			questionInstance.addReponse(params.reponse)
		}
		if(!questionInstance.save()){
			questionInstance.errors.allErrors.each {e->println e}
		}
		
		[params:params,questionInstance:questionInstance]
		redirect(action: '../teacher/ajouteQcm',params: params)
		
	}
	def createTeacher={
		[params:params]
		
		
		
		
	}
	
	def creerTeacher={
		
		def teacherInstance=new Teacher(firstName:params.firstName,lastName:params.lastName,email:params.email,password:params.password)
		if(!teacherInstance.save()){
			flash.message = "creation echoue"
			teacherInstance.errors.allErrors.each {e->println e}
			
			redirect(action: '../teacher/createTeacher',params: params)
		}
		else{
		redirect(action:'../')
		}
		
    }
	
	
}
