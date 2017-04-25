package com.mashen.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	/**
	 * 发送http请求
	 * 
	 * @param url
	 *            请求地址
	 * @param method
	 *            请求方法
	 * @param param
	 *            请求参数
	 * @param charset
	 *            字符集
	 * @return 返回请求结果
	 * @throws Exception
	 */
	public static String sendHttpReq(String url, String method, String param,
			String charset) throws Exception {
		HttpURLConnection conn =null;
		BufferedOutputStream bufout=null;
		BufferedReader bufrd=null;
		try {
			URL urlobj = new URL(url);
			conn = (HttpURLConnection) urlobj
					.openConnection();
			conn.setDoInput(true);// 读取指定url服务器的资源
			if (param != null) {
				conn.setDoOutput(true);// 写入数据到指定url服务器
			}
			conn.setUseCaches(false);
			conn.setConnectTimeout(1000 * 60);// 1分钟超时
			conn.setReadTimeout(1000 * 60);// 1分钟超时
			conn.setRequestMethod(method);//设置请求方法
			if (param != null) {
				bufout = new BufferedOutputStream(
						conn.getOutputStream());
				bufout.write(param.getBytes(charset));
				bufout.flush();
				bufout.close();
			}
			bufrd = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), charset));
			String line = null;
			StringBuilder strbui = new StringBuilder();
			while ((line = bufrd.readLine()) != null) {
				strbui.append(line).append("\n");
			}
			bufrd.close();
			conn.disconnect();
			return strbui.toString();
		} finally {
			closeAll(bufrd,null,bufout,conn);
		}
	}
	
	public static String upload(
			String url,
			String filepath,
			String charset) throws Exception {
		HttpURLConnection conn =null;
		BufferedOutputStream bufout=null;
		BufferedReader bufrd=null;
		BufferedInputStream fileinput=null;
		try {
			URL urlobj = new URL(url);
			conn = (HttpURLConnection) urlobj
					.openConnection();
			conn.setDoInput(true);// 读取指定url服务器的资源
			conn.setDoOutput(true);// 写入数据到指定url服务器
			conn.setUseCaches(false);
			conn.setConnectTimeout(1000 * 60);// 1分钟超时
			conn.setReadTimeout(1000 * 60);// 1分钟超时
			conn.setRequestMethod("POST");//设置请求方法
			String boundary=String.valueOf(System.currentTimeMillis());
			//设置请求头
			conn.addRequestProperty("Content-Type","multipart/form-data; boundary="+boundary);
			//设置附件表单信息
			StringBuilder headstr=new StringBuilder("--");
			headstr.append(boundary).append("\r\n")
			.append("Content-Disposition: form-data; name=\"file\"; filename=\"")
			.append(filepath).append("\"").append("\r\n")
			.append("Content-Type: application/octet-stream\r\n\r\n");
			
			bufout = new BufferedOutputStream(
						conn.getOutputStream());
			//写入表单信息
			bufout.write(headstr.toString().getBytes(charset));
			//bufout.flush();
			//写入附件
			fileinput=
					new BufferedInputStream(new FileInputStream(filepath));
			byte[] bytebuf=new byte[1024];
			int len=0;
			while((len=fileinput.read(bytebuf))!=-1){
				bufout.write(bytebuf,0,len);
			}
			bufout.write(("\r\n--"+boundary+"--\r\n").getBytes(charset));
			bufout.flush();//因为使用了缓冲流，必须执行
			//bufout.close();
			//fileinput.close();
			
			bufrd = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), charset));
			
			String line = null;
			StringBuilder strbui = new StringBuilder();
			while ((line = bufrd.readLine()) != null) {
				strbui.append(line).append("\n");
			}
			bufrd.close();
			conn.disconnect();
			return strbui.toString();
		} finally {
			closeAll(bufrd,fileinput,bufout,conn);
		}
	}

	public static void closeAll(Reader rd, InputStream input,OutputStream out,
			HttpURLConnection conn) {
		if (rd != null) {
			try {
				rd.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (out != null) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			conn.disconnect();
		}
	
	}
}
