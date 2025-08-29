import java.util.Properties

val localProps = Properties().apply {
    val propsFile = rootProject.file("local.properties")
    if (propsFile.exists()) {
        propsFile.inputStream().use { load(it) }
    }
}

tasks.register("printLocalProps") {
    doLast {
        println("API_KEY=" + (localProps.getProperty("API_KEY") ?: "undefined"))
    }
}
