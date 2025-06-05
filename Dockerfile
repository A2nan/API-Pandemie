FROM maven:3.8.5-openjdk-17

WORKDIR /app
COPY . .

# Compile le projet (et télécharge les dépendances dans le cache Maven local)
RUN mvn clean compile dependency:copy-dependencies

# Lancer la classe principale directement
CMD ["java", "-cp", "target/classes:target/dependency/*", "dev.epsi.MSPR.MsprApplication"]
