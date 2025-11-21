package com.tnsif.certificateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.certificateservice.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
