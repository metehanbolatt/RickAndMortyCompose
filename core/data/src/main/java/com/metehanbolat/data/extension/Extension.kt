package com.metehanbolat.data.extension

import com.metehanbolat.data.dto.Character
import com.metehanbolat.domain.model.CharacterItem

fun Character.toCharacterItem() =
    CharacterItem(
        name = name.orEmpty(),
        status = status.orEmpty(),
        species = species.orEmpty(),
        gender = gender.orEmpty()
    )