package com.tnsif.ShoppingMallManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.NoResultException;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService service;

    // 🔹 GET all admins
    @GetMapping
    public List<Admin> list() {
        return service.listAll();
    }

    // 🔹 POST new admin
    @PostMapping
    public ResponseEntity<Admin> add(@RequestBody Admin admin) {
        service.save(admin);
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }

    // 🔹 GET admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> get(@PathVariable Integer id) {
        try {
            Admin admin = service.get(id);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 🔹 DELETE admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 🔹 UPDATE admin
    @PutMapping("/{id}")
    public ResponseEntity<Admin> update(@PathVariable Integer id, @RequestBody Admin updatedAdmin) {
        try {
            Admin existing = service.get(id);

            // update all fields
            existing.setAdminName(updatedAdmin.getAdminName());
            existing.setPassword(updatedAdmin.getPassword());
            existing.setEmail(updatedAdmin.getEmail());
            existing.setPhoneNumber(updatedAdmin.getPhoneNumber());
            existing.setRole(updatedAdmin.getRole());
            existing.setStatus(updatedAdmin.getStatus());
            existing.setCreatedAt(updatedAdmin.getCreatedAt());
            existing.setUpdatedAt(updatedAdmin.getUpdatedAt());
            existing.setLastLogin(updatedAdmin.getLastLogin());
            existing.setAddress(updatedAdmin.getAddress());
            existing.setDepartment(updatedAdmin.getDepartment());

            service.update(existing);
            return new ResponseEntity<>(existing, HttpStatus.OK);

        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
