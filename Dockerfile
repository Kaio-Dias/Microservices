FROM bitnami/java:17

WORKDIR /payments
COPY /payments .

ADD /payments/pom.xml .

RUN apt update && \
    apt install maven -y

EXPOSE 3333
CMD [ "mvn", "install"]