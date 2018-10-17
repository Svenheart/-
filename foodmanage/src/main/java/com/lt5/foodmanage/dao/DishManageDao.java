package com.lt5.foodmanage.dao;

import com.lt5.foodmanage.entity.DishMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
	@Select(value = "select * from dreamweaver.t_cookbook where store_id=#{storeId};")
	List<DishMenu> queryDish(int storeId);

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
			"dish_image=#{dishImage},cuisine=#{cuisine},store_id=#{storeId} where dish_id=#{dishId}")
	void updateDish(DishMenu dishMenu);

	/**
	 *删除菜品
	 */
	@Select(value = "delete from dreamweaver.t_cookbook where store_id=#{storeId} and dish_id=#{dishId};")
	void deleteDish(DishMenu dishMenu);
}
