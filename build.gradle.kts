plugins {
    java
    war
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "com.springboot.test"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security:3.3.0")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.3.0")
//    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.junit.platform:junit-platform-launcher:1.10.2")
    // https://mvnrepository.com/artifact/org.junit.vintage/junit-vintage-engine
    implementation("org.junit.vintage:junit-vintage-engine:5.10.2")
// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.2")
// https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation("org.assertj:assertj-core:3.25.3")

    implementation("org.springframework.boot:spring-boot-autoconfigure:3.3.0")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-autoconfigure-processor
    implementation("org.springframework.boot:spring-boot-autoconfigure-processor:3.3.0")
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-configuration-processor
    implementation("org.springframework.boot:spring-boot-configuration-processor:3.3.0")
// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api
    implementation("io.jsonwebtoken:jjwt-api:0.12.5")
    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")
// https://mvnrepository.com/artifact/com.github.ulisesbocchio/jasypt-spring-boot-starter
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")
// https://mvnrepository.com/artifact/org.bouncycastle/bcprov-jdk15on
    implementation("org.bouncycastle:bcprov-jdk15on:1.70")
// https://mvnrepository.com/artifact/org.bouncycastle/bcpkix-jdk15on
    implementation("org.bouncycastle:bcpkix-jdk15on:1.70")
// https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-catalina-ha
    implementation("org.apache.tomcat:tomcat-catalina-ha:10.1.24")
// https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")




    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
//    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
//    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat:3.3.0")
//    testImplementation("org.springframework.security:spring-security-test")
//    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // https://mvnrepository.com/artifact/junit/junit
    testImplementation("junit:junit:4.13.2")
    // https://mvnrepository.com/artifact/org.dbunit/dbunit
    testImplementation("org.dbunit:dbunit:2.8.0")
}

tasks.withType<Test> {
    exclude("**/**")
}
//tasks.test {
//    exclude("**/**")
//}
//tasks.withType<Test> {
//    useJUnitPlatform()
//}
//exclude
//test {
//    exclude '**/**'
//}