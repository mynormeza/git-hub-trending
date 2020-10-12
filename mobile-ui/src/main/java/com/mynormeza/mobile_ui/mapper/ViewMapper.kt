package com.mynormeza.mobile_ui.mapper

interface ViewMapper<in P, out V> {

    fun mapToView(type: P): V
}