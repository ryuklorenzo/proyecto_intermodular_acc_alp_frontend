package acc.alp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform