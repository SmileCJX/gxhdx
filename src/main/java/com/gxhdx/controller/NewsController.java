package com.gxhdx.controller;

import com.gxhdx.entity.News;
import com.gxhdx.service.AcademyService;
import com.gxhdx.service.NewsService;
import com.gxhdx.support.ReqDto;
import com.gxhdx.support.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	@Autowired
	private AcademyService academyService;

	@RequiresPermissions({ "news/list" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(Model model) {
		return "news/index";
	}

	@RequiresPermissions({ "news/list" })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(String title, String content, String publisher, String keyword, String url, String picurl, Integer hits, String startDate, String endDate,Boolean available,ReqDto req, Model model) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date sDate = null;
			Date eDate = null;
			if (null != startDate && !"".equals(startDate)) {
				sDate = dateFormat.parse(startDate);
			}
			if (null != endDate && !"".equals(endDate)) {
				eDate = dateFormat.parse(endDate);
				Calendar cal = Calendar.getInstance();
				cal.setTime(eDate);
				cal.add(Calendar.DATE, 1);
				eDate = cal.getTime();
			}
			model.addAttribute(
					"list",
					newsService.findList(title, content, publisher, keyword, url, picurl, hits, sDate,eDate,req.getPageNo(), req.getPageSize(),available));
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "news/list";
	}

	@RequiresPermissions({ "news/add" })
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		model.addAttribute("academys",academyService.findAll());
		return "news/add";
	}

	@RequiresPermissions({ "news/add" })
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(News entity, Model model) {
		try {
			entity = newsService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "news/edit" })
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit(Long id, Model model) {
		try {
			News entity = newsService.getNews(id);
			model.addAttribute("entity", entity);
			model.addAttribute("academys",academyService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "news/edit";
	}

	@RequiresPermissions({ "news/edit" })
	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Object edit(News entity, Model model) {
		try {
			entity = newsService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "news/del" })
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(String ids, Model model) {
		try {
			newsService.delBatch(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result();
	}

}