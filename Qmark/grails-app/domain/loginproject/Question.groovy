package loginproject

class Question {
	int id
	Stugroup group
	String question
	String type
	
	String toString(){
		return question
	}
	
    static constraints = {
    }
}
