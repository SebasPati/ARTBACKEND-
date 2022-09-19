package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.dtos.PaymentDto;
import com.challengerFinal.arte.dtos.PaymentPostDTO;
import com.challengerFinal.arte.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentImplements implements PaymentService {
    @Override
    public List<PaymentDto> getAllPayments() {
        return null;
    }

    @Override
    public ResponseEntity<Object> createPayment(PaymentPostDTO paymentPostDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updatePayment(PaymentPostDTO paymentPostDTO, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> patchPayment(PaymentPostDTO paymentPostDTO, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deletePayment(Long id) {
        return null;
    }
}
