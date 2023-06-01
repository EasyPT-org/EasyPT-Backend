package com.example.easyptbackend.domain.presentation.dto

data class FindAllArchiveResponse(
    val archiveList: List<ArchiveElement>
)

data class ArchiveElement(
    val user: String,
    val gpt: String
)