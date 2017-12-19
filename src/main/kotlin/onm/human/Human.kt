package onm.human

import onm.api.FridgeControlApi
import onm.house.devices.AbstractDevice
import onm.house.devices.Dryer
import onm.interfaces.HouseEntity
import onm.reports.IReport
import onm.things.Equipment
import onm.things.Food
import onm.things.FoodType
import java.util.*
import kotlin.concurrent.thread

class Human(val abilitiesList: Collection<HumanAbility>, val name: String, private val controlUnit: HumanControlUnit, override val id: UUID) : HouseEntity {
    var available: Boolean = true

    init {
        controlUnit.registerHuman(this)
    }

    override fun generateReport(): IReport {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun goShop(fridgeApi: FridgeControlApi) {
        available = false
        thread(start = true) {
            Thread.sleep(10000)
            // Generate food //TODO CHECK IF THIS WORKS
            val types = FoodType.values()
            val ret = types.map { Food(it) }

            fridgeApi.addFood(ret)
            available = true
        }
    }

    fun dryingClothes(dryer: Dryer) {
        available = false
        thread(start = true) {
            //Simulate work
            Thread.sleep(1000)
            dryer.switchOn()
            available = true
        }
    }

    fun repairDevice(device: AbstractDevice) {
        available = false
        thread(start = true) {
            //Simulate work
            Thread.sleep(2000)
            device.repair()
            available = true
        }
    }

    fun doSport(equipment: Equipment, callback: () -> Unit) {
        available = false
        thread(start = true) {
            Thread.sleep(4000)

            callback.invoke()
            controlUnit._availableEquipment.add(equipment)
            available = true
        }
    }
}