package com.lt5.foodmanage.util;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * @program:com.lt5.foodmanage.util
 * @description:
 * @class:FtpUtil
 * @author:SanCheng
 * @create:2018-10-18
 **/
public class FtpUtil {

	private String host="134.175.24.252";
	private String username="ftp";
	private String password="";
	private String hostDir="/upload/";

	FTPClient ftp = null;

	public FtpUtil() throws Exception{
		ftp = new FTPClient();
//        ftp.enterRemotePassiveMode();
/*
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));//打印进程信息
*/
		int reply;
		ftp.connect(host);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login(username, password);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
	}
	public void disconnect(){
		if (this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException f) {
				f.printStackTrace();
			}
		}
	}
	public String uploadFile(byte[] localFileFullName,String date,String fileName)
			throws Exception {
		boolean result=false;
		String path = null;
		try(InputStream input = new ByteArrayInputStream(localFileFullName)){
			FtpUtil ftpUpload=new FtpUtil();
			/*if(!ftp.changeWorkingDirectory(hostDir+date)){
				String[] dirs=date.split("/");
				path=hostDir;
				for(String dir:dirs){
					if(dir==null||dir.equals("")){
						continue;
					}
					path=path+"/"+dir;
					if(!ftp.changeWorkingDirectory(path)){
						if(!ftp.makeDirectory(path)){
							return null;
						}
						ftp.changeWorkingDirectory(path);
					}
				}
			}*///分级保存
			result=this.ftp.storeFile(hostDir + fileName + ".jpg", input);
			if(!result){
				disconnect();
				return null;
			}
			disconnect();
			return "http://"+host+":8080"+hostDir+fileName+".jpg";
		}
	}

	/*public static void main(String[] args) throws Exception {
		System.out.println("Start");
		FtpUtil ftpUploader = new FtpUtil("134.175.24.252", "ftp", "");
		ftpUploader.uploadFile("D://test123.txt", "test12.txt", "/upload/");
		ftpUploader.disconnect();
		System.out.println("Done");
	}*/

}