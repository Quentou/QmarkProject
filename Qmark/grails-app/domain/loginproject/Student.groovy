package loginproject


class Student extends User {
	Stugroup group;
	static hasMany = [reponses:Answer]
	
	
	def repondrequestion(){
		
	}
	
		
    static constraints = {
		
		reponses (nullable:true)
    }

}
