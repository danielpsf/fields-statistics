#!/bin/bash

echo "================== Container environment variables =================="
echo "DB_URL = $DB_URL"
echo "DB_USER = $DB_USER"
echo "DB_PASSWORD = $DB_PASSWORD"
echo "HIBERNATE_DDL_AUTO = $HIBERNATE_DDL_AUTO"
echo "SHOW_SQL = $SHOW_SQL"
echo "JAVA_OPTS = $JAVA_OPTS"
java -jar $1 --spring.datasource.url=$DB_URL \
             --spring.datasource.username=$DB_USER \
             --spring.datasource.password=$DB_PASSWORD \
             --spring.jpa.hibernate.ddl-auto=$HIBERNATE_DDL_AUTO \
             --spring.jpa.show-sql=$SHOW_SQL
