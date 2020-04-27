#!/usr/bin/python3

import sys

print ("------------------------")

output_file = open('/tmp/test', 'w')

for arg in sys.argv:
	print ("ARG %s" % arg)
	output_file.write(arg + "\n")
output_file.close()

print ("------------------------")
