package onm.events

import onm.animals.AnimalControlUnit
import onm.animals.events.AnimalIsHungryEvent
import onm.human.HumanControlUnit
import onm.reports.CentralLogUnit


/**
 * Handler which will react on all types of events. Works on dispatch pattern.
 * */
interface IEventHandler {
    //todo implement global handler for all events
    fun register(humanControlUnit: HumanControlUnit)

    fun register(logUnit: CentralLogUnit)

    fun register(animalControlUnit: AnimalControlUnit)

    fun handle(event: TemperatureEvent)

    fun handle(event: DeviceTurnedOffEvent)

    fun handle(event: DeviceStartsEvent)

    fun handle(event: DeviceFinishedEvent)

    fun handle(event: FridgeEmptyEvent)

    fun handle(event: DeviceBrokenEvent)

    fun handle(event: AnimalIsHungryEvent)

    fun handle(event: RepairEvent)

    fun handle(event: HumanDoSport)

    fun handle(event: HumanStopSport)
}