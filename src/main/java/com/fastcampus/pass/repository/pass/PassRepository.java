package com.fastcampus.pass.repository.pass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassRepository extends JpaRepository<PassEntity, Integer> {
    @Query(value = "select p from PassEntity p " +
            "       join fetch p.packageEntity " +
            "       where p.userId = :userId " +
            "       order by p.endedAt desc nulls first ")
    List<PassEntity> findByUserId(@Param("userId") String userid);
}

