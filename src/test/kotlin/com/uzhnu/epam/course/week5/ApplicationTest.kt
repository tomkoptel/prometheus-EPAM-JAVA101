package com.uzhnu.epam.course.week5

import com.uzhnu.epam.course.captureSystemOut
import org.amshove.kluent.shouldEqual
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object ApplicationTest : Spek({
    describe("error cases") {
        it("testWrongArgs1") {
            captureSystemOut {
                Application.main(arrayOf("echo", "test", "test"))
                it.toString() shouldEqual "Error\n"
            }
        }
        it("testWrongArgs2") {
            captureSystemOut {
                Application.main(arrayOf("exit", "test"))
                it.toString() shouldEqual "Error\n"
            }
        }
        it("testWrongArgs3") {
            captureSystemOut {
                Application.main(arrayOf("date", "before"))
                it.toString() shouldEqual "Error\n"
            }
        }
    }

    describe("happy cases") {
        it("echo expects 2 args") {
            captureSystemOut {
                Application.main(arrayOf("echo", "hi!"))
                it.toString() shouldEqual "hi!\n"
            }
        }
        it("exit expects 1 arg") {
            captureSystemOut {
                Application.main(arrayOf("exit"))
                it.toString() shouldEqual "Goodbye!\n"
            }
        }
        it("help expects 1 arg") {
            captureSystemOut {
                Application.main(arrayOf("help"))
                it.toString() shouldEqual "Help executed\n"
            }
        }
    }
})
