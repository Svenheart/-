package com.lt5.dishcollocation.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lt5.dishcollocation.dao.DishCollocationDao;
import com.lt5.dishcollocation.entity.DateMenu;
import com.lt5.dishcollocation.entity.MenuSet;
import com.lt5.dishcollocation.service.DishCollocationService;
import com.lt5.dishcollocation.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @program:com.lt5.dishcollocation.serviceimpl
 * @description:
 * @class:DishCollocationServiceImp
 * @author:SanCheng
 * @create:2018-10-17
 **/
@Service
public class DishCollocationServiceImp implements DishCollocationService {

	@Autowired private Msg msg;

	@Autowired private DishCollocationDao dishCollocationDao;

	private ArrayList<Date> dates=new ArrayList<>();
	private Calendar calendar=Calendar.getInstance();

	@Override
	public Msg addNewMenu(ArrayList<DateMenu> dateMenuArrayList) {
		try{
			if(dateMenuArrayList.get(0).getIsSevenDay().equals("true")){
				for(int i=0;i<7;i++){
					calendar.setTime(dateMenuArrayList.get(0).getDishDate());
					calendar.add(Calendar.DATE,i);
					dateMenuArrayList.get(i).setDishDate(calendar.getTime());
					for(int j=0;j<dateMenuArrayList.size();j++){
						dishCollocationDao.addNewMenu(dateMenuArrayList.get(j));
					}
				}
			}
			else {
				for(int j=0;j<dateMenuArrayList.size();j++){
					dishCollocationDao.addNewMenu(dateMenuArrayList.get(j));
				}
			}
			msg.setimformation("保存菜谱成功");
		}catch (Exception e){
			msg.setStatus(0);
			msg.setErrorTip("");
			msg.setimformation("保存菜谱失败");
		}
		msg.setStatus(1);
		msg.setErrorTip("");
		return msg;
	}

	@Override
	public Msg setMenuDays(MenuSet menuSet) {
		try{
			dishCollocationDao.setMenuDays(menuSet);
			msg.setimformation("设置成功");
		}catch (Exception e){
			msg.setStatus(0);
			msg.setErrorTip("");
			msg.setimformation("设置失败");
		}
		msg.setStatus(1);
		msg.setErrorTip("");
		return msg;
	}

	@Override
	public Msg getMenuDate(int storeId) {
		try{
			dates=new ArrayList<>();
			MenuSet menuSet=dishCollocationDao.getMenuDays(storeId);
			calendar.setTime(menuSet.getSettingTime());
			dates.add(menuSet.getSettingTime());
			for(int i=0;i<menuSet.getDays();i++){
				calendar.add(Calendar.DATE,1);
				dates.add(calendar.getTime());
			}
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			msg.setimformation(gson.toJson(dates));
		}catch (Exception e){
			msg.setStatus(0);
			msg.setErrorTip("");
			msg.setimformation("获取失败");
		}
		msg.setStatus(1);
		msg.setErrorTip("");
		return msg;
	}
}
