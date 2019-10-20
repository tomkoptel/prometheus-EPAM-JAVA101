package com.uzhnu.epam.course.week6

import com.uzhnu.epam.course.captureSystemOut
import org.amshove.kluent.shouldEqual
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object RLEApplicationEncodeTest : Spek({
    describe("major cases") {
        mapOf<String, String>(
            "Hhhhhhhhhhhhhheeeellooooo" to "Hh9h4e4l2o5",
            "hhhhhhhhhhhh" to "h9h3",
            "HRT" to "HRT",
            "HRTT" to "HRT2",
            "H" to "H",
            "Hoooo" to "Ho4",
            "dddffffr" to "d3f4r"
        ).forEach { (inKey, outKey) ->
            it ("maps '$inKey' -> '$outKey'") {
                captureSystemOut {
                    RLEApplicationEncode.main(arrayOf(inKey))
                    it.toString() shouldEqual "$outKey\n"
                }
            }
        }
    }

    describe("error cases") {
        it("should print empty string if no args") {
            captureSystemOut {
                RLEApplicationEncode.main(null)
                it.toString() shouldEqual "\n"
            }
        }
        it("should print empty string if args empty") {
            captureSystemOut {
                RLEApplicationEncode.main(arrayOf())
                it.toString() shouldEqual "\n"
            }
        }
        it("should print empty string if arg is empty string") {
            captureSystemOut {
                RLEApplicationEncode.main(arrayOf(""))
                it.toString() shouldEqual "\n"
            }
        }
        it("should print empty string if arg is null string") {
            captureSystemOut {
                RLEApplicationEncode.main(arrayOf<String?>(null))
                it.toString() shouldEqual "\n"
            }
        }
    }
})
