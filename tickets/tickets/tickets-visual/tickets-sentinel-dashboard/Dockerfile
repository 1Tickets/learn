FROM moxm/java:1.8-full

RUN mkdir -p /tickets-sentinel-dashboard

WORKDIR /tickets-sentinel-dashboard

ARG JAR_FILE=target/tickets-sentinel-dashboard.jar

COPY ${JAR_FILE} app.jar

EXPOSE 5003

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

CMD sleep 60; java -jar app.jar $JAVA_OPTS
