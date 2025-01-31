import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    id("io.freefair.lombok") version ("8.11")
    id("io.qameta.allure") version ("2.12.0")
}

allure {
    report {
        version.set("2.29.0")
    }
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.29.0")
            }
        }
    }
}

group = "guru.qa"
repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("io.appium:java-client:9.3.0")

    testImplementation("com.codeborne:selenide:7.5.1")
    testImplementation("io.qameta.allure:allure-selenide:2.29.0")

    testImplementation("io.rest-assured:rest-assured:5.5.0")
    testImplementation("org.assertj:assertj-core:3.26.3")
    testImplementation("org.aeonbits.owner:owner:1.0.12")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    systemProperties(
        System.getProperties()
            .mapKeys { it.key.toString() }
            .mapValues { it.value?.toString() ?: "" }
    )
    useJUnitPlatform {
        System.getProperty("includeTags")?.let {
            includeTags(it)
        }
    }

    testLogging {
        lifecycle {
            events = setOf(
                TestLogEvent.STARTED, TestLogEvent.SKIPPED, TestLogEvent.FAILED,
                TestLogEvent.STANDARD_ERROR, TestLogEvent.STANDARD_OUT
            )
            exceptionFormat = TestExceptionFormat.SHORT
        }
    }
}