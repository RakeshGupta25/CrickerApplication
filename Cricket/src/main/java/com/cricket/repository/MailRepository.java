package com.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.entity.MailDetails;

@Repository
public interface MailRepository extends JpaRepository<MailDetails, Integer> {

}
