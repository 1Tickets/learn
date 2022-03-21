FROM moxm/java:1.8-full

RUN mkdir -p /tickets-gateway

WORKDIR /tickets-gateway

ARG JAR_FILE=target/tickets-gateway.jar

COPY ${JAR_FILE} app.jar

EXPOSE 9999

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

CMD sleep 60; java -jar app.jar $JAVA_OPTS
