package com.nursery.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nursery.bean.NurseryGrowth;
import com.nursery.service.NurseryGrowthService;

@Controller
public class NurseryGrowthController
{
	@Autowired
	private NurseryGrowthService service;

	/**
	 * 上传生长记录
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "uploadGrowth", method =
	{ RequestMethod.POST })
	@ResponseBody
	public String uploadGrowth(HttpServletRequest request,
			@RequestBody NurseryGrowth nurseryGrowth)
	{
		try
		{
			service.Add(nurseryGrowth);
			return "Success";
		} catch (Exception ex)
		{
			System.err.println("TreeName:" + nurseryGrowth.getTreeGuid()
					+ ",pkId:" + nurseryGrowth.getPkId());
			ex.printStackTrace();
			return "Fail";
		}
	}

	/**
	 * 获取生长记录
	 * 
	 * @param nurseryId
	 * @return List
	 */
	@RequestMapping(value = "findNurseryGrowthByNurseryId/{nurseryId}", method =
	{ RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<NurseryGrowth> findNurseryGrowthByNurseryId(
			@PathVariable int nurseryId)
	{
		List<NurseryGrowth> items = service.getHistoryByNurseryId(nurseryId);
		return items;
	}
}
