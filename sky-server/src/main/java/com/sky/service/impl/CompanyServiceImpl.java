package com.sky.service.impl;

import com.sky.entity.Company;
import com.sky.mapper.AccountMapper;
import com.sky.mapper.CompanyMapper;
import com.sky.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public Company getById(Long id) {
        return companyMapper.getById(id);
    }
}
