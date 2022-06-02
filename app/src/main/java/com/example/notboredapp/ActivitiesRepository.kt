package com.example.notboredapp


class ActivitiesRepository {


    private val activities = listOf(
        Activity("Education"),
        Activity("Recreational"),
        Activity("Social"),
        Activity("Diy"),
        Activity("Charity"),
        Activity("Cooking"),
        Activity("Relaxation"),
        Activity("Music"),
        Activity("Busywork"))

    fun getActivities(): List<Activity>{
        return activities
    }
}