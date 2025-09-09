package com.tnsif.ShoppingMallManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import jakarta.persistence.NoResultException;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepo repo;

    // 🔹 Get all admins
    public List<Admin> listAll() {
        return repo.findAll();
    }

    // 🔹 Save admin
    public void save(Admin admin) {
        repo.save(admin);
    }

    // 🔹 Get admin by ID (throws exception if not found)
    public Admin get(Integer id) {
        return repo.findById(id)
                   .orElseThrow(() -> new NoResultException("Admin not found with id: " + id));
    }

    // 🔹 Delete admin
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new NoResultException("Cannot delete. Admin not found with id: " + id);
        }
        repo.deleteById(id);
    }

    // 🔹 Update admin
    public void update(Admin admin) {
        if (!repo.existsById(admin.getAdminId())) {
            throw new NoResultException("Cannot update. Admin not found with id: " + admin.getAdminId());
        }
        repo.save(admin);
    }
}
