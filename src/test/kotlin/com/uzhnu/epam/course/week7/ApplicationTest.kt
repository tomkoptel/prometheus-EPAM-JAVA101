package com.uzhnu.epam.course.week7

import org.amshove.kluent.shouldEqualTo
import org.amshove.kluent.shouldThrow
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object ApplicationTest : Spek({
    describe("correct computation") {
        mapOf(
            "10 20 + 30 40 + *" to 2100.0,
            "10 20 30.0 * +" to 610.0
        ).forEach { (string, value) ->
            it("should parse $string to $value") {
                Application.parse(string) shouldEqualTo value
            }
        }
    }

    describe("edge cases") {
        mapOf(
            "10 20 30 () +" to RPNParserException::class,
            "10 20 Е * +" to RPNParserException::class,
            "0 0 /" to ArithmeticException::class
        ).forEach { (string, ex) ->
            it("for $string should throw $ex") {
                { Application.parse(string) } shouldThrow ex
            }
        }
    }
})
