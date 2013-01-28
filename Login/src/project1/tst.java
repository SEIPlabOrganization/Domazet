package project1;

import java.math.BigInteger;
import java.security.MessageDigest;

public class tst {
	public static void main(String[] args) {
		char c[]={'1',(char) ('0'+(int)(Math.random()*9)),(char) ('0'+(int)(Math.random()*9)),(char) ('0'+(int)(Math.random()*9)),(char) ('0'+(int)(Math.random()*9)),(char) ('0'+(int)(Math.random()*9)),(char) ('0'+(int)(Math.random()*9)),(char) ('0'+(int)(Math.random()*9)),(char) ('0'+(int)(Math.random()*9)),(char) ('0'+(int)(Math.random()*9))};
		String opt=new String(c);
		System.out.println(opt);
	}
}
