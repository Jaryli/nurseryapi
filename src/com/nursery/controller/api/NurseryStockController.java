package com.nursery.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nursery.bean.NurseryStock;
import com.nursery.service.NurseryStockService;

@Controller
public class NurseryStockController
{
	@Autowired
	private NurseryStockService service;

	@RequestMapping(value = "updateNurseryStock", method =
	{ RequestMethod.POST })
	@ResponseBody
	public String updateNurseryStock(NurseryStock ns)
	{
		try
		{
			service.edit(ns.getId(), ns);
			return "success";
		} catch (Exception ex)
		{
			return "fail";
		}
	}

	@RequestMapping(value = "findNurseryById/{Id}", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public NurseryStock findNurseryById(HttpServletRequest request,
			@PathVariable int Id)
	{
		NurseryStock ns = new NurseryStock();
		try
		{
			ns = service.findNurseryById(Id);
		} catch (Exception ex)
		{
			return null;
		}
		return ns;
	}

	@RequestMapping(value = "getAll", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<NurseryStock> getAll()
	{
		List<NurseryStock> nslist = new ArrayList<NurseryStock>();
		try
		{
			nslist = service.getAll();
			System.out.println("::::::::::::::;" + nslist.size());
		} catch (Exception ex)
		{
			return null;
		}
		return nslist;
	}

	@RequestMapping(value = "findNurseryByField", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public NurseryStock findNurseryByField(HttpServletRequest request,
			@RequestBody String key, @RequestBody String value)
	{
		NurseryStock ns = new NurseryStock();
		try
		{
			ns = service.findNurseryByField(key, value);
		} catch (Exception ex)
		{
			return null;
		}
		return ns;
	}

	@RequestMapping(value = "findNurseryStocks", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<NurseryStock> findNurseryStocks(
			@ModelAttribute NurseryStock nstock,
			@RequestParam("page") int page, @RequestParam("rows") int rows)
	{
		List<NurseryStock> nslist = new ArrayList<NurseryStock>();
		try
		{
			nslist = service.findNurseryStocks(nstock, page, rows);
		} catch (Exception ex)
		{
			return null;
		}
		return nslist;
	}
}
