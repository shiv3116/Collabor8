package com.collabor8.repository;

import com.collabor8.entity.CodeDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeDocumentRepository extends JpaRepository<CodeDocument, Long> {

}
