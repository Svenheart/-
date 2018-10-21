package com.lt5.dishcollocation.service;

import com.lt5.dishcollocation.entity.DishMenu;
import com.lt5.dishcollocation.entity.BookSet;
import com.lt5.dishcollocation.entity.TypeMenu;
import com.lt5.dishcollocation.util.Msg;

import java.util.ArrayList;

/**
 * @program:com.lt5.dishcollocation.service
 * @description:
 * @class:DishCollocationService
 * @author:SanCheng
 * @create:2018-10-17
 **/
public interface DishCollocationService {
	Msg addNewMenu(ArrayList<TypeMenu> dishMenus,String isSeven);
	Msg setMenuDays(BookSet bookSet);
	Msg getMenuDate(int storeId);
}
