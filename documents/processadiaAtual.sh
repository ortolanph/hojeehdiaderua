#!/usr/bin/env bash

curl --cookie-jar cookie -L http://localhost:9090/admin/processaDiaAtual

TOKEN=$( cat cookie | grep 'XSRF' | cut -f7 )

curl --cookie cookie -u admin:admin -d "_csrf=$TOKEN" -L http://localhost:9090/admin/processaDiaAtual
