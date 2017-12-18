package onm.house.devices

import onm.api.OvenControlApi
import onm.configuration.DeviceType
import onm.configuration.json.DeviceConfig
import onm.events.BakeFinishedEvent
import onm.events.IEventHandler
import onm.reports.IReport
import onm.things.Food
import java.util.*

/**
 * Oven representation.
 * */
class Oven(override val id: UUID,
           eventHandler: IEventHandler,
           deviceConfig: DeviceConfig)
    : AbstractDevice(DeviceType.OVEN, deviceConfig, eventHandler) {

    private val ovenBakeFinishedEvent = BakeFinishedEvent(eventHandler, id)

    val ovenControlApi = OvenControlApi(this, this.id)

    fun switchOn(food: Collection<Food>, minutes: Double) {
        if (!isAvailable())
            log.error("Oven named '${deviceDescription}' is already working or broken, therefore cannot be switched on.")
        else
            doWork((minutes * 60000).toLong(), ovenBakeFinishedEvent::raiseEvent)
        deviceStateMachine.turnedOffState()
        //TODO Food size determines number of portions.
    }

    override fun generateReport(): IReport {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}