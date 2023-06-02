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
    fun registerArchive(user: String, gpt: String) {
        archiveRepository.save(
            ArchiveEntity(
                user = user,
                gpt = gpt
            )
        )
    }

    @Transactional(readOnly = true)
    fun findAllArchive(): FindAllArchiveResponse {
        val archiveList = archiveRepository.findAll()
            .map {
                ArchiveElement(
                    id = it.id,
                    user = it.user,
                    gpt = it.gpt
                )
            }

        return FindAllArchiveResponse(archiveList)
    }
}