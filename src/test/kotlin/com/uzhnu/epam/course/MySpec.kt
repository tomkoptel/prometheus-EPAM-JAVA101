package com.uzhnu.epam.course

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertTrue

object MySpec : Spek({
    describe("1 + 1") {
        it("should be true") {
            assertTrue { (1 + 1) == 2 }
        }
    }
})