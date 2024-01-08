FROM bitnami/java:17

WORKDIR /orders
COPY /orders .

ADD /orders/pom.xml .

RUN apt update && \
    apt install maven -y

EXPOSE 3333
CMD [ "mvn", "install"]