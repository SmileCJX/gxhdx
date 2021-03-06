package com.gxhdx.gencode;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class ActivityGenerate {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Map data = new HashMap();
		data.put("className", "Activity"); // 类名
		data.put("classCnName", "活动管理"); // 中文名
		List pros = new ArrayList();
		pros.add(new GenProperty("title", "活动标题", String.class.getSimpleName(),
				"like",true));
		pros.add(new GenProperty("content", "活动内容", String.class.getSimpleName(),
				"like",true));
		pros.add(new GenProperty("keyword", "活动关键字", String.class.getSimpleName(),
				"like",true));
		pros.add(new GenProperty("url", "活动相关连接", String.class.getSimpleName(),
				"like",false));
		pros.add(new GenProperty("depatement", "活动主办部门", String.class.getSimpleName(),
				"eq",false));
		pros.add(new GenProperty("sponsor", "活动承办人员", String.class.getSimpleName(),
				"eq",true));
		pros.add(new GenProperty("sponsorPhone", "活动承办人联系电话", String.class.getSimpleName(),
				"eq",true));
		pros.add(new GenProperty("hits", "浏览数", Integer.class.getSimpleName(),
				"eq",false));
		pros.add(new GenProperty("remark", "活动备注", String.class.getSimpleName(),
				"eq",true));
		pros.add(new GenProperty("available", "是否有效", Boolean.class.getSimpleName(),
				"eq",true));
		pros.add(new GenProperty("imgUrl", "活动图片", String.class.getSimpleName(),
				"eq",true));
		data.put("properties", pros);
		createH(data);
		createF(data);
	}

	@SuppressWarnings({ "rawtypes" })
	public static void createH(Map data) {
		// 模拟数据源
		String className = "Activity";
		
		String dir;
		/* 生成entity */
		dir = System.getProperty("user.dir")
				+ "/src/main/java/com/gxhdx/entity/";// 生成路径
		gen(dir, className, "", "com.gxhdx.entity", "entity.html", data);
		System.out.println("生成entity结束...");
		/* 生成dao */
		dir = System.getProperty("user.dir")
				+ "/src/main/java/com/gxhdx/dao/";// 生成路径
		gen(dir, className, "dao", "com.gxhdx.dao", "dao.html", data);
		System.out.println("生成dao结束...");
		/* 生成daoImpl */
		dir = System.getProperty("user.dir")
				+ "/src/main/java/com/gxhdx/dao/";// 生成路径
		gen(dir, className, "daoImpl", "com.gxhdx.dao", "daoImpl.html", data);
		System.out.println("生成daoImpl结束...");
		/* 生成service */
		dir = System.getProperty("user.dir")
				+ "/src/main/java/com/gxhdx/service/";// 生成路径
		gen(dir, className, "service", "com.gxhdx.service", "service.html",
				data);
		System.out.println("生成service结束...");
		/* 生成daoImpl */
		dir = System.getProperty("user.dir")
				+ "/src/main/java/com/gxhdx/service/";// 生成路径
		gen(dir, className, "serviceImpl", "com.gxhdx.service",
				"serviceImpl.html", data);
		System.out.println("生成daoImpl结束...");
		/* 生成controller */
		dir = System.getProperty("user.dir")
				+ "/src/main/java/com/gxhdx/controller/";// 生成路径
		gen(dir, className, "controller", "com.gxhdx.controller",
				"controller.html", data);
		System.out.println("生成controller结束...");
	}

	@SuppressWarnings({ "rawtypes" })
	public static void createF(Map data) {
		String dir;

		/* 生成edit */
		dir = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/view/activity/";// 生成路径
		genPage(dir, "edit", "edit.html", data);
		System.out.println("生成edit结束...");
		/* 生成add */
		dir = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/view/activity/";// 生成路径
		genPage(dir, "add", "add.html", data);
		System.out.println("生成add结束...");
		/* 生成index */
		dir = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/view/activity/";// 生成路径
		genPage(dir, "index", "index.html", data);
		System.out.println("生成index结束...");
		/* 生成list */
		dir = System.getProperty("user.dir")
				+ "/src/main/webapp/WEB-INF/view/activity/";// 生成路径
		genPage(dir, "list", "list.html", data);
		System.out.println("生成list结束...");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void gen(String dir, String className, String type,
			String packageName, String template, Map data) {
		Configuration cfg = new Configuration();

		try {
			data.put("package", packageName); // 包名
			if ("service".equals(type)) {
				className += "Service";
			}
			if ("serviceImpl".equals(type)) {
				className += "ServiceImpl";
			}
			if ("dao".equals(type)) {
				className += "Dao";
			}
			if ("daoImpl".equals(type)) {
				className += "DaoImpl";
			}
			if ("controller".equals(type)) {
				className += "Controller";
			}
//			cfg.setClassForTemplateLoading(ActivityGenerate.class,
//					"/com/gxhdx/gencode/template"); // 指定模板所在的classpath目录
			// Set the preferred charset template files are stored in. UTF-8 is
			// a good choice in most applications:
			cfg.setDefaultEncoding("UTF-8");

			// Sets how errors will appear.
			// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			cfg.setSharedVariable("upperFC", new UpperFirstCharacter()); // 添加一个"宏"共享变量用来将属性名首字母大写
			cfg.setSharedVariable("lowerFC", new LowerFirstCharacter()); // 添加一个"宏"共享变量用来将属性名首字母大写
			Template t = cfg.getTemplate("src/main/java/com/gxhdx/gencode/template/"+template); // 指定模板

			FileOutputStream fos = new FileOutputStream(new File(dir
					+ className + ".java")); // java文件的生成目录
			t.process(data, new OutputStreamWriter(fos, "utf-8")); //
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public static void genPage(String dir, String fileName, String template,
			Map data) {
		Configuration cfg = new Configuration();

		try {

//			cfg.setClassForTemplateLoading(ActivityGenerate.class,
//					"/com/gxhdx/gencode/template"); // 指定模板所在的classpath目录
//			cfg.setDirectoryForTemplateLoading(new File("\\template"));
			// Set the preferred charset template files are stored in. UTF-8 is
			// a good choice in most applications:
			cfg.setDefaultEncoding("UTF-8");
			// Sets how errors will appear.
			// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			cfg.setSharedVariable("upperFC", new UpperFirstCharacter()); // 添加一个"宏"共享变量用来将属性名首字母大写
			cfg.setSharedVariable("lowerFC", new LowerFirstCharacter()); // 添加一个"宏"共享变量用来将属性名首字母大写
			Template t = cfg.getTemplate("src/main/java/com/gxhdx/gencode/template/"+template); // 指定模板

			File file = new File(dir);
			if (!file.exists()) {
				file.mkdirs();
			}

			FileOutputStream fos = new FileOutputStream(new File(dir + fileName
					+ ".jsp")); // java文件的生成目录
			t.process(data, new OutputStreamWriter(fos, "utf-8")); //
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}