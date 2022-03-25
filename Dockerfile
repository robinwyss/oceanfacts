FROM openjdk:17-alpine

COPY --from=tfh19986.sprint.dynatracelabs.com/linux/oneagent-codemodules-musl:java / /
ENV LD_PRELOAD /opt/dynatrace/oneagent/agent/lib64/liboneagentproc.so

EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]