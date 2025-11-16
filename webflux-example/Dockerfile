
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app


COPY gradle gradle
COPY gradlew .
COPY settings.gradle.kts .
COPY build.gradle.kts .


RUN ./gradlew dependencies --no-daemon || true


COPY . .


RUN ./gradlew clean bootJar --no-daemon


FROM eclipse-temurin:21-jre


RUN addgroup --system app && adduser --system --ingroup app app
USER app

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
