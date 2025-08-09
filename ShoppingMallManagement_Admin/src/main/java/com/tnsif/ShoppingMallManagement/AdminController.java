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

    @GetMapping
    public List<Admin> list() {
        return service.listAll();
    }

    @PostMapping
    public void add(@RequestBody Admin admin) {
        service.save(admin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> get(@PathVariable Integer id) {
        try {
            Admin admin = service.get(id);
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> update(@PathVariable Integer id, @RequestBody Admin updatedAdmin) {
        try {
            Admin existing = service.get(id);
            existing.setAdminName(updatedAdmin.getAdminName());
            existing.setPassword(updatedAdmin.getPassword());
            existing.setEmail(updatedAdmin.getEmail());
            service.update(existing);
            return new ResponseEntity<>(existing, HttpStatus.OK);
        } catch (NoResultException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
