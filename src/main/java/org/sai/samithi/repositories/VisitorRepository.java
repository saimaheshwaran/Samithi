package org.sai.samithi.repositories;

import org.sai.samithi.entities.Visitor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    @Query(value = "select id, ip_address, user_agent, url, visit_time from visitor order by visit_time desc", nativeQuery = true)
    List<Visitor> getAllByLatestDate();
}
