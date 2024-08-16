package pl.masslany.network.models.response

import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.KType

data class ResponseTypeInfo(
    val type: KClass<*>,
    val reifiedType: Type,
    val kotlinType: KType? = null,
)
