package com.example.demo.mapper;

import com.example.demo.dto.BillDTO;
import com.example.demo.entity.BillEntity;
import com.example.demo.request.BillReq;
import com.example.demo.response.BillResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface BillMapper {

   BillDTO billRequestToBillDTO(BillReq billReq);


   BillEntity billDTOToBillEntity(BillDTO billDTO);

   BillDTO billEntityToBillDTO(BillEntity standardBill);

   BillResponse billDTOToBillResponse(BillDTO addedBill);



}
