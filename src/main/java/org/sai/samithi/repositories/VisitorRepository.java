package org.sai.samithi.repositories;

import org.sai.samithi.entities.Visitor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
