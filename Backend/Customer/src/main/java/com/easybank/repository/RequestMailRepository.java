package com.easybank.repository;

import com.easybank.model.RequestMail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestMailRepository extends JpaRepository<RequestMail,Long> {
}
