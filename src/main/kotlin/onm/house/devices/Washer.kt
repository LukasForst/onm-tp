package onm.house.devices

import onm.configuration.DeviceType
import onm.configuration.json.DeviceConfig
import onm.events.IEventHandler
import onm.events.WasherDoneEvent
import onm.reports.IReport
import java.util.*

/**
 * Wash machine representation
 * */
class Washer(override val id: UUID,
             eventHandler: IEventHandler,
             deviceConfig: DeviceConfig) : AbstractDevice(DeviceType.WASHER, deviceConfig, eventHandler) {

    private val event = WasherDoneEvent(eventHandler, id)

    /**
     * Starts washing clothes. This produces event which is raised after given time period. Note that new thread is created.
     * */
    fun startWashing(periodInMinutes: Double) {
        doWork((periodInMinutes * 60000).toLong(), event::raiseEvent) //todo what if electricity is turned off?
    }

    override fun generateReport(): IReport {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}