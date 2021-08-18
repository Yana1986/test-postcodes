DROP TABLE IF EXISTS area;

CREATE TABLE area (
                      postcode VARCHAR(4) NOT NULL,
                      name VARCHAR(100) NOT NULL,
                      PRIMARY KEY(postcode, name)
);

CREATE INDEX IDXPOSTCODE ON area(postcode);
