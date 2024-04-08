package com.admin.main.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.admin.main.dao.AdminDAO;
import com.admin.main.entity.Admin;
import com.admin.main.serviceimpl.AdminServiceImpl;

public class AdminServiceImplTest {

    @Mock
    private AdminDAO adminDaoMock;

    @InjectMocks
    private AdminServiceImpl adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllAdmins() {
        // Arrange
        Admin admin1 = new Admin();
        admin1.setId(1L);
        admin1.setUsername("admin1");

        Admin admin2 = new Admin();
        admin2.setId(2L);
        admin2.setUsername("admin2");

        List<Admin> expectedAdmins = Arrays.asList(admin1, admin2);

        when(adminDaoMock.getAllAdmins()).thenReturn(expectedAdmins);

        // Act
        List<Admin> actualAdmins = adminService.getAllAdmins();

        // Assert
        assertEquals(expectedAdmins.size(), actualAdmins.size());
        assertEquals(expectedAdmins.get(0).getUsername(), actualAdmins.get(0).getUsername());
        assertEquals(expectedAdmins.get(1).getUsername(), actualAdmins.get(1).getUsername());
    }

    @Test
    void testGetAdminById() {
        // Arrange
        Long adminId = 1L;
        Admin expectedAdmin = new Admin();
        expectedAdmin.setId(adminId);
        expectedAdmin.setUsername("admin1");

        when(adminDaoMock.getAdminById(adminId)).thenReturn(expectedAdmin);

        // Act
        Admin actualAdmin = adminService.getAdminById(adminId);

        // Assert
        assertEquals(expectedAdmin.getId(), actualAdmin.getId());
        assertEquals(expectedAdmin.getUsername(), actualAdmin.getUsername());
    }

    // Similarly, write tests for other methods like createAdmin, updateAdmin, and deleteAdmin
}

