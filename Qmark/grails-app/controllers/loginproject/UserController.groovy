package loginproject
//http://fr.slideshare.net/nadouani/grails-un-framework-web-agile-3138291
class UserController {
	def scaffold = User
	def indexuser() { }
	def indexstudent() { 
		
		def userInstance = User.get(params.id)
		
		[userInstance:userInstance]
		
		
		
		
		
	}
	def indexteacher() {
		
		def userInstance = User.get(params.id)
		
		def questionInstanceList = Question.list(sort:"dateQuestionPose",order:"desc")
		
		def reponseInstanceList = Answer.getAll()
		
		
		
		[userInstance:userInstance, questionInstanceList:questionInstanceList,reponseInstanceList:reponseInstanceList,params:params]
		
		
	}
	
	def login ={
		

		

		//si un User a le bon userName et password, ça marche
		for(int i=1;i<=User.count();i++){
			
			if(params.username == User.get(i).getProperty("firstName") && params.password == User.get(i).getProperty("password")){
				flash.message = "login succed"
				if(User.get(i).getClass().toString()=="class loginproject.Student"){
					session.user = "Student"
					params.id=User.get(i).getProperty("id")
					
					
					
					redirect(action:'indexstudent',params: params)
				}
				else if(User.get(i).getClass().toString()=="class loginproject.Teacher"){
					session.user = "Teacher"
					params.id=User.get(i).getProperty("id")
					
					[params : params]
					
					redirect(action:'indexteacher',params: params)
				}
				
				else{
					session.user = "user"
					redirect(action:'indexuser')
				}

			}
		}
		//sinon ça marche pas
		render "login failed"


	}

	def logout ={
		session.user = null
		redirect(action: '../')


	}
	
		def latestsNews = {
		    println "in controller"
		}
}
