package com.ermilov.loanappmvpclean.infoSlider.data.datasource


import com.ermilov.loanappmvpclean.infoSlider.data.model.InfoSliderModel
import com.ermilov.loanappmvpclean.infoSlider.data.recycleradapter.InfoSliderAdapter

class SliderDataSourceImpl : SliderDataSource {

    override fun slider(sliderList: ArrayList<InfoSliderModel>) =
            InfoSliderAdapter(sliderList)

}