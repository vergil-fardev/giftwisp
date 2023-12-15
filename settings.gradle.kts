pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Gift Wisp"
include(":app")
include(":core-libraries:core-test")
include(":core-libraries:core-ui")
include(":core-features:my-list")
include(":core-features:my-groups")
include(":core-features:app-settings")
