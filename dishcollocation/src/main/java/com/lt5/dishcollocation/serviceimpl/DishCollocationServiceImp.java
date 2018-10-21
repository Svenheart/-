package com.lt5.dishcollocation.serviceimpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lt5.dishcollocation.dao.DishCollocationDao;
import com.lt5.dishcollocation.entity.DishMenu;
import com.lt5.dishcollocation.entity.BookSet;
import com.lt5.dishcollocation.entity.TypeMenu;
import com.lt5.dishcollocation.service.DishCollocationService;
import com.lt5.dishcollocation.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Msg addNewMenu(ArrayList<TypeMenu> dishMenuArrayList,String isSeven) {
		try{
			if(isSeven.equals("true")){
				for(int i=0;i<7;i++){
					calendar.setTime(dishMenuArrayList.get(0).getDishMenus().get(0).getDishDate());
					calendar.add(Calendar.DATE,i);
					dishMenuArrayList.get(0).getDishMenus().get(i).setDishDate(calendar.getTime());
					for(int j = 0; j< dishMenuArrayList.size(); j++){
						dishCollocationDao.addNewMenu(dishMenuArrayList.get(0).getDishMenus().get(j));
					}
					dishMenuArrayList.get(1).getDishMenus().get(i).setDishDate(calendar.getTime());
					for(int j = 0; j< dishMenuArrayList.size(); j++){
						dishCollocationDao.addNewMenu(dishMenuArrayList.get(1).getDishMenus().get(j));
					}
					dishMenuArrayList.get(2).getDishMenus().get(i).setDishDate(calendar.getTime());
					for(int j = 0; j< dishMenuArrayList.size(); j++){
						dishCollocationDao.addNewMenu(dishMenuArrayList.get(2).getDishMenus().get(j));
					}
				}
			}
			else {
				for(int j = 0; j< dishMenuArrayList.size(); j++){
					dishMenuArrayList.get(0).getDishMenus().get(j).setMealType("早餐");
					dishCollocationDao.addNewMenu(dishMenuArrayList.get(0).getDishMenus().get(j));
				}
				for(int j = 0; j< dishMenuArrayList.size(); j++){
					dishMenuArrayList.get(0).getDishMenus().get(j).setMealType("午餐");
					dishCollocationDao.addNewMenu(dishMenuArrayList.get(1).getDishMenus().get(j));
				}
				for(int j = 0; j< dishMenuArrayList.size(); j++){
					dishMenuArrayList.get(0).getDishMenus().get(j).setMealType("晚餐");
					dishCollocationDao.addNewMenu(dishMenuArrayList.get(2).getDishMenus().get(j));
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
	public Msg setMenuDays(BookSet bookSet) {
		try{
			dishCollocationDao.setMenuDays(bookSet);
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
			BookSet bookSet =dishCollocationDao.getMenuDays(storeId);
			calendar.setTime(bookSet.getSettingTime());
			dates.add(bookSet.getSettingTime());
			for(int i = 0; i< bookSet.getDays(); i++){
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
