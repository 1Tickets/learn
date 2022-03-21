FROM mysql:8.0.27

MAINTAINER lengleng(wangiegie@gmail.com)

ENV TZ=Asia/Shanghai

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./tickets.sql /docker-entrypoint-initdb.d

COPY ./tickets_codegen.sql /docker-entrypoint-initdb.d

COPY ./tickets_config.sql /docker-entrypoint-initdb.d

COPY ./tickets_job.sql /docker-entrypoint-initdb.d
