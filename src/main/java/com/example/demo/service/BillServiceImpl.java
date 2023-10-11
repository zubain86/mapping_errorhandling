package com.example.demo.service;

import com.example.demo.dao.BillRepo;
import com.example.demo.dto.BillDTO;
import com.example.demo.dto.DeviceDTO;
import com.example.demo.entity.BillEntity;
import com.example.demo.entity.DeviceEntity;
import com.example.demo.exceptions.ErrorMessages;
import com.example.demo.exceptions.UserException;
import com.example.demo.mapper.BillMapper;
import com.example.demo.validator.DeviceValidation;
import com.example.demo.validator.EmailValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    BillMapper billMapper;
    BillRepo repo;


    public BillServiceImpl(BillMapper billMapper, BillRepo repo) {
        this.billMapper = billMapper;
        this.repo = repo;
    }

    @Override
    public BillDTO addBill(BillDTO billDTO) throws IOException {
        BillDTO returnValue;
        //Email validation
        EmailValidator emailValid = new EmailValidator();
        emailValid.emailValidation(billDTO.getEmail());
        //Device validation
        List<String> color = new ArrayList<>();
        for (DeviceDTO deviceDTO:billDTO.getDevices()) {
            color.add(deviceDTO.getDeviceColour());
        }
        DeviceValidation isValid = new DeviceValidation();
        isValid.deviceValidation(color);
        BillEntity bill = billMapper.billDTOToBillEntity(billDTO);
        BillEntity standardBill = repo.save(bill);
//        for (DeviceEntity deviceEntity:standardBill.getDevices()) {
//            repo.addForeignKey(bill.getBill_id(),deviceEntity.getDevice_id());
//        }

        returnValue = billMapper.billEntityToBillDTO(standardBill);
//        Response response = emailService.emailSendService(billDTO, files);

//        if (response.getStatusCode() == 200 || response.getStatusCode() == 202) {
//            returnValue.setEmailResponse("Email is sent successfully!");
//        } else {
//            returnValue.setEmailResponse("Email is not sent successfully!");
//        }

        return returnValue;

    }

    @Override
    public BillDTO getBill(Long id) {
        BillDTO returnValue;
        BillEntity billEntity = repo.findById(id).orElse(null);
        if(billEntity==null)
            throw new UserException(ErrorMessages.RECORD_DOES_NOT_EXISTS.getErrorMessage());
        returnValue = billMapper.billEntityToBillDTO(billEntity);
        return returnValue;
    }

    @Override
    public BillDTO updateBill(Long id, BillDTO billDTO) {
        BillDTO returnValue;
        BillEntity search = repo.findById(id).orElse(null);
        if(search==null)
            throw new UserException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        BillEntity billEntity = billMapper.billDTOToBillEntity(billDTO);
        BillEntity standardEntity = repo.save(billEntity);
        returnValue = billMapper.billEntityToBillDTO(standardEntity);
        return returnValue;
    }

    @Override
    public BillDTO deleteBill(Long id) {
        BillDTO returnValue;
        BillEntity billEntity = repo.findById(id).orElse(null);
        if (billEntity != null)
            repo.delete(billEntity);
        else
            throw new UserException(ErrorMessages.RECORD_DOES_NOT_EXISTS.getErrorMessage());
        returnValue = billMapper.billEntityToBillDTO(billEntity);
        return returnValue;

    }

    @Override
    public List<BillDTO> getBills(int page, int limit)
    {
           List<BillDTO> returnValue = new ArrayList<>();
        Pageable pageableRequest =   PageRequest.of(page, limit);
        Page<BillEntity> billPage = repo.findAll(pageableRequest);
        List<BillEntity> billEntities = billPage.getContent();
        for (BillEntity bill: billEntities)
        {
            BillDTO billDTO = billMapper.billEntityToBillDTO(bill);
            returnValue.add(billDTO);

        }

        return returnValue;

    }

}
