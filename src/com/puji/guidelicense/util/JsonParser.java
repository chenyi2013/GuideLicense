package com.puji.guidelicense.util;

import com.alibaba.fastjson.JSON;

public class JsonParser {

	public static <T> T getParsedData(String json, Class<T> cls) {
		json = json.replace("<br\\/>", "").replace("<p><\\/p>", "");
		return JSON.parseObject(json, cls);

	}
}
