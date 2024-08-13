package org.scaler.splitwisesept23_evening.controllers;

import org.scaler.splitwisesept23_evening.dtos.ResponseStatus;
import org.scaler.splitwisesept23_evening.dtos.SettleUpGroupRequestDTO;
import org.scaler.splitwisesept23_evening.dtos.SettleUpGroupResponseDTO;
import org.scaler.splitwisesept23_evening.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {
    @Autowired
    private SettleUpService settleUpService;

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO request){
        SettleUpGroupResponseDTO response = new SettleUpGroupResponseDTO();
        try{
            response.setTransactionList(settleUpService.settleUpGroup(request.getGroupId()));
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
