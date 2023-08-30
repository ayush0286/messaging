package com.messaging.app.controller.web;

import com.messaging.app.dto.ServiceResponse;
import com.messaging.app.dto.UserDto;
import com.messaging.app.service.web.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<ServiceResponse> register(@RequestBody UserDto user) {
        System.out.println("handling register user request: " + user.toString());
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            userService.registerUser(user.getUserName(), user.getPhoneNumber());
            serviceResponse.setPayload("User Added Successfully");
        } catch (Exception e) {
            serviceResponse.setPayload(e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<ServiceResponse> login(@RequestParam(value = "userName") String userName, @RequestParam(value = "phone") String phone) {
        System.out.println("handling login user request: " + userName);
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            UserDto userDto = userService.loginUser(userName, phone);
            serviceResponse.setPayload(userDto);
        } catch (Exception e) {
            serviceResponse.setPayload(e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ServiceResponse> searchUserForChat(@RequestParam(value = "searchInput") String searchInput) {
        System.out.println("handling search user request: " + searchInput);
        ServiceResponse serviceResponse = new ServiceResponse();
        try {
            List<UserDto> userDtos = userService.searchUserForChat(searchInput);
            serviceResponse.setPayload(userDtos);
        } catch (Exception e) {
            serviceResponse.setPayload(e.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
