DROP USER if exists 'techbooks'@'%' ;

CREATE USER 'techbooks'@'%' IDENTIFIED BY 'techbooks';

GRANT ALL PRIVILEGES ON * . * TO 'techbooks'@'%';
