package org.project.demo.expect

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/**
 * Created by taieb.slama on 14/07/2025 .
 * Copyright (c) 2023. All rights reserved.
 */
expect val platformModules: Module
val helpersModule: Module = module {
    single {
        HttpClient(get()) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 20 * 1000
                socketTimeoutMillis = 20 * 1000
                connectTimeoutMillis = 20 * 1000
            }

        }
    }
}
val repositoriesModule: Module = module {}
val managersModule: Module = module {}
val viewModelsModule: Module = module {}


fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            platformModules,
            helpersModule,
            repositoriesModule,
            managersModule,
            viewModelsModule
        )
    }
}
