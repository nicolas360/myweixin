/**
 * 
 */
package com.zhuc.myweixin.utils;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Weeks;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @title 		
 * @description	使用joda-time 简化日期相关操作
 * @usage		
 * @copyright	Copyright 2011  SHCMCT Corporation. All rights reserved.
 * @company		上海中移通信技术工程有限公司
 * @author		John.Yao
 * @create		2012-12-4 下午4:14:01
 */
public class DateTools {

	private static final String FORMART_TYPE_DEFAULT = "yyyy-MM-dd HH:mm:ss";

	private static final String FORMART_TYPE_DAY = "yyyy-MM-dd";

	private static final String FORMART_TYPE_DAY_CN = "yyyy年MM月dd日";

	private static final String FORMART_TYPE_MONTH = "yyyy-MM";

	private static final String FORMART_TYPE_ABS = "yyyyMMddHHmmss";

	private static final String FORMART_TYPE_HOUR_MINUTE = "HH:mm";

	public static Date stringToDate(String date) {
		if (date != null) {
			DateTimeFormatter format = DateTimeFormat.forPattern(FORMART_TYPE_DEFAULT);
			return DateTime.parse(date, format).toDate();
		} else {
			return null;
		}
	}

	public static long stringDateToLong(String date) {
		return stringToDate(date).getTime();
	}

	public static Date stringToDateAbs(String date) {
		if (date != null) {
			DateTimeFormatter format = DateTimeFormat.forPattern(FORMART_TYPE_ABS);
			return DateTime.parse(date, format).toDate();
		} else {
			return null;
		}

	}

	public static Date stringToDateDay(String date) {
		if (date != null) {
			DateTimeFormatter format = DateTimeFormat.forPattern(FORMART_TYPE_DAY);
			return DateTime.parse(date, format).toDate();
		} else {
			return null;
		}

	}

	public static String dateFormart(Date date, String dateType) {
		String dateStr = "";

		if (date != null) {
			DateTime dt = new DateTime(date);
			dateStr = dt.toString(dateType);
		}
		return dateStr;
	}

	/**
	 * 格式化为 "yyyy-MM-dd"
	 * @param date
	 * @return
	 */
	public static String dateFormartDay(Date date) {
		return dateFormart(date, FORMART_TYPE_DAY);
	}

	/**
	 * 格式化为 "yyyy年MM月dd日"
	 * @param date
	 * @return
	 */
	public static String dateFormartDayCn(Date date) {
		return dateFormart(date, FORMART_TYPE_DAY_CN);
	}

	/**
	 * 格式化为 "HH:mm"
	 * @param date
	 * @return
	 */
	public static String dateFormartHM(Date date) {
		return dateFormart(date, FORMART_TYPE_HOUR_MINUTE);
	}

	/**
	 * 格式化为 "yyyy-MM"
	 * @param date
	 * @return
	 */
	public static String dateFormartMonth(Date date) {
		return dateFormart(date, FORMART_TYPE_MONTH);
	}

	/**
	 * 将时间格式化为 "yyyy-MM-dd HH:mm:ss" 
	 * @param date
	 * @return
	 */
	public static String dateFormart(Date date) {
		return dateFormart(date, FORMART_TYPE_DEFAULT);
	}

	/**
	 *将时间格式化为 "yyyy-MM-dd HH:mm:ss"
	 * @param date   1970 到现在的毫秒
	 * @return
	 */
	public static String dateFormart(long date) {
		return dateFormart(new Date(date));
	}

	/**
	 * 获取当前时间
	 * @return
	 */
	public static String dateFormartNow() {
		return dateFormart(new Date());
	}

	/**
	 * 将时间格式化为 "yyyyMMddHHmmss" 
	 * @param date
	 * @return
	 */
	public static String dateFormartAbs(Date date) {
		return dateFormart(date, FORMART_TYPE_ABS);
	}

	/**
	 * 获取当天的0点0分0秒时间
	 * @param d
	 * @return
	 */
	public static Date getStartTimeOfDay(Date d) {
		return new DateTime(d.getTime()).hourOfDay().setCopy(0).minuteOfHour().setCopy(0).secondOfMinute().setCopy(0)
				.millisOfSecond().setCopy(0).toDate();
	}

	/**
	 * 获取当天的23点59分59秒时间
	 * @param d
	 * @return
	 */
	public static Date getEndTimeOfDay(Date d) {
		return new DateTime(d.getTime()).hourOfDay().setCopy(23).minuteOfHour().setCopy(59).secondOfMinute()
				.setCopy(59).millisOfSecond().setCopy(999).toDate();
	}

