package com.gxhdx.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxhdx.entity.Department;
import com.gxhdx.service.DepartmentService;
import com.gxhdx.support.ReqDto;
import com.gxhdx.support.Result;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@RequiresPermissions({ "department/list" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(Model model) {
		return "department/index";
	}

	@RequiresPermissions({ "department/list" })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(String dno, String name, String ministerName, String ministerPhone, Integer totalPersons, String description, String startDate, String endDate,ReqDto req, Model model) {
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
					departmentService.findList(dno, name, ministerName, ministerPhone, totalPersons, description, sDate,eDate,req.getPageNo(), req.getPageSize()));
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "department/list";
	}

	@RequiresPermissions({ "department/add" })
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		return "department/add";
	}

	@RequiresPermissions({ "department/add" })
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(Department entity, Model model) {
		try {
			entity = departmentService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "department/edit" })
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit(Long id, Model model) {
		try {
			Department entity = departmentService.getDepartment(id);
			model.addAttribute("entity", entity);
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "department/edit";
	}

	@RequiresPermissions({ "department/edit" })
	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Object edit(Department entity, Model model) {
		try {
			entity = departmentService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "department/del" })
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(String ids, Model model) {
		try {
			departmentService.delBatch(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result();
	}

}