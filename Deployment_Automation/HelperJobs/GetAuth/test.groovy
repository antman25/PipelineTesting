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
		permissions.each { perm_key, val ->
			print("KEY: ${perm_key} -- VAL: ${val}")
			print(perm_key.getId())
		}
	}
}

return this

