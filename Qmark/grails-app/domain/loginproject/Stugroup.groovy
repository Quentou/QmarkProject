package loginproject

class Stugroup {
	String nom
	static hasMany = [teachers:Teacher, students:Student, questions:Question]
	static belongsTo = Teacher
	
    static constraints = {
    }
}
