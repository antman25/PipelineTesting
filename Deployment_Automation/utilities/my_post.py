#!/usr/bin/python3 
import urllib.request
import json
import time

base_mm_url = 'http://10.0.0.111:8065'
login_url = '/api/v4/users/login'
me_url = '/api/v4/users/me'
posts_url = '/api/v4/posts'
chan_url = '/api/v4/channels'

user='antbot'
token='eynd1y5shjn33qemr74ax91s8o'
team_id = '1ybpkrpqxjfwjmrnduqerxocsa'
channel_id = 'iuyc3e6jrpbp5nyx6wpzryy8ja'



post_data = { 'channel_id' : channel_id,
	      'message' : 'test'
	    }

params = json.dumps(post_data).encode('utf-8')


req = urllib.request.Request(base_mm_url + posts_url,params)
req.add_header('Authorization', 'Bearer %s' % token)
req.add_header('content-type', 'application/json')



r = urllib.request.urlopen(req)
print("Code %s" % str(r.getcode()))
resp = r.read().decode('utf-8')
#print (resp)
resp_json = json.loads(resp)
print (resp_json)

print ('-------------------------')

post_id = resp_json['id']
print ('post id: %s' % post_id)

time.sleep(5.0)

post_data2 = { 	'id' : post_id,
              	'message' : 'test2'
            }

params2 = json.dumps(post_data2).encode('utf-8')
print('PARAMS2: %s' % str(params2))
req2_url = base_mm_url + posts_url + '/' + post_id
print ('req2 = %s' % req2_url)
req2 = urllib.request.Request(url=req2_url,data=params2,method='PUT')
req2.add_header('Authorization', 'Bearer %s' % token)
req2.add_header('content-type', 'application/json')

r2 = urllib.request.urlopen(req2)
print("Code %s" % str(r2.getcode()))
resp2 = r2.read().decode('utf-8')
#print (resp)
resp_json2 = json.loads(resp2)
print (resp_json2)

