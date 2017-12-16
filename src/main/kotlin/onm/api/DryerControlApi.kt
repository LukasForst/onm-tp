package onm.api

import onm.house.devices.Dryer

/**
 * Class representing api of dryer. Dryer may dry clothes.
 */
class DryerControlApi(
        private val dryer: Dryer) {

    /**
     * Start drying clothes for time period defined in certain dryer.
     */
    fun switchOn() {
        dryer.switchOn()
    }


}