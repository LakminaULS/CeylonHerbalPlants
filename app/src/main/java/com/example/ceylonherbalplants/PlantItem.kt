package com.example.ceylonherbalplants

import android.os.Parcel
import android.os.Parcelable

data class PlantItem(
    val plantName: String,
    val scientificName: String,
    val usageDetails: String,
    val imageUrl: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(plantName)
        parcel.writeString(scientificName)
        parcel.writeString(usageDetails)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlantItem> {
        override fun createFromParcel(parcel: Parcel): PlantItem {
            return PlantItem(parcel)
        }

        override fun newArray(size: Int): Array<PlantItem?> {
            return arrayOfNulls(size)
        }
    }
}
