package loginproject

class Question {
	int id
	Stugroup group
	String question
	String type
	String createur
	def reponsesQCM
	
	String toString(){
		return question
	}
	
	def addReponse(String s){
		reponsesQCM.add(s)
	}
	
	
    static constraints = {
		reponsesQCM (nullable:true)
		group (nullable:false)
		type nullable:true,inlist:["QCM","Libre"]
		id blank: false, unique:true
		createur (nullable:false)
	
		
		
    }
}
