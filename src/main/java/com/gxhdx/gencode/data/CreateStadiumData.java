package com.gxhdx.gencode.data;

import com.gxhdx.gencode.GenProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/23/023.
 */
public class CreateStadiumData {
    public static void createDate(){
        Map data = new HashMap();
        data.put("className", "Stadium"); // 类名
        data.put("classCnName", "球场管理"); // 中文名
        List pros = new ArrayList();
        pros.add(new GenProperty("city", "所属城市", String.class.getSimpleName(),
                "eq",true));
        pros.add(new GenProperty("area", "所属区域", String.class.getSimpleName(),
                "eq",true));
        pros.add(new GenProperty("name", "球场名称", String.class.getSimpleName(),
                "like",true));
        pros.add(new GenProperty("siteType", "球场类型", String.class
                .getSimpleName(), "eq",true));
        pros.add(new GenProperty("sod", "草皮类型", String.class.getSimpleName(),
                "eq",true));
        pros.add(new GenProperty("lamplight", "灯光情况", String.class
                .getSimpleName(), "eq",true));
        pros.add(new GenProperty("addr", "详细地址", String.class.getSimpleName(),
                "like",true));
        pros.add(new GenProperty("openTime", "开放时间", String.class
                .getSimpleName(), "like",true));
        pros.add(new GenProperty("siteInfo", "球场简介", String.class
                .getSimpleName(), "like",true));
        pros.add(new GenProperty("contMan", "联系人",
                String.class.getSimpleName(), "eq",false));
        pros.add(new GenProperty("contQQ", "QQ", String.class.getSimpleName(),
                "eq",true));
        pros.add(new GenProperty("contQqun", "QQ群", String.class
                .getSimpleName(), "eq",false));
        pros.add(new GenProperty("contWx", "微信", String.class.getSimpleName(),
                "eq",false));
        pros.add(new GenProperty("contWb", "微博", String.class.getSimpleName(),
                "eq",false));
        pros.add(new GenProperty("contPhone", "联系电话", String.class
                .getSimpleName(), "eq",true));
        pros.add(new GenProperty("showImg", "球场缩略图", String.class
                .getSimpleName(), "",false));
        data.put("properties", pros);
    }
}
