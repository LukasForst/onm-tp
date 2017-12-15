package onm.animals

import java.util.*

/**
 * This is gold fish.
 * */
class GoldFish(id: UUID, name: String, eventHandler: AnimalControlUnit) : AbstractAnimal(id, name, AnimalType.DOG, eventHandler) {
    override fun generateReport(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}