package com.example.movielabs.helper

object Utils {

    fun getRuntimeFormat(runtime: String?) : String {
        val intRuntime = runtime?.toIntOrNull() ?: 0
        return if (intRuntime == 0) {
            ("")
        } else {
            val hour = intRuntime / 60
            val minute = intRuntime % 60

            ("$hour h $minute m")
        }
    }

    fun getWeeks(week: String?) : String {
        return "Week $week"
    }

    fun getYear(data: String?) : String? {
        return data?.substring(0,4)
    }

    fun getDesc(data: String?) : String? {
        return data?.substring(5)
    }
}