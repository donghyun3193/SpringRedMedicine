package com.example.redmedicine.service;

import com.example.redmedicine.domain.dto.UserDto;
import com.example.redmedicine.mapper.AdminMapper;
import com.example.redmedicine.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {
    private final AdminMapper adminMapper;
    private final UserDto userDto;


    public UserDto getUserNumber(Long userNumber) {
        return adminMapper.getUserNumber(userNumber);
    }
}
