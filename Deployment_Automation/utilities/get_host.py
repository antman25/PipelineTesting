#!/usr/bin/python3

import json


class HostInfo(object):
	def __init__(self, config_path):
		with open(config_path) as f:
			self.config_json = json.load(f)
		#print("Loaded JSON")
		#print(self.config_json)

	def getHost(self, env, host_type):
		if env in self.config_json:
			#print("Found Env")
			if host_type in self.config_json[env]:
				return self.config_json[env][host_type]
		return "UNKNOWN"


#with open('host_info.json') as f:
#	data = json.load(f)



#print (data)
#for env in data:
#	print ('Env: %s' % env)

if __name__ == '__main__':
	host_info = HostInfo('host_info.json')
	print(host_info.getHost('env1','type_b2'))
	#host_info
