plugins {
    id("java")
    alias(libs.plugins.kotlin)
    alias(libs.plugins.intellijPlatform)
}

group = "com.github.zacharygurion.customhighlights"
version = "1.0.0"

// Set the JVM language level used to build the project.
kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    intellijPlatform {
        intellijIdea(providers.gradleProperty("platformVersion"))
        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)

        // Kotlin plugin needed for compiling KotlinKeywordAnnotator (uses KtTokens).
        // Java plugin not needed: annotators use only platform's LeafPsiElement.
        bundledPlugin("org.jetbrains.kotlin")
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = providers.gradleProperty("pluginSinceBuild")
        }

        changeNotes = """
            1.0.0 — Initial release.
            Adds color-scheme customization for control-flow, type/declaration, and access/visibility
            keywords across Java, Kotlin, Python, JavaScript, TypeScript, Go, Rust, C, C++, C#,
            Groovy, Scala, PHP, Dart, and SQL.
        """.trimIndent()
    }
}

tasks {
    wrapper {
        gradleVersion = providers.gradleProperty("gradleVersion").get()
    }
}
