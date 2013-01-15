package project1;

import java.math.BigInteger;
import java.security.MessageDigest;

public class tst {
	public static void main(String[] args) {
		try{
			MySQLcon db = new MySQLcon("jdbc:mysql://localhost/mydb", "root", "a");
			String s="! % / \' \"";
			System.out.println(s);
			s=db.Sec(s);
			System.out.println(s);
			s=db.SecGet(s);
			System.out.println(s);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
