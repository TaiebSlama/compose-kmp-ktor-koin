package org.project.demo.expect

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModules: Module = module {

    single<HttpClientEngine> {
        val engine = OkHttp.create {}
        engine
    }

}