package com.nursery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.bean.NurseryStock;
import com.nursery.dao.NurseryStockDao;
import com.nursery.service.NurseryStockService;

@Service("nurseryStockService")
public class NurseryStockServiceImpl implements NurseryStockService
{

	@Autowired
	private NurseryStockDao nurseryStockDao;

	@Override
	public int edit(int id, NurseryStock ns)
	{
		return nurseryStockDao.edit(id, ns);
	}

	@Override
	public NurseryStock findNurseryById(int Id)
	{
		return nurseryStockDao.findNurseryById(Id);
	}

	@Override
	public List<NurseryStock> getAll()
	{
		return nurseryStockDao.getAll();
	}

	@Override
	public NurseryStock findNurseryByField(String key, String value)
	{
		return nurseryStockDao.findNurseryByField(key, value);
	}

	@Override
	public List<NurseryStock> findNurseryStocks(NurseryStock ns, int start,
			int size)
	{
		return nurseryStockDao.findNurseryStocks(ns, start, size);
	}

}
