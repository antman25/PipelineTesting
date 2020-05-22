import hudson.model.Hudson
import hudson.security.GlobalMatrixAuthorizationStrategy
import hudson.security.ProjectMatrixAuthorizationStrategy



def getAuth()
{
	def authStrategy = Hudson.instance.getAuthorizationStrategy()

	//print (authStrategy)

	
	if(authStrategy instanceof hudson.security.GlobalMatrixAuthorizationStrategy)
	{
		def userMap = [:]
        	def permissions = authStrategy.getGrantedPermissions()
		//print (permissions)
		permissions.each { perm, user ->
			print("KEY: ${perm} -- VAL: ${user}")
			perm_id = perm.getID()
			print("Permission: ${perm_id}")
			if (userMap.containsKey(perm_id))
			{
				userMap.add(perm_id)
			}
			else
			{
				userMap[perm_id] = [ user ]
			}
		}
		print(userMap)
	}
}

return this

