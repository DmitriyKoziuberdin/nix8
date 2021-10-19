@echo off
call ../mvnw clean package
call java -jar target/hw_1_base_operations-1.0-SNAPSHOT.jar