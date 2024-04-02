package org.sai.samithi.repositories;

import org.sai.samithi.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Integer> {
    @Query(value = "select pair_value from home where pair_key = ?1", nativeQuery = true)
    String getValue(String key);
}
