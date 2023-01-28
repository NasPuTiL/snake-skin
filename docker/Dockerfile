FROM openjdk:8-jdk-alpine

# Ustawienie zmiennych środowiskowych
ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH


RUN adduser -D -s /bin/sh tomcat


RUN wget -q https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.57/bin/apache-tomcat-8.5.57.tar.gz && \
    tar xvfz apache-tomcat-8.5.57.tar.gz && \
    rm apache-tomcat-8.5.57.tar.gz && \
    mv apache-tomcat-8.5.57 $CATALINA_HOME && \
    chown -R tomcat:tomcat $CATALINA_HOME


ADD ./war/skin-snake.war $CATALINA_HOME/webapps/


USER tomcat


CMD ["catalina.sh", "run"]