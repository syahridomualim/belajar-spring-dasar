package com.mualimsyahrido.spring.config.converter

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*

@Component
class StringToDateConverter : Converter<String, Date> {
    override fun convert(source: String): Date? {
        return SimpleDateFormat("yyyy-MM-dd").parse(source)
    }
}