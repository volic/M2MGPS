DROP DATABASE IF EXISTS m2mgps;

CREATE DATABASE m2mgps DEFAULT CHARACTER SET 'utf8';

USE m2mgps;

CREATE TABLE gpsdata (
  id BIGINT NOT NULL AUTO_INCREMENT,
  tracks_id BIGINT NULL,
  transports_id BIGINT NOT NULL,
  x DOUBLE NULL,
  y DOUBLE NULL,
  z DOUBLE NULL,
  time TIME NULL,
  del BOOL NULL,
  PRIMARY KEY(id),
  INDEX gpsdata_FKIndex1(transports_id),
  INDEX gpsdata_FKIndex2(tracks_id)
);

CREATE TABLE tracks (
  id BIGINT NOT NULL AUTO_INCREMENT,
  transports_id BIGINT NOT NULL,
  name VARCHAR(255) NULL,
  duration INTEGER UNSIGNED NULL,
  del BOOL NULL,
  PRIMARY KEY(id),
  INDEX tracks_FKIndex1(transports_id)
);

CREATE TABLE transports (
  id BIGINT NOT NULL AUTO_INCREMENT,
  users_id BIGINT NULL,
  imei VARCHAR(30) NULL,
  name VARCHAR(255) NULL,
  del BOOL NULL,
  PRIMARY KEY(id),
  INDEX transports_FKIndex1(users_id)
);

CREATE TABLE users (
  id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NULL,
  last_name VARCHAR(255) NULL,
  email VARCHAR(255) NULL,
  user_password VARCHAR(32) NULL,
  del BOOL NULL,
  login VARCHAR(255) NULL,
  PRIMARY KEY(id)
);

