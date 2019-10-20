package com.uzhnu.epam.course.week6

import com.uzhnu.epam.course.captureSystemOut
import org.amshove.kluent.shouldEqual
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object RLEApplicationDecodeTest : Spek({
    describe("major cases") {
        mapOf<String, String>(
            "Hh9h4e4l2o5" to "Hhhhhhhhhhhhhheeeellooooo",
            "h9h3" to "hhhhhhhhhhhh",
            "HRT2" to "HRTT",
            "Ho4" to "Hoooo",
            "d3f4r" to "dddffffr"
        ).forEach { (inKey, outKey) ->
            it("maps '$inKey' -> '$outKey'") {
                captureSystemOut {
                    RLEApplicationDecode.main(arrayOf(inKey))
                    it.toString() shouldEqual "$outKey\n"
                }
            }
        }
    }

    describe("error cases") {
        it("should print empty string if no args") {
            captureSystemOut {
                RLEApplicationDecode.main(null)
                it.toString() shouldEqual "\n"
            }
        }
        it("should print empty string if args empty") {
            captureSystemOut {
                RLEApplicationDecode.main(arrayOf())
                it.toString() shouldEqual "\n"
            }
        }
        it("should print empty string if arg is empty string") {
            captureSystemOut {
                RLEApplicationDecode.main(arrayOf(""))
                it.toString() shouldEqual "\n"
            }
        }
        it("should print empty string if arg is null string") {
            captureSystemOut {
                RLEApplicationDecode.main(arrayOf<String?>(null))
                it.toString() shouldEqual "\n"
            }
        }

        listOf(
            "Hh90helo",
            "Hh09helo",
            "H29h3e4l2o5",
            "Hh00helo",
            "Hh300helo",
            "Hhhhhhhhhhhhhheeeellooooo",
            "HRT",
            "H",
            "9o",
            "1h9h3e4l2o5",
            "H09h3e4l2o5",
            "H19h3e4l2o5"
        ).forEach { brokenString ->
            it("should print empty string for broken string '$brokenString'") {
                captureSystemOut {
                    RLEApplicationDecode.main(arrayOf(brokenString))
                    it.toString() shouldEqual "\n"
                }
            }
        }
    }
})
