package com.nursery.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.nursery.Config;
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

	/**
	 * 多文件上傳。
	 * 
	 * @author Administrator
	 * @param request
	 * @param response
	 * @param Id
	 * 
	 * */
	@RequestMapping(value = "uploadAttach/{Id}", method =
	{ RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String upload2(HttpServletRequest request,
			HttpServletResponse response, @PathVariable int Id)
			throws IllegalStateException, IOException
	{
		NurseryStock ns = service.findNurseryById(Id);
		String result = "";
		System.out.println(ns.getHelpCode());
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request))
		{
			System.out.println("jinrule!");
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext())
			{
				// 记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null)
				{
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "")
					{
						System.out.println(myFileName);
						// 重命名上传后的文件名
						String ext = ".unknown";
						if (myFileName != null)
						{
							int index = myFileName.lastIndexOf(".");
							ext = myFileName.substring(index + 1,
									myFileName.length());
						}
						String fileName = UUID.randomUUID() + "." + ext;
						// 定义上传路径
						String path = Config.getPath() + fileName;
						File localFile = new File(path);
						file.transferTo(localFile);
						ns.setAttach(path);
						service.edit(Id, ns);
						int finaltime = (int) System.currentTimeMillis();
						System.out.println(finaltime - pre);
						result = "上傳成功！";
					} else
					{
						result = "上传文件不能为空！";
					}
				} else
				{
					result = "上传文件不能为空！";
				}
			}
		} else
		{
			result = "Fail";
		}
		return result;
	}

}
