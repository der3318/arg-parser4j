package com.der3318;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgParser {
	
	private Map<String, Boolean> config;
	private Map<String, String> parserDict;
	private List<String> params;
	
	public ArgParser() {
		config = new HashMap<String, Boolean>();
		parserDict = new HashMap<String, String>();
		params = new ArrayList<String>();
	}
	
	public void add(String _param, boolean _isFlag) {
		config.put(_param, _isFlag);
	}
	
	public void parse(String[] _args) {
		String previousKey = null;
		for(int idx = 0; idx < _args.length; idx++)
			if(previousKey != null) {
				parserDict.put(previousKey, _args[idx]);
				previousKey = null;
			}
			else if(config.containsKey(_args[idx]) == false)	params.add(_args[idx]);
			else {
				parserDict.put(_args[idx], "");
				if(config.get(_args[idx]) == false)	previousKey = _args[idx];
			}
	}
	
	public Map<String, String> getParserDict() {
		return parserDict;
	}
	
	public List<String> getParams() {
		return params;
	}
	
}
