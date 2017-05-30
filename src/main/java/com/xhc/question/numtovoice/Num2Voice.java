package com.xhc.question.numtovoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Num2Voice {
	
	public static Map<Character, String> numMap = new HashMap<Character, String>();
	public static Map<Integer, String> levelMap = new HashMap<Integer, String>();
	static{
		numMap.put('1', "一");
		numMap.put('2', "二");
		numMap.put('3', "三");
		numMap.put('4', "四");
		numMap.put('5', "五");
		numMap.put('6', "六");
		numMap.put('7', "七");
		numMap.put('8', "八");
		numMap.put('9', "九");
		numMap.put('0', "零");
		
		levelMap.put(1, "");
		levelMap.put(2, "万");
		levelMap.put(3, "亿");
	}

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String num = input.nextLine();
		
		
		List<String> formatNum = new ArrayList<String>();
		StringBuilder resultVoice = new StringBuilder();
		if(num != null && num.length()>0){
			
			try {
				int test = Integer.parseInt(num);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("输入的字符不是纯数字。");
			}
			
			for(int i=0 , j=num.length()/4 * 4 < num.length() ? num.length()/4 +1 : num.length()/4 ; i<j ; i++){
				int begin = num.length() - (i+1)*4 < 0 ? 0 : num.length() - (i+1)*4;
				int end = num.length() - i*4;
				formatNum.add( num.substring(begin, end));
			}
			
			for(int i=0; i<formatNum.size(); i++){
				char[] wei = formatNum.get(i).toCharArray();;
				String level = levelMap.get(i+1);
				
				String qian = "";
				String bai = "";
				String shi = "";
				String ge = "";
				if(wei.length > 3){
					qian = numMap.get(wei[0]) + "千";
					bai = numMap.get(wei[1]) + "百";
					shi = numMap.get(wei[2]) + "十";
					ge = numMap.get(wei[3]);
				}else if(wei.length > 2){
					bai = numMap.get(wei[0]) + "百";
					shi = numMap.get(wei[1]) + "十";
					ge = numMap.get(wei[2]);
				}else if(wei.length > 1){
					shi = numMap.get(wei[0]) + "十";
					ge = numMap.get(wei[1]);
				}else if(wei.length > 0){
					ge = numMap.get(wei[0]);
				}
				
				
				String str4 = qian+bai+shi+ge + level;
				resultVoice.insert(0, str4);
			}
			
			System.out.println("转换结果：" + resultVoice.toString());
			
		}
		
	}
	
		
}
