package com.example.smartpantrymanager;

import androidx.room.TypeConverter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListConverter {
    @TypeConverter
    public String fromList(List<String> list) {
        return list == null ? null : String.join(",", list);
    }

    @TypeConverter
    public List<String> fromString(String value) {
        return value == null ? null : Arrays.stream(value.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

