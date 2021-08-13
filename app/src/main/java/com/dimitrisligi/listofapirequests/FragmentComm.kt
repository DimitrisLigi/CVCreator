package com.dimitrisligi.listofapirequests

import models.ColorData

interface FragmentComm {
    fun passDataToPopUp(colorData: ColorData)
}