package com.tnsif.certificateservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tnsif.certificateservice.entity.Certificate;
import com.tnsif.certificateservice.repository.CertificateRepository;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository repository;

    public Certificate saveCertificate(Certificate certificate) {
        return repository.save(certificate);
    }

    public List<Certificate> getAllCertificates() {
        return repository.findAll();
    }

    public Certificate getCertificateById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteCertificate(Long id) {
        repository.deleteById(id);
        return "Certificate deleted with ID: " + id;
    }

    public Certificate updateCertificate(Long id, Certificate updated) {
        Certificate existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCertificateName(updated.getCertificateName());
            existing.setStudentName(updated.getStudentName());
            existing.setCourseName(updated.getCourseName());
            existing.setIssueDate(updated.getIssueDate());
            existing.setExpiryDate(updated.getExpiryDate());
            existing.setGrade(updated.getGrade());
            existing.setInstitution(updated.getInstitution());
            return repository.save(existing);
        }
        return null;
    }
}
