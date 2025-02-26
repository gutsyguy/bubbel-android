// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json          = Json { allowStructuredMapKeys = true }
// val resCreateClub = json.parse(ResCreateClub.serializer(), jsonString)

package com.example.bubbel.model.backend

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class ResCreateClub (
    val error: CreateClubError? = null,
    val res: CreateClubOut? = null
)

@Serializable
data class CreateClubError (
    val type: ResCreateClubErrorType,
    val ierror: String? = null
)

@Serializable
enum class ResCreateClubErrorType(val value: String) {
    @SerializedName("ClubAlreadyExists") ClubAlreadyExists("ClubAlreadyExists"),
    @SerializedName("Internal") Internal("Internal"),
    @SerializedName("NoAuth") NoAuth("NoAuth");
}

@Serializable
data class CreateClubOut (
    @SerializedName("club_id")
    val clubID: Long
)
