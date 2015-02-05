package com.nursery.dao;

import java.util.List;

import com.nursery.bean.NurseryGrowth;

public interface NurseryGrowthDao
{
	public abstract int Add(NurseryGrowth ng);

	public abstract List<NurseryGrowth> getHistoryByNurseryId(int nurseryId);
}
