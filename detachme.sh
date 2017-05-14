#!/bin/bash
# 
# Author : Saif Asif
# detachers.sh : Utility to detach a script from the code base
# usage : curl -s -L https://raw.githubusercontent.com/MSaifAsif/sample-skeleton-projects/master/detachers/detachme.sh | bash -s <module_name> <target_directory> 
#    <module_name> : The name of the module to extract, this should exactly match the directory name of original modules in the code base
#    <target_directory> : Destination directory where to place the extracted out module
# version: 1.0.0
# 
# best to do it in tmp folder
tmp='/tmp/sample-skeleton-projects'
codebase='https://github.com/MSaifAsif/sample-skeleton-projects.git'

echo 'Detacher called with following params: ' $1 ', ' $2

# First fetch the project into temp directory
echo 'Fetching project code base...'
git clone $codebase $tmp

# Grab the module directory and push it out, 
# making sure that dir does not pre-exist
cd $tmp
rm -rf ../$1
echo 'Extracting out module ' $1
mv $1 ../
cd ..  # get back to the original directory

# goto the extracted module and fix the pom,
# and move project to destination directory
cd $1
mv standalone-pom.xml pom.xml
cd ..
echo 'moving to ' $2 
mv $1 $2

# build the project to see if everything is fine
cd $2/$1
mvn clean install

# cleanups
rm -rf $tmp
