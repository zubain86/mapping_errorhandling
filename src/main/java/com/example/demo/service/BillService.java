package com.example.demo.service;

import com.example.demo.dto.BillDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BillService {
    BillDTO addBill(BillDTO billDTO) throws IOException;

    BillDTO getBill(Long id);

    BillDTO updateBill(Long id, BillDTO billDTO);

    BillDTO deleteBill(Long id);

    List<BillDTO> getBills(int page, int limit);
}
