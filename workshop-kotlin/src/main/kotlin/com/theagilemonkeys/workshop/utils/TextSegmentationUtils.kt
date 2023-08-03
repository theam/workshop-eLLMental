package com.theagilemonkeys.workshop.utils

fun String.segmentByCharacters(segmentSize: Int = 1000) = this.chunked(segmentSize)