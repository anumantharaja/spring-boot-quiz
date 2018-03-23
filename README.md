# spring-boot-quiz

Start Script
export spring_profiles_active=dev;java -Djava.security.egd=file:/dev/./urandom -jar ./target/demo-0.0.1-SNAPSHOT.jar %1 > log.log 2> err.log

Pre Build
Install redis and mysql
apt-get update; apt-get -y install maven;

Build
mvn install
