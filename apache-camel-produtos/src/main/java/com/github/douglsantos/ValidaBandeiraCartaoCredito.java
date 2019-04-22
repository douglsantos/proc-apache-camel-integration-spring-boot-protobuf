package com.github.douglsantos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ValidaBandeiraCartaoCredito {
	
	private static Map<String, String> flags = new HashMap<String, String>();
	
	public static void main(String[] args) {
	
		flags.put("elo", "^((((636368)|(438935)|(504175)|(451416)|(636297))\\d{0,10})|((5067)|(4576)|(4011))\\d{0,12})");
		flags.put("mastercard", "^5[1-5][0-9]{14}");
		flags.put("diners", "^3(?:0[0-5]|[68][0-9])[0-9]{11}$");
		flags.put("discover", "^6(?:011|5[0-9]{2})[0-9]{12}");
		flags.put("hipercard", "^(606282\\d{10}(\\d{3})?)|(3841\\d{15})");
		flags.put("jcb", "^(?:2131|1800|35\\d{3})\\d{11}");
		flags.put("aura", "^(5078\\d{2})(\\d{2})(\\d{11})$");
		flags.put("maestro card", "^(5018|5020|5038|6304|6759|6761|6763)[0-9]{8,15}$");
		flags.put("visa", "^4[0-9]{12}(?:[0-9]{3})?$");
//		flags.put("mastercard", "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$");
		flags.put("discover card", "^65[4-9][0-9]{13}|64[4-9][0-9]{13}|6011[0-9]{12}|(622(?:12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{10})$");
		flags.put("american express", "^3[47][0-9]{13}$");
		
		
		System.out.println(getFlag(flags, "30133329380474"));
	}
	
	public static String getFlag(Map<String, String> map, String value) {
		for (Entry<String, String> entry : flags.entrySet()) {
	        if (value.matches(entry.getValue())) {
	            return entry.getKey();
	        }
	    }
		return null;
	}
}
