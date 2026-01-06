plugins {
    id("java-platform")
    id("maven-publish")
}

repositories {
    mavenCentral()
}

javaPlatform {
    allowDependencies()
}

var ryplatLibs = arrayOf(rootProject)
var ryplatPlugins = arrayOf<Project>()

for (p in rootProject.childProjects) {
    if (p.key == "examples" || p.key == project.name) {
        continue
    }
    var children = p.value.childProjects
    if (children.isEmpty()) {
        ryplatLibs += p.value
        continue
    }
    if (p.key == "plugins") {
        children.forEach { (_, p) -> ryplatPlugins += p }
    } else {
        children.forEach { (_, p) -> ryplatLibs += p }
    }
}

println("使用中的框架依赖 ${ryplatLibs.size} 个")
println("使用中的框架插件 ${ryplatPlugins.size} 个")

dependencies {
    api(platform("org.junit:junit-bom:5.10.0"))

    api("io.vertx:vertx-core:5.0.6")
    api("io.vertx:vertx-web:5.0.6")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            pom.withXml {
                asNode().appendNode("dependencyManagement").appendNode("dependencies").apply {
                    project.configurations.forEach { conf ->
                        conf.dependencies.forEach { dep ->
                            appendNode("dependency").apply {
                                appendNode("groupId", dep.group)
                                appendNode("artifactId", dep.name)
                                appendNode("version", dep.version)
                                if(dep is HasAttributes) {
                                    val cate = dep.attributes.getAttribute(Category.CATEGORY_ATTRIBUTE)
                                    if (cate?.name == Category.REGULAR_PLATFORM || cate?.name == Category.ENFORCED_PLATFORM) {
                                        appendNode("scope", "import")
                                        appendNode("type", "pom")
                                    }
                                }
                            }
                        }
                    }
                    ryplatLibs.forEach {
                        appendNode("dependency").apply {
                            appendNode("groupId", it.group)
                            appendNode("artifactId", it.name)
                            appendNode("version", it.version)
                        }
                    }
                }
            }
        }
    }
}