	/**
	 * 获取当天所在月第一天的0点0分0秒时间
	 * @param d
	 * @return
	 */
	public static Date getStartTimeOfMonth(Date d) {
		return new DateTime(d.getTime()).dayOfMonth().setCopy(1).hourOfDay().setCopy(0).minuteOfHour().setCopy(0)
				.secondOfMinute().setCopy(0).millisOfSecond().setCopy(0).toDate();
	}

	/**
	 * 获取当天所在月最后一天的23点59分59秒时间
	 * @param d
	 * @return
	 */
	public static Date getEndTimeOfMonth(Date d) {
		return new DateTime(d.getTime()).dayOfMonth().withMaximumValue().hourOfDay().setCopy(23).minuteOfHour()
				.setCopy(59).secondOfMinute().setCopy(59).millisOfSecond().setCopy(999).toDate();
	}

	/**
	 * 获取当前时间1小时内的时段
	 * @param d
	 * @return
	 */
	public static String getPeriod(Date d) {
		StringBuilder period = new StringBuilder();
		DateTime dt1 = new DateTime(d.getTime()).minuteOfHour().setCopy(0).secondOfMinute().setCopy(0).millisOfSecond()
				.setCopy(0);
		DateTime dt2 = dt1.minuteOfHour().setCopy(59).secondOfMinute().setCopy(59).millisOfSecond().setCopy(999);

		period.append(dateFormartHM(dt1.toDate())).append("~").append(dateFormartHM(dt2.toDate()));
		return period.toString();
	}

	/**
	 * 计算2个时间之间共有多少天
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int getSepaDay(Date d1, Date d2) {
		DateTime dt1 = new DateTime(d1.getTime()).hourOfDay().setCopy(0).minuteOfHour().setCopy(0).secondOfMinute()
				.setCopy(0).millisOfSecond().setCopy(0);
		DateTime dt2 = new DateTime(d2.getTime()).hourOfDay().setCopy(0).minuteOfHour().setCopy(0).secondOfMinute()
				.setCopy(0).millisOfSecond().setCopy(0);

		int sepa = (int) ((dt2.toDate().getTime() - dt1.toDate().getTime()) / (3600l * 24 * 1000));

		return sepa;
	}

	/**
	 * 计算2个时间相差?天?时?分?秒
	 * @param d1
	 * @param d2
	 * @return ?天?时?分?秒
	 */
	public static String getGap(Date d1, Date d2) {
		long gap = d1.getTime() - d2.getTime();
		gap = Math.abs(gap); // 取绝对值

		return getGap(gap);
	}

	/**
	 * 计算时间相差?天?时?分?秒
	 * @param gap
	 * @return ?天?时?分?秒
	 */
	public static String getGap(long gap) {
		int day = (int) (gap / 24 / 3600 / 1000);
		int hour = (int) (gap / 3600 / 1000 - 24 * day);
		int minute = (int) (gap / 60 / 1000 - day * 24 * 60 - hour * 60);
		int sec = (int) (gap / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60);

		StringBuffer sb = new StringBuffer();
		sb.append(day).append("天").append(hour).append("时").append(minute).append("分").append(sec).append("秒");
		return sb.toString();
	}

	/**
	 * 计算时间相差?天
	 * @param gap
	 * @return ?天
	 */
	public static String getGapDay(long gap) {
		int day = (int) (gap / 24 / 3600 / 1000);

		StringBuffer sb = new StringBuffer();
		sb.append(day + 1).append("天");
		return sb.toString();
	}

	/**
	 * 返回两个时间间隔的周数
	 * @param beginDay	开始时间
	 * @param endDay	结束时间
	 * @return
	 */
	public static int getWeeks(String beginDay, String endDay) {
		DateTime begin = new DateTime(2012, 9, 1, 0, 0, 0);
		DateTime end = new DateTime(2013, 1, 31, 0, 0, 0);
		Weeks weeks = Weeks.weeksBetween(begin, end);

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(getStartTimeOfDay(new Date()));
		System.out.println(getEndTimeOfDay(new Date()));
		System.out.println(getStartTimeOfMonth(new Date()));
		System.out.println(getEndTimeOfMonth(new Date()));

		System.out.println(getPeriod(new Date()));

		Date d1 = new Date(2013, 12, 30, 10, 10, 10);
		Date d2 = new Date(2014, 1, 5, 10, 10, 2);
		System.out.println(getSepaDay(d1, d2));

		System.out.println(d1 + "," + d2);
		System.out.println(getGap(d1, d2));
		System.out.println(getGap(0l));
	}

}
