# Imagen base de Java
FROM eclipse-temurin:17-jdk

# Crear directorio de la app
WORKDIR /app

# Copiar archivos del proyecto
COPY . /app

# Asignar permisos de ejecución a mvnw
RUN chmod +x mvnw

# Construir el proyecto
RUN ./mvnw -B -DskipTests clean install

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "target/*.jar"]
