package com.gxhdx.controller;

import com.gxhdx.entity.ActivityType;
import com.gxhdx.service.ActivityTypeService;
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
@RequestMapping("/activitytype")
public class ActivityTypeController {
	@Autowired
	private ActivityTypeService activityTypeService;

	@RequiresPermissions({ "activitytype/list" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(Model model) {
		return "activitytype/index";
	}

	@RequiresPermissions({ "activitytype/list" })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(String typeName, String introduction, String startDate, String endDate,ReqDto req, Model model) {
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
					activityTypeService.findList(typeName, introduction, sDate,eDate,req.getPageNo(), req.getPageSize()));
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "activitytype/list";
	}

	@RequiresPermissions({ "activitytype/add" })
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		return "activitytype/add";
	}

	@RequiresPermissions({ "activitytype/add" })
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(ActivityType entity, Model model) {
		try {
			entity = activityTypeService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "activitytype/edit" })
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit(Long id, Model model) {
		try {
			ActivityType entity = activityTypeService.getActivityType(id);
			model.addAttribute("entity", entity);
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "activitytype/edit";
	}

	@RequiresPermissions({ "activitytype/edit" })
	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Object edit(ActivityType entity, Model model) {
		try {
			entity = activityTypeService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "activitytype/del" })
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(String ids, Model model) {
		try {
			activityTypeService.delBatch(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result();
	}

}