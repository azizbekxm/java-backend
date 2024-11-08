package com.epam.jmp.protocols.avro.util;

import java.util.Map;

public class CastUtil {
    public static Map<String, Object> castMap(Map<String, String> map) {
        return (Map) map;
    }
}
