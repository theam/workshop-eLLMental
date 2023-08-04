package com.theagilemonkeys.workshop.utils

fun String.segmentByCharacters(segmentSize: Int = 2000) = this.chunked(segmentSize)