package com.example.notboredapp.data.repository

import com.example.notboredapp.models.Activity


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
        Activity("Busywork")
    )

    fun getActivities(): List<Activity>{
        return activities
    }
}