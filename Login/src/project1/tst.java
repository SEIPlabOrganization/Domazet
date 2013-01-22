package project1;

import java.math.BigInteger;
import java.security.MessageDigest;

public class tst {
	public static void main(String[] args) {
		String name="đAlweSqAseQAđĐ";
		name=name.toLowerCase();
		for(int i=0; i<name.length(); i++){
			if(((name.charAt(i)<'a') || (name.charAt(i)>'z')) && ((name.charAt(i)!='č') && (name.charAt(i)!='ć') && (name.charAt(i)!='ž') && (name.charAt(i)!='š') && (name.charAt(i)!='đ')))
				System.out.println("ne");
		}
		System.out.println(name);
		String buffer=name.toUpperCase();
		char c[]=name.toCharArray();
		c[0]=buffer.charAt(0);
		name=new String(c);
		System.out.println(name);
	}
}
