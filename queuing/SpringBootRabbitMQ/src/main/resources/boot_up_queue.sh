#!/usr/bin/env bash
docker run -d --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management