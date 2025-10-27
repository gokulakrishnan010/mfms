#!/bin/bash
# vault_init.sh
# creates secret at secret/mfms-local with datasource config

VAULT_ADDR="http://localhost:8200"
VAULT_TOKEN="root"   # change if you use another token

echo "Creating secret: secret/mfms-local"

curl --header "X-Vault-Token: $VAULT_TOKEN" \
     --request POST \
     --data '{
       "data": {
         "spring.datasource.username": "sa",
         "spring.datasource.password": "sa",
         "spring.datasource.url": "jdbc:postgresql://localhost:5432/postgres"
       }
     }' \
     $VAULT_ADDR/v1/secret/data/mfms-local

echo "✅ Secret created successfully!"