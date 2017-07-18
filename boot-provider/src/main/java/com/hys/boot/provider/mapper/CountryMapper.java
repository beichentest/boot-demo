package com.hys.boot.provider.mapper;

import java.util.List;

import com.hys.api.domain.CountryVo;
import com.hys.boot.provider.model.Country;
import com.hys.boot.provider.util.MyMapper;

public interface CountryMapper extends MyMapper<Country> {	
	public  List<Country> findAll();
	
	public List<CountryVo> findAllVo();
	
	public CountryVo findById(Integer id);
}