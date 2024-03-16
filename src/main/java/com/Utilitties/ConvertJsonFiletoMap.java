package com.Utilitties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJsonFiletoMap {

	private static File getFile(String fileName) {
		String filePath = System.getProperty("user.dir") + File.separator + "JsonFiles" + File.separator + fileName
				+ ".json";
		return new File(filePath);
	}

	public static Map<String, Object> getDataInMapFromJsonFile(String fileName) {
		Map<String, Object> mapValue = null;

		try {
			File file = getFile(fileName);
			ObjectMapper mapper = new ObjectMapper();
			mapValue = mapper.readValue(file, new TypeReference<Map<String, Object>>() {
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapValue;

	}

}
