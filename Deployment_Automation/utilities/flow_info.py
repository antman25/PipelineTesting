#!/usr/bin/python3

import json

with open('host_info.json') as f:
	data = json.load(f)

flow_def = data['flow_definition']
#print (flow_def)
for flow_name in flow_def:
	steps = flow_def[flow_name]
	print("Flow Name: %s - Total Steps %i" % (flow_name, len(steps)))
	#print("\tNum Steps = %i" % len(steps))
	for i in range(len(steps)):
		cur_step = steps[i]
		#print (cur_step)
		step_id = cur_step['step_id']
		jenkinsfile_loc = cur_step['jenkinsfile_location']
		params = cur_step['params']
		print ("\tCurrent Step ID: %s" % step_id)
		print ("\tJenkinsfile: %s" % jenkinsfile_loc)
		print ("\t----Params----")
		for j in range(len(params)):
			cur_param = params[j]
			param_name = cur_param['param_name']
			param_type = cur_param['param_type']
			param_desc = cur_param['param_desc']
			print ("\t\tName: %s - Type %s - Desc %s" % (param_name,param_type,param_desc))
		print('')
	#print(steps)
	
