package com.lt5.dishcollocation.controller;

import com.lt5.dishcollocation.entity.DateMenu;
import com.lt5.dishcollocation.entity.MenuSet;
import com.lt5.dishcollocation.service.DishCollocationService;
import com.lt5.dishcollocation.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
	public Msg addNewMenu(@RequestBody ArrayList<DateMenu> dateMenuArrayList){
		msg=dishCollocationService.addNewMenu(dateMenuArrayList);
		return msg;
	}

	@RequestMapping(method = RequestMethod.POST,value = "/menuDays")
	@ResponseBody
	public Msg setMenuDays(@RequestBody MenuSet menuSet){
		msg=dishCollocationService.setMenuDays(menuSet);
		return msg;
	}

	@RequestMapping(method = RequestMethod.GET,value = "/menuDays")
	@ResponseBody
	public Msg getMenuDate(@RequestParam("storeId")int storeId){
		msg=dishCollocationService.getMenuDate(storeId);
		return msg;
	}
}
