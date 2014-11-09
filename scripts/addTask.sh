#!/bin/bash

curl -H "Content-Type: application/json" -d '{"name":"dothingz","host":"198.162.1.1","status":0,"start":0,"end":0}' http://apaa.mybluemix.net/api/tasks/add
