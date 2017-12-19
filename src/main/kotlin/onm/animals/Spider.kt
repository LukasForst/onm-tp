package onm.animals

import onm.reports.IReport
import java.util.*

/**
 * This is spider.
 * */
class Spider(id: UUID, name: String, eventHandler: AnimalControlUnit) : AbstractAnimal(id, name, AnimalType.DOG, eventHandler) {
    init {
        eventHandler.register(this)
    }

    override fun generateReport(): IReport {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}