import hudson.model.Hudson
import hudson.security.GlobalMatrixAuthorizationStrategy
import hudson.security.ProjectMatrixAuthorizationStrategy



	def authStrategy = Hudson.instance.getAuthorizationStrategy()

	//print (authStrategy)

	
	if(authStrategy instanceof hudson.security.GlobalMatrixAuthorizationStrategy)
	{
		def userMap = [:]
        	def permissions = authStrategy.getGrantedPermissions()
		//print (permissions)
		permissions.each { perm, user_arr ->
			def user = user_arr[0]
			print("KEY: ${perm} -- VAL: ${user}")
			perm_id = perm.getId()
			print("Permission: ${perm_id}")
			if (userMap.containsKey(user))
			{
				userMap[user].add(perm_id)
			}
			else
			{
				userMap[user] = [ perm_id ] as List
			}
		}
		print(userMap)
		writeJSON (file: 'test_users.json', json: userMap, pretty: 4)
	}

