package com.lt5.foodmanage.controller;

import com.github.pagehelper.PageHelper;
import com.lt5.foodmanage.entity.DishMenu;
import com.lt5.foodmanage.service.DishManageService;
import com.lt5.foodmanage.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public Msg listDish(@RequestParam int storeId,@RequestParam String condition,@RequestParam int pageNum,
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

	@RequestMapping(method = RequestMethod.PUT,value = "/dish")
	@ResponseBody
	public Msg updateDish(@RequestBody DishMenu dishMenu){
		msg=dishManageService.updateDish(dishMenu);
		return msg;
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/dish")
	@ResponseBody
	public Msg listDish(@RequestBody DishMenu dishMenu){
		msg=dishManageService.deleteDish(dishMenu);
		return msg;
	}
}
