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
	
}
