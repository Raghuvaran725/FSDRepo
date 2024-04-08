package com.merchant.main.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.merchant.main.dao.MerchantDao;
import com.merchant.main.entity.Merchant;
import com.merchant.main.serviceimpl.MerchantServiceImpl;

class MerchantServiceImplTest {

    @Mock
    private MerchantDao merchantDaoMock;

    @InjectMocks
    private MerchantServiceImpl merchantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetMerchants() {
        // Arrange
        Merchant merchant1 = new Merchant();
        merchant1.setMerchantId(1);
        merchant1.setMerchantName("Merchant 1");

        Merchant merchant2 = new Merchant();
        merchant2.setMerchantId(2);
        merchant2.setMerchantName("Merchant 2");

        List<Merchant> expectedMerchants = Arrays.asList(merchant1, merchant2);

        when(merchantDaoMock.getMerchants()).thenReturn(expectedMerchants);

        // Act
        List<Merchant> actualMerchants = merchantService.getMerchants();

        // Assert
        assertEquals(expectedMerchants.size(), actualMerchants.size());
        assertEquals(expectedMerchants.get(0).getMerchantName(), actualMerchants.get(0).getMerchantName());
        assertEquals(expectedMerchants.get(1).getMerchantName(), actualMerchants.get(1).getMerchantName());
    }

    @Test
    void testGetMerchant() {
        // Arrange
        int merchantId = 1;
        Merchant expectedMerchant = new Merchant();
        expectedMerchant.setMerchantId(merchantId);
        expectedMerchant.setMerchantName("Merchant 1");

        when(merchantDaoMock.getMerchant(merchantId)).thenReturn(expectedMerchant);

        // Act
        Merchant actualMerchant = merchantService.getMerchant(merchantId);

        // Assert
        assertEquals(expectedMerchant.getMerchantId(), actualMerchant.getMerchantId());
        assertEquals(expectedMerchant.getMerchantName(), actualMerchant.getMerchantName());
    }

    // Similarly, write tests for other methods like addMerchant, updateMerchant, deleteMerchant, and getMerchantByEmail
}
