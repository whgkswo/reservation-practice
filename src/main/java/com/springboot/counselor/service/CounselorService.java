package com.springboot.counselor.service;

import com.springboot.auth.utils.CustomAuthorityUtils;
import com.springboot.counselor.entity.Counselor;
import com.springboot.counselor.repository.CounselorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CounselorService {
    private final CounselorRepository counselorRepository;
    private final CustomAuthorityUtils customAuthorityUtils;
    private final PasswordEncoder passwordEncoder;
    public Counselor createCounselor(Counselor counselor){
        String encryptedPassword = passwordEncoder.encode(counselor.getPassword());
        counselor.setPassword(encryptedPassword);

        List<String> roles = customAuthorityUtils.createRoles(counselor.getUserId());
        counselor.setRoles(roles);

        return counselorRepository.save(counselor);
    }
}
