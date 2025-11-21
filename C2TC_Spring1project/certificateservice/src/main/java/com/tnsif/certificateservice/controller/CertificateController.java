package com.tnsif.certificateservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tnsif.certificateservice.entity.Certificate;
import com.tnsif.certificateservice.service.CertificateService;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateService service;

    @PostMapping
    public Certificate addCertificate(@RequestBody Certificate certificate) {
        return service.saveCertificate(certificate);
    }

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return service.getAllCertificates();
    }

    @GetMapping("/{id}")
    public Certificate getCertificateById(@PathVariable Long id) {
        return service.getCertificateById(id);
    }

    @PutMapping("/{id}")
    public Certificate updateCertificate(@PathVariable Long id, @RequestBody Certificate certificate) {
        return service.updateCertificate(id, certificate);
    }

    @DeleteMapping("/{id}")
    public String deleteCertificate(@PathVariable Long id) {
        return service.deleteCertificate(id);
    }
}
