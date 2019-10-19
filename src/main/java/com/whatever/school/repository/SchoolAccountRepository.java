package com.whatever.school.repository;

import com.whatever.school.domain.SchoolAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolAccountRepository extends JpaRepository<SchoolAccount, Long> {
}
