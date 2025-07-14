package org.project.demo.expect

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModules: Module = module {
    single<HttpClientEngine> {
        Darwin.create {
            configureRequest {
                setAllowsCellularAccess(true)
                //usePreconfiguredSession(createCustomNSURLSession())
            }
        }
    }
}