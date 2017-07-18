package com.hys.boot.provider.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hys.api.domain.CountryVo;
import com.hys.api.service.CountryService;
import com.hys.boot.provider.mapper.CountryMapper;

@Service
@CacheConfig(cacheNames = "country")
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryMapper countryDao;
	@Override
	public List<CountryVo> getAll(CountryVo country) {
		if (country.getPage() != null && country.getRows() != null) {
            PageHelper.startPage(country.getPage(), country.getRows());
        }
		return countryDao.findAllVo(); 
	}
	@Override
	@Cacheable(key="#id") 
	public CountryVo getById(Integer id) {
		return countryDao.findById(id);
	}
}
