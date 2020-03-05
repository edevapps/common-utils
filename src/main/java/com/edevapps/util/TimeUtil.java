/*
 *     Copyright (c) 2018, The Eduard Burenkov. All rights reserved. http://edevapps.com
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.edevapps.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	public static Duration duration(Timestamp start, Timestamp end) {
		return Duration.ofMillis(end.getTime() - start.getTime());
	}

	public static Duration duration(Date start, Date end) {
		return Duration.ofMillis(end.getTime() - start.getTime());
	}

	public static Instant toInstant(Timestamp time) {
		return Instant.ofEpochMilli(time.getTime());
	}

	public static Date toDate(Timestamp time) {
		return new Date(time.getTime());
	}

	public static Date beginDayOf(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date endDayOf(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return addDaysOf(calendar.getTime(), 1);
	}

	public static Date addDaysOf(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}


	public static Date backDaysOf(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -days);
		return calendar.getTime();
	}

	public static Date backMillisecondsOf(Date date, long milliseconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime() - (milliseconds < 0 ? - milliseconds : milliseconds));
		return calendar.getTime();
	}

	public static Date backMinutesOf(Date date, long minutes) {
		return backMillisecondsOf(date, minutes * 60 * 1000);
	}

	public static Date toDate(String value, String format) {
		try {
			return new SimpleDateFormat(format).parse(value);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Date epochToDate(long value) {
		return new Date(value * 1000);
	}
}
