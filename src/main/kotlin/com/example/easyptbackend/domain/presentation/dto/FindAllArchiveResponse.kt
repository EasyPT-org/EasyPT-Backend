package com.example.easyptbackend.domain.presentation.dto

data class FindAllArchiveResponse(
    val archiveList: List<ArchiveElement>
)

data class ArchiveElement(
    val id: Int,
    val user: String,
    val gpt: String
)