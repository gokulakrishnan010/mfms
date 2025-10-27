# ---- build ----
FROM eclipse-temurin:25-jdk AS build
WORKDIR /src
COPY . .
RUN ./gradlew bootJar -x test

# ---- run ----
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /src/build/libs/*-SNAPSHOT.jar /app/app.jar
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v2.9.0/opentelemetry-javaagent.jar /app/opentelemetry-javaagent.jar

ENV JAVA_TOOL_OPTIONS=" -javaagent:/app/opentelemetry-javaagent.jar -Dotel.service.name=mfms -Dotel.exporter.otlp.endpoint=http://otel-collector:4318 -Dotel.exporter.otlp.protocol=http/protobuf -Dotel.traces.exporter=otlp -Dotel.metrics.exporter=otlp -Dotel.logs.exporter=otlp -Dotel.instrumentation.logback-appender.enabled=true -Dotel.resource.attributes=deployment.environment=local "

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
