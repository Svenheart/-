package com.lt5.foodmanage.ServiceImp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lt5.foodmanage.dao.DishManageDao;
import com.lt5.foodmanage.entity.DishMenu;
import com.lt5.foodmanage.service.DishManageService;
import com.lt5.foodmanage.util.FtpUtil;
import com.lt5.foodmanage.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @program:com.lt5.foodmanage.ServiceImp
 * @description:
 * @class:DishManageServiceImp
 * @author:SanCheng
 * @create:2018-10-16
 **/
@Service
public class DishManageServiceImp implements DishManageService {

	@Autowired
	private DishManageDao dishManageDao;
	@Autowired
	protected RedisTemplate<String,String> redisTemplate;

	@Override
	public Msg addDish(DishMenu dishMenu) {
		Msg msg=new Msg();
		byte[] b;
		try {
			b= Base64Utils.decodeFromString(dishMenu.getDishImage());
			if(b==null){
				throw new Exception();
			}
			FtpUtil ftpUtil=new FtpUtil();
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
			String path=simpleDateFormat.format(new Date());
			if(dishMenu.getStoreId()==0){
				throw new Exception();
			}
			String filename=String.valueOf(System.currentTimeMillis())+dishMenu.getStoreId();
			String tip=ftpUtil.uploadFile(b,path,filename);
			dishMenu.setDishImage(tip);
			dishManageDao.addDish(dishMenu);
			msg.setimformation("添加菜品成功！");
		}catch(Exception e){
			e.printStackTrace();
			msg.setStatus(0);
			msg.setimformation("添加菜品失败！");
			msg.setErrorTip("");
		}
		msg.setStatus(1);
		msg.setErrorTip("");
		return msg;
	}

	@Override
	public Msg deleteSomeDish(ArrayList<DishMenu> dishMenu) {
		Msg msg=new Msg();
		try{
			for(int i=0;i<dishMenu.size();i++) {
				dishManageDao.deleteSomeDish(dishMenu.get(i).getStoreId(),dishMenu.get(i).getDishId());
			}
			msg.setimformation("批量删除菜品成功！");
		}catch (Exception e){
			e.printStackTrace();
			msg.setStatus(0);
			msg.setimformation("批量删除菜品失败！");
			msg.setErrorTip("");
			return msg;
		}
		msg.setStatus(1);
		msg.setErrorTip("");
		return msg;
	}

	@Override
	public Msg deleteDish(DishMenu dishMenu) {
		Msg msg=new Msg();
		try{
			dishManageDao.deleteDish(dishMenu.getStoreId(),dishMenu.getDishId());
			msg.setimformation("删除菜品成功！");
		}catch (Exception e){
			e.printStackTrace();
			msg.setStatus(0);
			msg.setimformation("删除菜品失败！");
			msg.setErrorTip("");
			return msg;
		}
		msg.setStatus(1);
		msg.setErrorTip("");
		return msg;
	}

	@Override
	public Msg listDish(int storeId,int pageNum,int pageSize) {
		Msg msg=new Msg();
		try{
			PageHelper.startPage(pageNum,pageSize);
			ArrayList<DishMenu> dishMenuList=dishManageDao.listDish(storeId);
			PageInfo<DishMenu> pageInfo=new PageInfo<>(dishMenuList);
			msg.setimformation("查询菜品成功");
			msg.setlistDataBody(pageInfo);
		}catch (Exception e){
			e.printStackTrace();
			msg.setStatus(0);
			msg.setimformation("查询菜品失败！");
			msg.setErrorTip("");
			return msg;
		}
		msg.setStatus(1);
		msg.setErrorTip("");
		return msg;
	}

	@Override
	public Msg listSomeDish(int storeId,String condition,int pageNum,int pageSize) {
		Msg msg=new Msg();
		try{
			PageHelper.startPage(pageNum,pageSize);
			ArrayList<DishMenu> dishMenuArrayList=dishManageDao.listSomeDish(storeId,"%"+condition+"%");
			PageInfo<DishMenu> pageInfo=new PageInfo<>(dishMenuArrayList);
			msg.setimformation("查询菜品成功");
			msg.setlistDataBody(pageInfo);
		}catch (Exception e){
			e.printStackTrace();
			msg.setStatus(0);
			msg.setimformation("查询菜品失败");
			msg.setErrorTip("");
			return msg;
		}
		msg.setStatus(1);
		msg.setErrorTip("");
		return msg;
	}

	@Override
	public Msg updateDish(DishMenu dishMenu) {
		Msg msg=new Msg();
		try{
			dishManageDao.updateDish(dishMenu);
			msg.setimformation("更新菜品成功！");
		}catch (Exception e){
			msg.setStatus(0);
			msg.setimformation("更新菜品失败！");
			msg.setErrorTip("");
			return msg;
		}
		msg.setStatus(1);
		msg.setErrorTip("");
		return msg;
	}
}
