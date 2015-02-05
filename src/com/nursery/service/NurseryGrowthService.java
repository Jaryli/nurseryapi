package com.nursery.service;

import java.util.List;

import com.nursery.bean.NurseryGrowth;

public interface NurseryGrowthService
{
	public abstract int Add(NurseryGrowth ng);

	public abstract List<NurseryGrowth> getHistoryByNurseryId(int nurseryId);
}
