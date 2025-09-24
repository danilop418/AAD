package org.example

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.Scanner

fun main() {
//    createFile(".\\fichero.txt")
//    val lines = readFile(".\\fichero.txt")
//
//    for (line in lines){
//        println(line)
//    }
    writeFile(".\\fichero2.txt", listOf("Hola","Hola"))
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
    Files.write(path, content, StandardOpenOption.CREATE,
        //overwrite without append
        StandardOpenOption.APPEND)
}












