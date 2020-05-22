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
			perm_id = perm.getId()
			print("Permission: ${perm_id}")
			if (userMap.containsKey(user))
			{
				userMap.add(perm_id)
			}
			else
			{
				userMap[user] = [ perm_id ]
			}
		}
		print(userMap)
	}
}

return this

