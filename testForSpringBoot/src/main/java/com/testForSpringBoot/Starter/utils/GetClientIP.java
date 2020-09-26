package com.testForSpringBoot.Starter.utils;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

public class GetClientIP {

	public String getClientIpAddr(HttpServletRequest request) {
		InetAddress inetAddress = null;
		String remoteAddr = "";
		String add = "";
		String result = " ";
		try {

			if (request != null) {
				remoteAddr = request.getHeader("X-Forwarded-For");
				if (remoteAddr == null || "".equals(remoteAddr)) {
					remoteAddr = request.getRemoteAddr();
					add = request.getRemoteHost();
					System.out.println("ip address now is" + request.getRemoteAddr());
					remoteAddr = request.getRemoteAddr();
					if (remoteAddr.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
						inetAddress = InetAddress.getLocalHost();
						String ipAddress = inetAddress.getHostAddress();
						remoteAddr = ipAddress;
					}
				}
			}

			System.out.println("new one ip is::" + remoteAddr);
			result = remoteAddr;

			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			;
			return null;
		}
	}

}
