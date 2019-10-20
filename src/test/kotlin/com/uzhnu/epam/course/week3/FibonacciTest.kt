package com.uzhnu.epam.course.week3

import kotlin.test.assertTrue
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object FibonacciTest : Spek({
    val fib by memoized { Fibonacci() }

    describe("edge cases") {
        it("-1 -> -1") {
            assertTrue { fib.getNumber(-1) == -1L }
        }
        it("0 -> -1") {
            assertTrue { fib.getNumber(0) == -1L }
        }
        it("1 -> 1") {
            assertTrue { fib.getNumber(1) == 1L }
        }
        it("2 -> 1") {
            assertTrue { fib.getNumber(2) == 1L }
        }
        it("92 -> 7540113804746346429") {
            assertTrue { fib.getNumber(92) == 7540113804746346429L }
        }
        it("93 -> -1") {
            assertTrue { fib.getNumber(93) == -1L }
        }
        it("94 -> -1") {
            assertTrue { fib.getNumber(94) == -1L }
        }
    }

    describe("more then 3") {
        it("3 -> 2") {
            assertTrue { fib.getNumber(3) == 2L }
        }
        it("4 -> 3") {
            assertTrue { fib.getNumber(4) == 3L }
        }
        it("5 -> 5") {
            assertTrue { fib.getNumber(5) == 5L }
        }
        it("6 -> 8") {
            assertTrue { fib.getNumber(6) == 8L }
        }
        it("7 -> 13") {
            assertTrue { fib.getNumber(7) == 13L }
        }
    }
})
