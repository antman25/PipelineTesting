import hudson.model.Hudson
import hudson.security.GlobalMatrixAuthorizationStrategy
import hudson.security.ProjectMatrixAuthorizationStrategy



def getAuth()
{
	def authStrategy = Hudson.instance.getAuthorizationStrategy()

	//print (authStrategy)

	
	if(authStrategy instanceof hudson.security.GlobalMatrixAuthorizationStrategy)
	{
        	def permissions = authStrategy.getGrantedPermissions()
	   //print (permissions)
		permissions.each { key, val ->
			print("KEY: ${key} -- VAL: ${val}")
	}
}

return this

