#!/usr/bin/env bash
set -e

echo "Creating new directory structure..."

# Create new folders for the reorganization
mkdir -p web/mvc
mkdir -p web/web-api
mkdir -p messaging

echo "New directories created."

# Move MVC projects into web/mvc
if [ -d "mvc" ]; then
  echo "Moving MVC projects to web/mvc..."
  # Move all items from the old mvc folder to web/mvc
  mv mvc/* web/mvc/
  # Remove the old mvc folder if it’s empty
  rmdir mvc
fi

# Move Web API projects into web/web-api
if [ -d "web-api" ]; then
  echo "Moving Web API projects to web/web-api..."
  mv web-api/* web/web-api/
  rmdir web-api
fi

# Move the queuing project into messaging
if [ -d "queuing" ]; then
  echo "Moving queuing projects to messaging..."
  mv queuing/* messaging/
  rmdir queuing
fi

echo "Reorganization complete."
