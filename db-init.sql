-- 1) Create login role if missing
DO $$
    BEGIN
        IF NOT EXISTS (SELECT FROM pg_roles WHERE rolname = 'mfms') THEN
            CREATE ROLE mfms WITH LOGIN PASSWORD 'mfms';
        END IF;
    END
$$;

-- 2) Create database if missing (Postgres way, using \gexec)
SELECT 'CREATE DATABASE mfms OWNER mfms'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'mfms')
\gexec

-- 3) Work inside that DB
\c mfms

-- 4) App schema + grants (safe to re-run)
CREATE SCHEMA IF NOT EXISTS mfms AUTHORIZATION mfms;
GRANT ALL ON SCHEMA mfms TO mfms;

-- 5) Role defaults
ALTER ROLE mfms SET search_path TO mfms, public;

