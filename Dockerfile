FROM eclipse-temurin:17-jre-focal
ENV TZ=Asia/Seoul
COPY ./build/libs/*.jar ./app.jar
ENTRYPOINT ["java","-jar","./app.jar"]