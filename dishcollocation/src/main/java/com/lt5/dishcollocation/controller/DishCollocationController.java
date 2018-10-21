package com.lt5.dishcollocation.controller;

import com.alibaba.fastjson.JSON;
import com.lt5.dishcollocation.entity.DishMenu;
import com.lt5.dishcollocation.entity.BookSet;
import com.lt5.dishcollocation.entity.TypeMenu;
import com.lt5.dishcollocation.service.DishCollocationService;
import com.lt5.dishcollocation.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:com.lt5.dishcollocation.controller
 * @description:
 * @class:DishCollocationController
 * @author:SanCheng
 * @create:2018-10-17
 **/
@RestController
public class DishCollocationController {
	@Autowired private Msg msg;
	@Autowired private DishCollocationService dishCollocationService;
	@RequestMapping(method = RequestMethod.POST,value = "/newMenu")
	@ResponseBody
	public Msg addNewMenu(@RequestParam String typeMenus,@RequestParam("isSeven") String isSeven){
		List<TypeMenu> typeMenuList= JSON.parseArray(typeMenus,TypeMenu.class);
		System.out.println(typeMenuList.toString());
		return msg;
	}

	@RequestMapping(method = RequestMethod.POST,value = "/menuDays")
	@ResponseBody
	public Msg setMenuDays(@RequestBody BookSet bookSet){
		msg=dishCollocationService.setMenuDays(bookSet);
		return msg;
	}

	@RequestMapping(method = RequestMethod.GET,value = "/menuDays")
	@ResponseBody
	public Msg getMenuDate(@RequestParam("storeId")int storeId){
		msg=dishCollocationService.getMenuDate(storeId);
		return msg;
	}
}
