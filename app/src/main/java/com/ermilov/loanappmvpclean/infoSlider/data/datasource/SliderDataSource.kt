package com.ermilov.loanappmvpclean.infoSlider.data.datasource

import com.ermilov.loanappmvpclean.infoSlider.data.model.InfoSliderModel
import com.ermilov.loanappmvpclean.infoSlider.data.recycleradapter.InfoSliderAdapter
import io.reactivex.Single

interface SliderDataSource {
    fun slider(sliderList: ArrayList<InfoSliderModel>): InfoSliderAdapter
}