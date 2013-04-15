package loginproject

class Stugroup {
	String nom
	static hasMany = [teachers:Teacher, students:Student]
	static belongsTo = Teacher
	
    static constraints = {
    }
}
