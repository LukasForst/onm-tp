package onm.house.devices

import onm.configuration.DeviceType
import onm.configuration.json.PowerConsumption
import onm.events.IEventHandler
import onm.events.WasherDoneEvent
import java.util.*

/**
 * Wash machine representation
 * */
class Washer(override val id: UUID,
             eventHandler: IEventHandler,
             powerConsumption: PowerConsumption = PowerConsumption()) : AbstractDevice(DeviceType.WASHER, powerConsumption) {

    private val event = WasherDoneEvent(eventHandler)

    /**
     * Starts washing clothes. This produces event which is raised after given time period. Note that new thread is created.
     * */
    fun startWashing(periodInMinutes: Double) {
        doWork((periodInMinutes * 60000).toLong(), event::raiseEvent) //todo what if electricity is turned off?
    }

    override fun generateReport(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}