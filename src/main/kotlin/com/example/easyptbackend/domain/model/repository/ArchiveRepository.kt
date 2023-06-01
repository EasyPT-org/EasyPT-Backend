package com.example.easyptbackend.domain.model.repository

import com.example.easyptbackend.domain.model.ArchiveEntity
import org.springframework.data.repository.CrudRepository

interface ArchiveRepository : CrudRepository<ArchiveEntity, Int>