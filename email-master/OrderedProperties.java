package com.smartxp.commons.email;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import com.smartxp.commons.email.util.IOUtils;

public class OrderedProperties extends Properties{

	/**
	 * 自定义Properties，因为获取配置文件的顺序错乱
	 */
	private static final long serialVersionUID = 999253196318603207L;
	/** Keys*/  
    private List<String> keys = new ArrayList<String>();  
  
    /** ValueMap*/  
    private Map<String, String> valueMap = new HashMap<String, String>();  
  
    public String getProperty(String key) {  
        return valueMap.get(key);  
    }  
  
    public List<String> getKeys(String keyPattern) {  
        Pattern pat = Pattern.compile(keyPattern);  
        List<String> kl = new ArrayList<String>();  
        for (String k : keys) {  
            if (pat.matcher(k).matches()) {  
                kl.add(k);  
            }  
        }  
        return kl;  
    }  
  
    /** 
     * 加载Properties文件 
     * @param istream 
     * @see amosryan.util.IOUtils 
     */  
    public synchronized void load(InputStream istream) {  
        List<String> lines = null;
		try {
			lines = IOUtils.toLines(istream);
			// parse key-value  
	        for (String contentLine : lines) {  
//				if (contentLine.indexOf(":") > -1) {
//					String k = contentLine.substring(0, contentLine.indexOf(":")).trim();
//					String v = contentLine.substring(contentLine.indexOf(":") + 1).trim();
//					keys.add(k);
//					valueMap.put(k, v);
//				} else {
					keys.add(contentLine);
//				}
	        }  
		} catch (Exception e) {
			e.printStackTrace();
		}  
    }  
  
    public List<String> getKeys() {  
        return keys;  
    }  
  
    @Override  
    public String toString() {  
        return valueMap.toString();  
    }  
}
