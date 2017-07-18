package com.hys.api.service;

import java.util.List;

import com.hys.api.domain.CountryVo;

public interface CountryService {
	public List<CountryVo> getAll(CountryVo country);
	
	public CountryVo getById(Integer id);
}
