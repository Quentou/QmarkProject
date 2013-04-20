package loginproject

class Answer {
	int id
	String reponse
	Student student
	Question question

	String toString() {
		reponse
	}

	def voirreponse(){
	}
	static constraints = {
		id blank: false, unique:true
		reponse (nullable:false)
		student (nullable:false)
		question (nullable:false)
		
	}
}
