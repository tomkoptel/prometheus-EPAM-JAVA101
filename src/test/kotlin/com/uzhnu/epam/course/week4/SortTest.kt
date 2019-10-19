package com.uzhnu.epam.course.week4

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.util.*
import kotlin.test.assertTrue

object SortTest : Spek({
    describe("compute") {
        it("should follow original setup") {
            val actual = Sort.compute()
            val expected = intArrayOf(0, 1, 2, 3, 4, 5, 6, 10, 10)
            assertTrue(message = "expected=${Arrays.toString(expected)}\nactual=  ${Arrays.toString(actual)}\n") {
                Arrays.equals(expected, actual)
            }
        }
        it("should follow reverse setup") {
            val actual = Sort.computeReverse()
            val expected = intArrayOf(10, 10, 6, 5, 4, 3, 2, 1, 0)
            assertTrue(message = "expected=${Arrays.toString(expected)}\nactual=  ${Arrays.toString(actual)}\n") {
                Arrays.equals(expected, actual)
            }
        }
    }
})
