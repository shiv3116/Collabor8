package repository;

import entity.CodeDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeDocumentRepository extends JpaRepository<CodeDocument, Long> {

}
