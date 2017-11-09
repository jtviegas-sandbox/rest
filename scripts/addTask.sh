#!/bin/bash

curl -H "Content-Type: application/json" -d '{"name":"dothingz","host":"198.162.1.1","status":0,"start":12.6,"end":34.7}' http://apaa.mybluemix.net/api/tasks/add
