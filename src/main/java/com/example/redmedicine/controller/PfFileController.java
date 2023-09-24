package com.example.redmedicine.controller;

import com.example.redmedicine.domain.dto.PfFileDto;
import com.example.redmedicine.service.PfFileService;
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
@RequestMapping("/files/*")
public class PfFileController {
    private final PfFileService pfFileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/imgList")
    public List<PfFileDto> imgList(Long profileNumber){
        return pfFileService.pfFileList(profileNumber);
    }

    @GetMapping("/display")
    public byte[] display(String pfFileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir, pfFileName));
    }
}
