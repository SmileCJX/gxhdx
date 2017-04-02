package com.gxhdx.controller;

import com.gxhdx.entity.Constants;
import com.gxhdx.entity.Signs;
import com.gxhdx.service.SignsService;
import com.gxhdx.support.ReqDto;
import com.gxhdx.support.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/signs")
public class SignsController {
	@Autowired
	private SignsService signsService;

	@RequiresPermissions({ "signs/list" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String index(Model model) {
		return "signs/index";
	}

	@RequiresPermissions({ "signs/list" })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String list(String title, String applyName, Boolean available, String startDate, String endDate,ReqDto req, Model model) {
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
					signsService.findList(title, applyName, available, sDate,eDate,req.getPageNo(), req.getPageSize()));
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "signs/list";
	}

	@RequiresPermissions({ "signs/add" })
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		return "signs/add";
	}

	@RequiresPermissions({ "signs/add" })
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(Signs entity, Model model) {
		try {
			entity = signsService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "signs/edit" })
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit(Long id, Model model) {
		try {
			Signs entity = signsService.getSigns(id);
			model.addAttribute("entity", entity);
		} catch (Exception e) {
			e.printStackTrace();
			return "common/error";
		}
		return "signs/edit";
	}

	@RequiresPermissions({ "signs/edit" })
	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public Object edit(Signs entity, Model model) {
		try {
			entity = signsService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequiresPermissions({ "signs/del" })
	@ResponseBody
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public Object del(String ids, Model model) {
		try {
			signsService.delBatch(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result();
	}

	@ResponseBody
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public Object apply(HttpServletRequest request, HttpServletResponse response,Signs entity, Model model) {
		try {
			HttpSession httpSession = request.getSession();
			if(httpSession.getAttribute(Constants.USER_NAME_KEY).toString().equals("游客")){
				return new Result(false,entity);
			}

			entity.setApplyName(httpSession.getAttribute(Constants.USER_NAME_KEY).toString());
			entity.setAvailable(false);
			entity = signsService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

}