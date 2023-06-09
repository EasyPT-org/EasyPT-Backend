package com.example.easyptbackend.domain.application

import com.example.easyptbackend.domain.model.ArchiveEntity
import com.example.easyptbackend.domain.model.repository.ArchiveRepository
import com.example.easyptbackend.domain.presentation.dto.ArchiveElement
import com.example.easyptbackend.domain.presentation.dto.FindAllArchiveResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class ArchiveService(
    private val archiveRepository: ArchiveRepository
) {
    @Transactional
    fun registerArchive(user: String, gpt: String) {
        archiveRepository.save(
            ArchiveEntity(
                user = user,
                gpt = gpt,
                createDate = LocalDateTime.now()
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
                    gpt = it.gpt,
                    createDate = it.createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
                )
            }

        return FindAllArchiveResponse(archiveList)
    }
}