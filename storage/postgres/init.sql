--
--  projuris Test
--  Script Initialize Database
--

CREATE EXTENSION IF NOT EXISTS dblink;

DO
$do$
BEGIN
    -- DATABASE: projuris_order_db/projuris-order-schem
    IF EXISTS (SELECT 1 FROM pg_database WHERE datname = 'projuris_order_db') THEN
        RAISE NOTICE 'Database "projuris_order_db" already exists'; 
    ELSE
        -- DATABASE
        PERFORM dblink_exec('dbname=' || current_database(), 'CREATE DATABASE "projuris_order_db"');
        -- SCHEMA
        PERFORM dblink_exec('dbname=projuris_order_db', 'CREATE SCHEMA IF NOT EXISTS "projuris_order_schem"');
    END IF;
END
$do$;