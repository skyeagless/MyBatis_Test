package com.mybatis.mapper;

import com.skyeagle.mybatisTest.model.Country;

import java.util.List;

public interface CountryMapper {
    List<Country> selectAll();
}
