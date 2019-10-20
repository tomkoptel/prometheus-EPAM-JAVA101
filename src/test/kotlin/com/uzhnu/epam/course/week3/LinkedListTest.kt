package com.uzhnu.epam.course.week3

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object LinkedListTest : Spek({
    val list by memoized { LinkedList() }

    describe("add/get") {
        it("adds elements to the end of list") {
            list.add(1)
            list.add(2)

            assertTrue { list.get(0) == 1 }
            assertTrue { list.get(1) == 2 }
        }
    }

    describe(
        """
        0     1     2      3
        n1 -> n2 -> n3 --> n4"""
    ) {
        beforeEachTest {
            list.add(1)
            list.add(2)
            list.add(3)
            list.add(4)
        }

        it("remove 0") {
            list.delete(0)

            assertTrue { list.get(0) == 2 }
            assertTrue { list.get(1) == 3 }
            assertTrue { list.get(2) == 4 }
            assertTrue { list.size() == 3 }
        }

        it("remove 1") {
            list.delete(1)

            assertTrue { list.get(0) == 1 }
            assertTrue { list.get(1) == 3 }
            assertTrue { list.get(2) == 4 }
            assertTrue { list.size() == 3 }
        }

        it("remove 2") {
            list.delete(2)

            assertTrue { list.get(0) == 1 }
            assertTrue { list.get(1) == 2 }
            assertTrue { list.get(2) == 4 }
            assertTrue { list.size() == 3 }
        }

        it("remove 3") {
            list.delete(3)

            assertTrue { list.get(0) == 1 }
            assertTrue { list.get(1) == 2 }
            assertTrue { list.get(2) == 3 }
            assertTrue { list.size() == 3 }
        }

        it("remove one by one") {
            assertTrue { list.delete(0) }
            assertTrue { list.delete(0) }
            assertTrue { list.delete(0) }
            assertTrue { list.delete(0) }

            assertTrue { list.size() == 0 }
            assertTrue { list.get(0) == null }
        }

        it("remove with negative index") {
            assertFalse { list.delete(-1) }
        }

        it("remove with outbound index") {
            assertFalse { list.delete(100) }
        }
    }

    describe("add/size") {
        it("should have 2 elements") {
            list.add(1)
            assertTrue { list.size() == 1 }

            list.add(2)
            assertTrue { list.size() == 2 }
        }
    }
})
