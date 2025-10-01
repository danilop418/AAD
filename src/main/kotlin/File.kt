package org.example

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileInputStream
import java.io.FileReader
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

fun main() {
//    createFile(".\\fichero.txt")
//    val lines = readFile(".\\fichero.txt")
//
//    for (line in lines){
//        println(line)
//    }
//    writeFile(".\\fichero2.txt", listOf("Hola","Hola"))
    writeLineStream(".\\fichero.txt", listOf("linea1", "linea2", "linea3"))
    print(readFileStream(".\\fichero2.txt"))
    println("written file")
}

fun createFile(filePath: String) {
    val path = Paths.get(filePath)
    if (!Files.exists(path)) {
        Files.createFile(path)
    }
}

fun readFile(filePath: String): List<String> {
    val path = Paths.get(filePath)
    val lines = Files.readAllLines(path)
    return lines
}

fun writeFile(filePath: String, content: List<String>) {
    val path = Paths.get(filePath)
    //always CREATE
    Files.write(
        path, content, StandardOpenOption.CREATE,
        //overwrite without append
        StandardOpenOption.APPEND
    )
}

fun readFileStream(filePath: String): List<String> {
    val lines = mutableListOf<String>()
    BufferedReader(FileReader(filePath)).use { reader ->
        var line: String? = reader.readLine()
        while (line != null) {
            lines.add(line)
            line = reader.readLine()
        }
    }
    return lines
}

fun writeLineStream(filePath: String, lines: List<String>) {
    BufferedWriter(FileWriter(filePath, true)).use { writer ->
        for (line in lines) {
            writer.write(line)
            writer.newLine()
        }
    }
}

fun readBinary(filePath: String) {
    val content = StringBuilder()
    FileInputStream(filePath).use { file ->
        val buffer = ByteArray(1024)
        var readBytes = file.read(buffer)
        while (readBytes != -1) {
            content.append(String(buffer, 0, readBytes, Charsets.UTF_8))
            readBytes = file.read(buffer)
        }
    }
}
