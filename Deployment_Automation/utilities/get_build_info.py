import urllib.request
import base64
import json

def stringToBase64(s):
	return base64.b64encode(s.encode('utf-8'))
def base64ToString(b):
	return base64.b64decode(b).decode('utf-8')


build_url = 'http://10.0.0.111:8082/job/Test/3/api/json/'
user='antman'
apiToken='1175fb87946a6df9b69b1417d74d40d952'

req = urllib.request.Request(build_url)

auth = "%s:%s" % (user,apiToken)
b64auth = stringToBase64(auth)
#print (b64auth)
#print (b64auth.decode('utf-8'))
req.add_header('Authorization', 'Basic %s' % b64auth.decode('utf-8'))
# Customize the default User-Agent header value:
#req.add_header('User-Agent', 'urllib-example/0.1 (Contact: . . .)')
r = urllib.request.urlopen(req)
resp = r.read().decode('utf-8')
#print (resp)
resp_json = json.loads(resp)

dur = resp_json['duration'] / 1000.000 / 60.0
print ('Build User: %s' % resp_json['actions'][0]['causes'][0]['userName'])
print ('Build Duration: %s mins' % str(dur))

#for key in resp_json:
#	print ('key: %s' % key)
#	print (resp_json[key])
