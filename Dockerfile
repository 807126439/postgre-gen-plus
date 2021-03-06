FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER River.lu@newtype.io

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /pigx-codegen

WORKDIR /pigx-codegen

EXPOSE 5003

ADD ./pigx-visual/pigx-codegen/target/pigx-codegen.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar pigx-codegen.jar
