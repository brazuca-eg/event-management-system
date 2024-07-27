CREATE TABLE IF NOT exists events (
    id VARCHAR(64) PRIMARY KEY,
    host_id VARCHAR(64) NOT NULL,
    name VARCHAR(128) NOT NULL,
    description TEXT,
    start_date TIMESTAMP,
    duration INT,
    places INT,
    price DECIMAL(10, 2),
    platform VARCHAR(128),
    link_to_event VARCHAR(1024)
);

CREATE INDEX IF NOT EXISTS idx_host_id ON events (host_id);