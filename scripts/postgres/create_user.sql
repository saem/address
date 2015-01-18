DROP USER IF EXISTS 'address';
CREATE USER address WITH PASSWORD 'address';
GRANT ALL PRIVILEGES ON DATABASE "address" to address;