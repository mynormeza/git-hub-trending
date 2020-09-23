package com.mynormeza.cache.mapper

interface CacheMapper<C, E> {

    fun mapFromCache(type: C): E

    fun mapToCache(type: E): C
}