CREATE TABLE permission (
  id bigint NOT NULL AUTO_INCREMENT,
  name varchar(60) NOT NULL UNIQUE,
  created_on datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_on datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  version bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

INSERT INTO permission VALUES
(1,'can_delete_user','1970-01-01 00:00:00','1970-01-01 00:00:00',0),
(2,'can_create_user','1970-01-01 00:00:00','1970-01-01 00:00:00',0),
(3,'can_update_user','1970-01-01 00:00:00','1970-01-01 00:00:00',0),
(4,'can_read_user','1970-01-01 00:00:00','1970-01-01 00:00:00',0);

