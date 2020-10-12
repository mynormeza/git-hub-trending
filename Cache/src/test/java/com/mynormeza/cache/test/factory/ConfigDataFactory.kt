package com.mynormeza.cache.test.factory

import com.mynormeza.cache.model.Config

object ConfigDataFactory {

    fun makeCachedConfig(): Config {
        return Config(DataFactory.randomInt(), DataFactory.randomLong())
    }

}