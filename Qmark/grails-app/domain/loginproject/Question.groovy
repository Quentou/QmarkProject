package loginproject

class Question {
	int id
	Stugroup group
	String question
	String type
	String createur
	def reponsesQCM = []
	
	String toString(){
		return question
	}
	
	def addReponsesQcm(String rep){
		reponsesQCM.add(rep)
		
	}
	
    static constraints = {
		reponsesQCM (nullable:true)
		group (nullable:false)
		type (nullable:true)
		id blank: false, unique:true
		createur (nullable:false)
		
    }
}
