package com.theagilemonkeys.workshop.controllers

import com.theagilemonkeys.ellmental.semanticsearch.LearnInput
import com.theagilemonkeys.workshop.services.SemanticSearchService
import com.theagilemonkeys.workshop.utils.segmentByCharacters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile


@RestController
class LearnController(@Autowired private val semanticSearchService: SemanticSearchService) {
    @PostMapping("/learn", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    suspend fun learn(@RequestParam("file") file: MultipartFile) =
        file.inputStream.readAllBytes().toString(Charsets.UTF_8).let { text ->
            val segments = text.segmentByCharacters()
            semanticSearchService.learn(LearnInput(segments))
        }
}