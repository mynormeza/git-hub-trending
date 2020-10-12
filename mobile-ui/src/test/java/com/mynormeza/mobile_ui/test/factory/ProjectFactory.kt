package com.mynormeza.mobile_ui.test.factory

import com.mynormeza.presentation.model.ProjectView

object ProjectFactory {

    fun makeProjectView(): ProjectView {
        return ProjectView(DataFactory.randomUuid(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomBoolean())
    }

}