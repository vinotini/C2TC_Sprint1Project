package com.tnsif.ShoppingMallManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {

    @Id
    @Column(name = "admin_id")
    private int adminId;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    // 🔹 Additional variables
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role")
    private String role;  // e.g. SUPER_ADMIN, MANAGER

    @Column(name = "status")
    private String status; // ACTIVE / INACTIVE

    @Column(name = "created_at")
    private String createdAt; // better to use LocalDateTime

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "last_login")
    private String lastLogin;

    @Column(name = "address")
    private String address;

    @Column(name = "department")
    private String department;

    // ✅ Default constructor
    public Admin() {
        super();
    }

    // ✅ All-Args constructor
    public Admin(int adminId, String adminName, String password, String email, String phoneNumber,
                 String role, String status, String createdAt, String updatedAt,
                 String lastLogin, String address, String department) {
        super();
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastLogin = lastLogin;
        this.address = address;
        this.department = department;
    }

    // ✅ Getters & Setters
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password +
                ", email=" + email + ", phoneNumber=" + phoneNumber + ", role=" + role +
                ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt +
                ", lastLogin=" + lastLogin + ", address=" + address + ", department=" + department + "]";
    }
}
