package application;

public class Obliczenia {
	
	public String encode(String plainText) {
		String encodedText = "";
		for (int i = 0, count = 1; i < plainText.length(); i++) {
			if (i + 1 < plainText.length() && plainText.charAt(i) == plainText.charAt(i + 1))
				count++;
			else {
				encodedText = encodedText.concat(Character.toString(plainText.charAt(i))
						.concat(Integer.toString(count))) +",";
//				encodedText = encodedText.concat(Integer.toString(count)) stare odwrotnie najpierw cyfra potem litera
//						.concat(Character.toString(plainText.charAt(i)));			
				count = 1;
			}
		}
		System.out.println(encodedText);
		return encodedText;
	}
	public String decode(String encodedText) {
	
		        if (encodedText == "" ||encodedText == null) return "";

		        char[] stArr = encodedText.toCharArray();
	
		        char lastseen = 0;
		        StringBuffer sb = new StringBuffer();
		        for (char s : stArr) {
		            if (!Character.isDigit(s)) {
		                lastseen = s;
		                sb.append(s);
		            } else {
		                int n = Integer.parseInt(String.valueOf(s));
		                for (int i = 0; i < n - 1; i++) {
		                    sb.append(lastseen);
		                }
		            }
		        }
		        return sb.toString();
		    }
}
		
//		int positionStart=encodedText.indexOf("[A-Za-z]|[0-9]"); //index pozycji gdzie znajduje sie litera lub cyfra
//		int positionEnd = encodedText.indexOf(","); //index pozycji gdzie znajduje sie ,
//		
//		String cut = encodedText.substring(positionStart, positionEnd);
//		
//		System.out.println(cut);
	
    

