package com.nursery.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nursery.bean.NurseryGrowth;
import com.nursery.dao.NurseryGrowthDao;

@Repository("nurseryGrowthDao")
public class NurseryGrowthDaoImpl implements NurseryGrowthDao
{
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public int Add(NurseryGrowth ng)
	{
		try
		{
			hibernateTemplate.save(ng);
			return 1;
		} catch (Exception e)
		{
			return -1;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NurseryGrowth> getHistoryByNurseryId(int nurseryId)
	{
		return hibernateTemplate.find("FROM NurseryGrowth WHERE PkId="
				+ nurseryId);
	}

}
