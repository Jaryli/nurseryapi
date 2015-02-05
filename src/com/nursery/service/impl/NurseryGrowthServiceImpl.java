package com.nursery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.bean.NurseryGrowth;
import com.nursery.dao.NurseryGrowthDao;
import com.nursery.service.NurseryGrowthService;

@Service("nurseryGrowthService")
public class NurseryGrowthServiceImpl implements NurseryGrowthService
{
	@Autowired
	private NurseryGrowthDao nurseryGrowthDao;

	@Override
	public int Add(NurseryGrowth ng)
	{
		return nurseryGrowthDao.Add(ng);
	}

	@Override
	public List<NurseryGrowth> getHistoryByNurseryId(int nurseryId)
	{
		return nurseryGrowthDao.getHistoryByNurseryId(nurseryId);
	}

}
