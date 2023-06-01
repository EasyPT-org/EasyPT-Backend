package com.example.easyptbackend.domain.presentation

import com.example.easyptbackend.domain.application.ArchiveService
import com.example.easyptbackend.domain.presentation.dto.FindAllArchiveResponse
import com.example.easyptbackend.domain.presentation.dto.RegisterArchiveRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class ArchiveController(
    private val archiveService: ArchiveService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registerArchive(@RequestBody @Valid registerArchiveRequest: RegisterArchiveRequest) {
        archiveService.registerArchive(registerArchiveRequest)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAllArchive(): FindAllArchiveResponse {
        return archiveService.findAllArchive()
    }
}