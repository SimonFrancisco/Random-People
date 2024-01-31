package com.example.random_land.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.io.Serializable

@Parcelize
data class PeopleRandom(
    val results: @RawValue List<Results>
) : Parcelable

@Parcelize

data class Results(
    val cell: String?,
    val dob: @RawValue Dob?,
    val email: String?,
    val gender: String?,
    val id: @RawValue Id?,
    val location: @RawValue Location?,
    val login: @RawValue Login?,
    val name: @RawValue Name?,
    val nat: String?,
    val phone: String?,
    val picture: @RawValue Picture?,
    val registered: @RawValue Registered?
) : Parcelable,Serializable

data class Dob(
    val age: Int?,
    val date: String?
):Serializable

data class Id(
    val name: String?,
    val value: Any?
):Serializable

data class Location(
    val city: String?,
    val coordinates: Coordinates?,
    val country: String?,
    val postcode: Any?,
    val state: String?,
    val street: Street?,
    val timezone: Timezone?
):Serializable

data class Login(
    val md5: String?,
    val password: String?,
    val salt: String?,
    val sha1: String?,
    val sha256: String?,
    val username: String?,
    val uuid: String?
):Serializable

data class Name(
    val first: String?,
    val last: String?,
    val title: String?
):Serializable

data class Picture(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
):Serializable

data class Registered(
    val age: Int?,
    val date: String?
):Serializable

data class Coordinates(
    val latitude: String?,
    val longitude: String?
):Serializable

data class Street(
    val name: String?,
    val number: Int?
):Serializable

data class Timezone(
    val description: String?,
    val offset: String?
):Serializable