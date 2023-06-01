package com.example.easyptbackend.domain.model

import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tbl_archive")
class ArchiveEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int =  0,

    @field:NotNull
    val user: String,

    @field:NotNull
    val gpt: String
)