package com.example.easyptbackend.domain.presentation.dto

import java.time.LocalDateTime

data class FindAllArchiveResponse(
    val archiveList: List<ArchiveElement>
)

data class ArchiveElement(
    val id: Int,
    val user: String,
    val gpt: String,
    val createDate: LocalDateTime
)