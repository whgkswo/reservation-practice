package com.springboot.counselor.controller;

import com.springboot.counselor.dto.CounselorDto;
import com.springboot.counselor.entity.Counselor;
import com.springboot.counselor.mapper.CounselorMapper;
import com.springboot.counselor.service.CounselorService;
import com.springboot.utils.UriCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/counselors")
@AllArgsConstructor
public class CounselorController {
    private final String DEFAULT_URL = "/counselors";
    private final CounselorMapper counselorMapper;
    private final CounselorService counselorService;
    @PostMapping
    public ResponseEntity<Counselor> postCounselor(@RequestBody CounselorDto.Post postDto){
        Counselor tempCounselor = counselorMapper.counselorPostDtoToCounselor(postDto);
        Counselor savedCounselor = counselorService.createCounselor(tempCounselor);

        URI location = UriCreator.createUri(DEFAULT_URL, savedCounselor.getCounselorId());
        return ResponseEntity.created(location).build();
    }
}
