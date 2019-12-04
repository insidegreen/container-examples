FROM openjdk:11

RUN curl -sL https://deb.nodesource.com/setup_8.x | bash -
RUN apt-get install -y nodejs

RUN cd /opt && curl http://www-eu.apache.org/dist/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz | tar xvz

ENV M2_HOME=/opt/apache-maven-3.5.4
ENV PATH=$JAVA_HOME/bin:${M2_HOME}/bin:${PATH}