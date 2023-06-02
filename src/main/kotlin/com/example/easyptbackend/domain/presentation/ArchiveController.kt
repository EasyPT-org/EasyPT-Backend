package com.example.easyptbackend.domain.presentation

import com.example.easyptbackend.domain.application.ArchiveService
import com.example.easyptbackend.domain.presentation.dto.FindAllArchiveResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/archive")
@RestController
class ArchiveController(
    private val archiveService: ArchiveService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registerArchive(@RequestParam("user")user: String, @RequestParam("gpt")gpt: String) {
        archiveService.registerArchive(user, gpt)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAllArchive(): FindAllArchiveResponse {
        return archiveService.findAllArchive()
    }
}