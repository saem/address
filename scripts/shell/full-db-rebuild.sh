#!/bin/sh
cd ~/opus/address
mvn clean && mvn package
sudo su -c "psql -c \"DROP DATABASE IF EXISTS \"address\"\"" - postgres
sudo su -c "psql -c \"DROP USER IF EXISTS \"address\"\"" - postgres
sudo su -c "psql -c \"CREATE USER address WITH PASSWORD 'address'\"" - postgres
sudo su -c "psql -c \"CREATE DATABASE \"address\" WITH OWNER \"address\" ENCODING 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8' TEMPLATE = template0\"" - postgres
sudo su -c "psql -c \"GRANT ALL PRIVILEGES ON DATABASE \"address\" to address\"" - postgres
java -jar target/address-0.1.jar db migrate dev.yml
