/*
 * CTS Educare - Solutions for Trainings and Courses.
 * Copyright (c) 2018. All rights reserved.
 *
 */
package br.com.ctseducare.conversion

/**
 * The CTSConversion class provide resources to conversion of values dates and texts.
 *
 * @author Eros Vitor Bornatowski (erosborna@gmail.com)
 * @since 1.0.0
 */
object CTSConversion {

    /**
     * Convert seconds to hours.
     *
     * @param secondsParam Seconds to be converted for hours
     * @return The seconds converted to hours
     */
    fun secondsToHours(secondsParam: Int): String {
        val hoursStr = StringBuilder()
        var seconds = secondsParam
        var hours = 0

        var minutes: Int = seconds / 60
        seconds %= 60
        if (minutes >= 60) {
            hours = minutes / 60
            minutes %= 60
        }

        hoursStr.append(if (hours < 10) "0$hours" else hours)
        hoursStr.append(":")
        hoursStr.append(if (minutes < 10) "0$minutes" else minutes)
        hoursStr.append(":")
        hoursStr.append(if (seconds < 10) "0$seconds" else seconds)

        return hoursStr.toString()
    }

    /**
     * Convert hours to seconds.
     *
     * @param hours Hours to be converted for seconds
     * @return The hours converted to seconds
     */
    fun hoursToSeconds(hours: String): Int {
        var tmp = ""
        val totalSeconds: Int

        tmp += hours[0]
        tmp += hours[1]
        val hoursTmp: Int = Integer.parseInt(tmp)

        tmp = ""
        tmp += hours[3]
        tmp += hours[4]
        val minutes: Int = Integer.parseInt(tmp)

        tmp = ""
        tmp += hours[6]
        tmp += hours[7]
        val seconds: Int = Integer.parseInt(tmp)

        totalSeconds = seconds + (minutes * 60) + (hoursTmp * 3600)

        return totalSeconds
    }

}