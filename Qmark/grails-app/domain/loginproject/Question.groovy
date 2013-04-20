package loginproject

class Question {
	int id
	Stugroup group
	String question
	String type
	String createur
	
	String toString(){
		return question
	}
	
    static constraints = {
		group (nullable:false)
		type (nullable:true)
		id blank: false, unique:true
		createur (nullable:false)
		
    }
}
