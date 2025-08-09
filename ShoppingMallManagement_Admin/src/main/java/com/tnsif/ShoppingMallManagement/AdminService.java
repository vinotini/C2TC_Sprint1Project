package com.tnsif.ShoppingMallManagement;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepo repo;

    // Get all admins
    public List<Admin> listAll() {
        return repo.findAll();
    }

    // Save admin
    public void save(Admin admin) {
        repo.save(admin);
    }

    // Get admin by ID
    public Admin get(Integer id) {
        return repo.findById(id).get();
    }

    // Delete admin
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    // Update admin
    public void update(Admin admin) {
        repo.save(admin);
    }
}
