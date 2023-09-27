package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.CFileDto;
import com.example.redmedicine.service.CFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cFiles/*")
public class CFileController {
    private final CFileService cFileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/imgList")
    public List<CFileDto> imgList(Long counselorNumber){
        return cFileService.cFileList(counselorNumber);
    }

    @GetMapping("/display")
    public byte[] display(String cFileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir, cFileName));
    }
}
