package loginproject

class Stugroup {
	String nom
	static hasMany = [teachers:Teacher, students:Student, questions:Question]
	static belongsTo = Teacher
	
	String toString(){
		return nom
	}
	
    static constraints = {
		teachers (nullable:true)
		students (nullable:true)
		questions (nullable:true)
		
    }
}
