package com.example.demo.controller;

import com.example.demo.dto.BillDTO;
import com.example.demo.mapper.BillMapper;
import com.example.demo.request.BillReq;
import com.example.demo.response.BillResponse;
import com.example.demo.service.BillService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/info")
public class BillController {
       BillService service;
       BillMapper billMapper;

    public BillController(BillService service, BillMapper billMapper) {
        this.service = service;
        this.billMapper = billMapper;
    }

    @PostMapping
    public BillResponse addBill(@RequestBody BillReq billReq) throws IOException {
          BillResponse returnValue ;
          BillDTO billDTO = billMapper.billRequestToBillDTO(billReq);
          BillDTO addedBill = service.addBill(billDTO);
          returnValue  = billMapper.billDTOToBillResponse(addedBill);

          return returnValue;
    }

    @GetMapping("/{id}")
    public BillResponse getBill(@PathVariable Long id)
    {
        BillResponse returnValue;
        BillDTO billDTO = service.getBill(id);
        returnValue = billMapper.billDTOToBillResponse(billDTO);
        return returnValue;

    }

    @PutMapping("/{id}")
    public BillResponse putBill(@PathVariable Long id, @RequestBody BillReq billReq)
    {
        BillResponse returnValue;
        BillDTO billDTO = billMapper.billRequestToBillDTO(billReq);
        BillDTO updatedBill = service.updateBill(id,billDTO);
        returnValue = billMapper.billDTOToBillResponse(updatedBill);
        return  returnValue;
    }

    @DeleteMapping("/{id}")
    public BillResponse deleteBill(@PathVariable Long id)
    {
        BillResponse returnValue;
        BillDTO billDTO = service.deleteBill(id);
        returnValue = billMapper.billDTOToBillResponse(billDTO);
        return returnValue;
    }
//Pagination
    @GetMapping
    public List<BillResponse> getBills(@RequestParam(value = "page",defaultValue = "0") int page,@RequestParam(value = "limit",defaultValue = "25") int limit)
    {
        List<BillResponse> returnValue = new ArrayList<>();
        List<BillDTO> billDTOS =  service.getBills(page,limit);
        for(BillDTO bill : billDTOS)
        {
            BillResponse res = billMapper.billDTOToBillResponse(bill);
            returnValue.add(res);

        }

        return  returnValue;

    }


}
