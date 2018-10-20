package com.lt5.foodmanage.dao;

import com.lt5.foodmanage.entity.DishMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.ArrayList;


/**
 * @program:com.lt5.foodmanage.dao
 * @description:
 * @class:DishManageDao
 * @author:SanCheng
 * @create:2018-10-16
 **/
@Mapper
public interface DishManageDao {
	/**
	 * 查询菜品
	 */
	@Select(value = "select * from dreamweaver.t_cookbook where store_id=#{storeId}")
	ArrayList<DishMenu> listDish(int storeId);

	/**
	 * 按条件查询菜品
	 */
	@Select(value = "SELECT * FROM dreamweaver.t_cookbook where (store_id=#{storeId} and dish_name like #{condition}) or (store_id=#{storeId} and cuisine like #{condition})")
	ArrayList<DishMenu> listSomeDish(@Param(value = "storeId") int storeId,@Param(value = "condition") String condition);

	/**
	 * 增加菜品
	 */
	@Select(value = "insert into dreamweaver.t_cookbook (dish_id,dish_name,dish_price,dish_image,cuisine,store_id) " +
			"values(#{dishId},#{dishName},#{dishPrice},#{dishImage},#{cuisine},#{storeId})")
	void addDish(DishMenu dishMenu);

	/**
	 * 更新菜品
	 */
	@Select(value = "update dreamweaver.t_cookbook set dish_id=#{newDishId},dish_name=#{dishName},dish_price=#{dishPrice}," +
			"cuisine=#{cuisine},store_id=#{storeId} where dish_id=#{dishId}")
	void updateDish(DishMenu dishMenu);

	/**
	 *删除菜品
	 */
	@Select(value = "delete from dreamweaver.t_cookbook where (store_id=#{storeId} and dish_id=#{dishId})")
	void deleteDish(@Param("storeId") int storeId,@Param("dishId") int dishId);

	/**
	 * 批量删除菜品
	 */
	@Select(value = "delete from dreamweaver.t_cookbook where (store_id=#{storeId} and dish_id=#{dishId})")
	void deleteSomeDish(@Param("storeId") int storeId,@Param("dishId") int dishId);
}
