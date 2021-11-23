@echo off
call ../mvnw clean package
call java -jar target/*.jar