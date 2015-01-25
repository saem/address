DROP USER IF EXISTS 'address';
CREATE USER address WITH PASSWORD 'address';
DROP DATABASE IF EXISTS "address";
CREATE DATABASE "address"
  WITH OWNER "address"
  ENCODING 'UTF8'
  LC_COLLATE = 'en_US.UTF-8'
  LC_CTYPE = 'en_US.UTF-8'
  TEMPLATE = template0;
GRANT ALL PRIVILEGES ON DATABASE "address" to address;