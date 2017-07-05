package edu.mum.cs.projects.attendance.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
	
	public static LocalDate convertDateToLocalDate(Date date) {
		date = new Date(date.getTime()); // Effectively Converts from sql.Date to util.Date
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static Date convertLocalDateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalTime convertDateToLocalTime(Date date) {
		date = new Date(date.getTime()); // Effectively Converts from sql.Date to util.Date
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}
	
	public static Date convertLocalTimeToDate(LocalTime localTime) {
		// 2017-01-01 is a just an arbitrary date, any date works really...
		return Date.from(localTime.atDate(LocalDate.of(2017, Month.JANUARY, 1)).
		        atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static String convertDateToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public static Date convertStringToDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date convertOldFormatStringToDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		try {
			return formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
