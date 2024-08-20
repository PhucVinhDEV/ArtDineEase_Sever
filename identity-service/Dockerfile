# Bước 1: Sử dụng một image Maven chính thức để build ứng dụng
FROM maven:3.8.5-openjdk-17 AS build

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng bằng Maven
RUN mvn clean package

# Bước 2: Sử dụng một image JDK nhẹ để chạy ứng dụng
FROM openjdk:17-jdk-slim

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Sao chép tệp JAR từ quá trình build sang container mới
COPY --from=build /app/target/identity-service-0.0.1-SNAPSHOT.jar /app/identity-service.jar

# Khởi chạy ứng dụng
CMD ["java", "-jar", "/app/identity-service.jar"]
