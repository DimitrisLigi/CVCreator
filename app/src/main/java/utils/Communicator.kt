package utils

import models.usermodels.UserDataFromDomainModel
import models.usermodels.UserDomainModel

interface Communicator {
    fun passData(userDomainModel: UserDataFromDomainModel)
}