package com.gxhdx.controller;

import com.gxhdx.entity.Activity;
import com.gxhdx.service.ActivityService;
import com.gxhdx.service.ActivityTypeService;
import com.gxhdx.service.DepartmentService;
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
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	private ActivityService activityService;

	@Autowired
	private ActivityTypeService activityTypeService;

	@Autowired
	private DepartmentService departmentService;

	@RequiresPermissions({ "activity/list" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(Model model) {
		return "activity/index";
	}

	@RequiresPermissions({ "activity/list" })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(String title, String content, String keyword, String url, String depatement, String sponsor, String sponsorPhone, Integer hits, String remark, Boolean available, String imgUrl, String startDate, String endDate,ReqDto req, Model model) {
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
					activityService.findList(title, content, keyword, url, depatement, sponsor, sponsorPhone, hits, remark, available, imgUrl, sDate,eDate,req.getPageNo(), req.getPageSize()));
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "activity/list";
	}

	@RequiresPermissions({ "activity/add" })
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		model.addAttribute("departments",departmentService.findAll());
		model.addAttribute("activityTypes",activityTypeService.findAll());
		return "activity/add";
	}

	@RequiresPermissions({ "activity/add" })
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(Activity entity, Model model,Long department_id,Long activityType_id) {
		try {
			entity = activityService.saveOrUpdate(entity,department_id,activityType_id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "activity/edit" })
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit(Long id, Model model) {
		try {
			Activity entity = activityService.getActivity(id);
			model.addAttribute("departments",departmentService.findAll());
			model.addAttribute("activityTypes",activityTypeService.findAll());
			model.addAttribute("entity", entity);
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "activity/edit";
	}

	@RequiresPermissions({ "activity/edit" })
	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Object edit(Activity entity, Model model,Long department_id,Long activitytype_id) {
		try {
			entity = activityService.saveOrUpdate(entity,department_id,activitytype_id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "activity/del" })
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(String ids, Model model) {
		try {
			activityService.delBatch(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result();
	}

}