package loginproject


class Teacher extends User {
	static hasMany = [stugroups:Stugroup]
	
    static constraints = {
		stugroups (nullable:true)
    }
}
