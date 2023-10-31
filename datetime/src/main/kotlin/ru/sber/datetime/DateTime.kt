package ru.sber.datetime

import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*

// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {
    val nonIntegerOffsetTimeZones = mutableSetOf<String>()

    for (id in TimeZone.getAvailableIDs()) {
        val timeZone = TimeZone.getTimeZone(id)
        val offsetMillis = timeZone.rawOffset
        val offsetHours = offsetMillis / (1000 * 60 * 60)

        if (offsetHours.toDouble() != offsetMillis.toDouble() / (1000 * 60 * 60) &&
            !listOf("ACT", "CNT", "IST").contains(id)
        ) {
            nonIntegerOffsetTimeZones.add(id)
        }
    }

    nonIntegerOffsetTimeZones.forEach { println(it) }

    return nonIntegerOffsetTimeZones.toSet()
}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {

    val lastMonthDays = mutableListOf<String>()
    for (month in Month.values()) {
        val lastDayOfMonth = LocalDate.of(year, month, 1).withDayOfMonth(month.length(Year.of(year).isLeap))
        val dayOfWeek = lastDayOfMonth.dayOfWeek
        lastMonthDays.add(dayOfWeek.toString())
    }

    return lastMonthDays
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {

    var count = 0

    for (month in 1..12) {
        val date = LocalDate.of(year, month, 13)
        if (date.dayOfWeek == DayOfWeek.FRIDAY) {
            count++
        }
    }

    return count
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm", Locale.US)
    val formattedDate = formatter.format(dateTime)

    return formattedDate.toString()
}



