package org.sai.samithi.repositories;

import org.sai.samithi.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query(value = "select id, name, subject, message, telephone, email, created_at from contact order by created_at desc", nativeQuery = true)
    List<Contact> getAllByLatestDate();

}


//    @Query(value = "select count(tds_id) from tds where tds_tc_id = ?1", nativeQuery = true)
//    int countAllByTestcaseId(Integer testCaseId);
//
//    @Query(value = "select count(tds_seq_order) from tds where tds_tc_id = ?1 and tds_seq_order = ?2", nativeQuery = true)
//    int countSequenceOrderByTestcaseId(Integer testCaseId, Integer sequenceOrder);
//
//    @Query(value = "select * from tds where tds_tc_id = ?1 order by tds_seq_order", nativeQuery = true)
//    List<TestCaseStep> findTestStepOrderBySeq(Integer id);
//
//    @Query(value = "select * from tds order by tds_tc_id, tds_seq_order", nativeQuery = true)
//    List<TestCaseStep> findAllTestCaseStep();