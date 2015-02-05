package com.nursery.dao;

import java.util.List;

import com.nursery.bean.NurseryStock;

public interface NurseryStockDao
{
	public abstract int edit(int id, NurseryStock ns);

	public abstract NurseryStock findNurseryById(int Id);

	public abstract List<NurseryStock> getAll();

	public abstract NurseryStock findNurseryByField(String key, String value);

	public abstract List<NurseryStock> findNurseryStocks(NurseryStock ns,
			int start, int size);

}
