# Author: iAM9
# Nov 21, 2015
# Automates the process of detaching a submodule from the parent project.
# The detached project is placed at the home directory.


#
# Usage: [~]$ python detach.py AppletHelloWorld
#


#!/usr/bin/env python

import sys
import os
import shutil
import re

# List of lines to be deleted from 'pom.xml'
linDel = [
    '<parent>',
    '<artifactId>sample-skeleton-projects</artifactId>',
    '</parent>'
]

# Get directory name
directoryName = sys.argv[1]

# Get absoulute path of the directory
absPath = os.path.abspath(directoryName)

# Get target path i.e. home directory
targetPath = os.path.expanduser('~') + "/"

# Get final destination path
finalPath = targetPath + directoryName + "/"
print "Destination path: " + finalPath

# Copy directory from its path to destination i.e. directory path to home folder
shutil.copytree(absPath, finalPath)


# Open "pom.xml" for reading
openXML = open(finalPath + "pom.xml", 'r')

# Read all lines from file
lines = openXML.readlines()

# Close the file
openXML.close()

# Reopen file, clearing its contents
openXML = open(finalPath + "pom.xml", 'w')

# Read from 'lines' and write them one by one into the new 'pom.xml'
for ls in lines:

    # Determine whether ls is in linDel
    for ld in linDel:
        match = re.search(ld, ls)

        # if match is True, write an empty line
        if match:
            print "Disengaging........"
            openXML.write(" ")

            # and break the loop
            break

        # otherwise, continue checking with other elements of linDel
        else:
            continue

    # If a match was made previously, continue with the loop
    if match:
        continue

    # Otherwise, write normally
    else:
        openXML.write(ls)


# Close the file and free up resources
openXML.close()
print "Done!"

