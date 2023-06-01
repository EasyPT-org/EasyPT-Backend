package com.example.easyptbackend.domain.application

import com.example.easyptbackend.domain.model.ArchiveEntity
import com.example.easyptbackend.domain.model.repository.ArchiveRepository
import com.example.easyptbackend.domain.presentation.dto.ArchiveElement
import com.example.easyptbackend.domain.presentation.dto.FindAllArchiveResponse
import com.example.easyptbackend.domain.presentation.dto.RegisterArchiveRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ArchiveService(
    private val archiveRepository: ArchiveRepository
) {
    @Transactional
    fun registerArchive(registerArchiveRequest: RegisterArchiveRequest) {
        archiveRepository.save(
            ArchiveEntity(
                user = registerArchiveRequest.user,
                gpt = registerArchiveRequest.gpt
            )
        )
    }

    @Transactional(readOnly = true)
    fun findAllArchive(): FindAllArchiveResponse {
        val archiveList = archiveRepository.findAll()
            .map {
                ArchiveElement(
                    user = it.user,
                    gpt = it.gpt
                )
            }

        return FindAllArchiveResponse(archiveList)
    }
}