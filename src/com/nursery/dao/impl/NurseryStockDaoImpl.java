package com.nursery.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nursery.bean.NurseryStock;
import com.nursery.dao.NurseryStockDao;
import com.nursery.util.StringUtil;

@Repository("nurseryStockDao")
public class NurseryStockDaoImpl implements NurseryStockDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public int edit(final int id, final NurseryStock ns)
	{
		String sql = "update NurseryStock set TXiongJing=?,TGanJing=?,THeight=?,TDiJing=?,TDiameter=?,TThickness=?,TPengXing=?,NewPrice=?,Remark=? where Id=?";
		int updated = jdbcTemplate.update(sql, new PreparedStatementSetter()
		{

			@Override
			public void setValues(PreparedStatement ps) throws SQLException
			{
				ps.setDouble(1, ns.getTXiongJing());
				ps.setDouble(2, ns.getTGanJing());
				ps.setDouble(3, ns.getTHeight());
				ps.setDouble(4, ns.getTDiJing());
				ps.setString(5, ns.getTDiameter());
				ps.setString(6, ns.getTThickness());
				ps.setString(7, ns.getTPengXing());
				ps.setDouble(8, ns.getNewPrice());
				ps.setString(9, ns.getRemark());
				ps.setDouble(10, id);
			}
		});
		return updated;
	}

	@Override
	public NurseryStock findNurseryById(int Id)
	{
		return hibernateTemplate.get(NurseryStock.class, Id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NurseryStock> getAll()
	{
		return hibernateTemplate.find("From NurseryStock WHERE 1=1 ");
	}

	@SuppressWarnings("unchecked")
	@Override
	public NurseryStock findNurseryByField(String key, String value)
	{
		DetachedCriteria criteria = DetachedCriteria
				.forClass(NurseryStock.class);
		if (StringUtil.isNotEmpty(value))
		{
			criteria.add(Restrictions.eq(key, value));
		}
		List<NurseryStock> list = hibernateTemplate.findByCriteria(criteria);
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NurseryStock> findNurseryStocks(NurseryStock ns, int start,
			int size)
	{
		DetachedCriteria criteria = DetachedCriteria
				.forClass(NurseryStock.class);
		if (StringUtil.isNotEmpty(ns.getTreeName()))
		{
			criteria.add(Restrictions.like("TreeName", "%" + ns.getTreeName()
					+ "%"));
		}
		if (StringUtil.isNotEmpty(ns.getHelpCode()))
		{
			criteria.add(Restrictions.like("HelpCode", "%" + ns.getHelpCode()
					+ "%"));
		}
		criteria.addOrder(Order.desc("PostTime"));
		return hibernateTemplate.findByCriteria(criteria, start, size);
	}

}
