plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
}

group = "cn.eziosweet"
version = "1.0-SNAPSHOT"

repositories {
    maven{
        url = uri("https://maven.aliyun.com/repository/public")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.github.kittinunf.fuel:fuel:3.0.0-alpha03")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}