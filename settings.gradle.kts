dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "PacketEvents"
include("api")
include("netty-common")
// Platform modules
include("spigot")
include("bungeecord")
include("velocity")
// Patch modules
include(":patch:adventure-text-serializer-gson")
