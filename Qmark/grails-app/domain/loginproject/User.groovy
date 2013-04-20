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
			 "Pas de r�ponses"
		 }
		 else {
		rep.toString()
		 }
		 
	}
	
    static constraints = {
		id blank: false, unique:true
		firstName blank: false
		lastName blank: false
		email blank: false, unique: true, email: true
		password blank: false, password: true
    }
}
