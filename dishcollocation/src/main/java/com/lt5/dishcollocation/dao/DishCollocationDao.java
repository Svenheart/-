package com.lt5.dishcollocation.dao;

import com.lt5.dishcollocation.entity.DishMenu;
import com.lt5.dishcollocation.entity.BookSet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program:com.lt5.dishcollocation.dao
 * @description:
 * @class:DishCollocationDao
 * @author:SanCheng
 * @create:2018-10-17
 **/
@Mapper
public interface DishCollocationDao {
	@Select(value = "insert into dreamweaver.t_dateMenu (dish_id,dish_date,meal_type,dish_price,dish_amount,store_id)" +
			"values(#{dishId},#{dishDate},#{mealType},#{dishPrice},#{dishAmount},#{storeId})")
	void addNewMenu(DishMenu dishMenu);

	@Select(value = "insert into dreamweaver.t_setting (store_id,days,setting_time)" +
			"values(#{storeId},#{days},#{settingTime})")
	void setMenuDays(BookSet bookSet);

	@Select(value = "select * from dreamweaver.t_setting where store_id=(#{storeId})")
	BookSet getMenuDays(int storeId);
}
