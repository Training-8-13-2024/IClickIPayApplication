package com.iclickipayapplication.data

data class CalendarDay(val dayName: String, val dayNumber: String)

fun getDummyCalendarDays(): List<CalendarDay> {
    return listOf(
        CalendarDay("Sun", "4"),
        CalendarDay("Mon", "5"),
        CalendarDay("Tue", "6"),
        CalendarDay("Wed", "7"),
        CalendarDay("Thu", "8"),
        CalendarDay("Fri", "9"),
        CalendarDay("Sat", "10")
    )
}

fun getDummyTimeSlots(): List<String> {
    return listOf(
        "01:00 PM", "01:30 PM", "02:00 PM", "02:30 PM",
        "03:00 PM", "03:30 PM", "04:00 PM", "04:30 PM",
        "05:00 PM", "05:30 PM", "06:00 PM", "06:30 PM",
        "07:00 PM", "07:30 PM", "08:00 PM", "08:30 PM",
        "09:00PM",
    )
}