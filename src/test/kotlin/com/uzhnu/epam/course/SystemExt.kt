package com.uzhnu.epam.course

import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

fun captureSystemOut(test: (OutputStream) -> Unit) {
    val outContent = ByteArrayOutputStream()
    val originalOut = System.out

    System.setOut(PrintStream(outContent))
    try {
        test(outContent)
    } finally {
        System.setOut(originalOut)
    }
}
