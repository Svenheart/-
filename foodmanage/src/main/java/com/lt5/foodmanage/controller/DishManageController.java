package com.lt5.foodmanage.controller;

import com.alibaba.fastjson.JSON;
import com.lt5.foodmanage.entity.DishMenu;
import com.lt5.foodmanage.service.DishManageService;
import com.lt5.foodmanage.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


/**
 * @program:com.lt5.foodmanage.controller
 * @description:
 * @class:DishManageController
 * @author:SanCheng
 * @create:2018-10-16
 **/
@RestController
public class DishManageController {

	private Msg msg=new Msg();

	@Autowired
	private DishManageService dishManageService;

	@RequestMapping(method = RequestMethod.GET,value = "/dish")
	@ResponseBody
	public Msg listDish(@RequestParam int storeId,@RequestParam int pageNum,
	                     @RequestParam int pageSize){
		msg=dishManageService.listDish(storeId,pageNum,pageSize);
		return msg;
	}

	@RequestMapping(method = RequestMethod.GET,value = "/someDish")
	@ResponseBody
	public Msg listSomeDish(@RequestParam int storeId,@RequestParam String condition,@RequestParam int pageNum,
	                    @RequestParam int pageSize){
		msg=dishManageService.listSomeDish(storeId,condition,pageNum,pageSize);
		return msg;
	}

	@RequestMapping(method = RequestMethod.POST,value = "/dish")
	@ResponseBody
	public Msg addDish(@RequestBody DishMenu dishMenu){
		msg=dishManageService.addDish(dishMenu);
		return msg;
	}

	@RequestMapping(method = RequestMethod.POST,value = "/updateDish")
	@ResponseBody
	public Msg updateDish(@RequestParam String dishMenu){
		DishMenu dishMenu1=JSON.parseObject(dishMenu,DishMenu.class);
		msg=dishManageService.updateDish(dishMenu1);
		return msg;
	}

	@RequestMapping(method = RequestMethod.POST,value = "/deleteDish")
	@ResponseBody
	public Msg deleteDish(@RequestBody DishMenu dishMenu){
		msg=dishManageService.deleteDish(dishMenu);
		return msg;
	}

	@RequestMapping(method = RequestMethod.POST,value = "/deleteSomeDish")
	@ResponseBody
	public Msg deleteSomeDish(@RequestParam String dishMenus){
		List<DishMenu> dishMenuList=JSON.parseArray(dishMenus,DishMenu.class);
		msg=dishManageService.deleteSomeDish(dishMenuList);
		return msg;
	}
}
