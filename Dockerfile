FROM tomcat:9-alpine

ADD target/springweb-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080
