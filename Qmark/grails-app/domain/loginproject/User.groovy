package loginproject

class User {

    int id
	String firstName
	String lastName
	String email
	String password
	
	String toString() {
		id + ":" + " " + firstName + " " + lastName
	}
	
	def voiranciennesrep(student){
		 def rep = Answer.findByStudent(student)
		 if (!rep){
			 "Pas de réponses"
		 }
		 else {
		rep.toString()
		 }
		 
	}
	
    static constraints = {
		id blank: false, unique:true
		firstName blank: false , nullable:false
		lastName blank: false , nullable:false
		email blank: false, unique: true, email: true, nullable:false
		password blank: false, password: true, nullable:false
    }
}
