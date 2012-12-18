package project1;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ref {
		private static ArrayList<String[]> stringHolder = new ArrayList<String[]>();
		private String warningstr = null;
		
		public static void main(String[] args) {
                Vector cellVectorHolder = new Vector();
                String fileName = "/home/nikola/git/Nikola_Domazet/Login/proj1.xls";
                try {
                        FileInputStream myInput = new FileInputStream(fileName);

                        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

                        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

                        HSSFSheet mySheet = myWorkBook.getSheetAt(0);

                        Iterator rowIter = mySheet.rowIterator();

                        while (rowIter.hasNext()) {
                                HSSFRow myRow = (HSSFRow) rowIter.next();
                                Iterator cellIter = myRow.cellIterator();
                                Vector cellStoreVector = new Vector();
                                while (cellIter.hasNext()) {
                                        HSSFCell myCell = (HSSFCell) cellIter.next();
                                        cellStoreVector.addElement(myCell);
                                }
                                cellVectorHolder.addElement(cellStoreVector);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                makeStringArray(cellVectorHolder);
        }

        private static void makeStringArray(Vector dataHolder) {
        	ArrayList<String[]> s = new ArrayList<String[]>();
        	String[] x = new String[3];
        	for (int i = 0; i < dataHolder.size(); i++) {
                Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
                for (int j = 0; j < 3; j++) {
                        HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
                        x[j] = myCell.toString();
                }
                s.add(i, x);
        	}
        	stringHolder.addAll(s);
        }
        
        public ArrayList<String[]> getStringList() {
        	return stringHolder;
        }
        
        private boolean checkXLSusers(ArrayList<String[]> s){
        	String a;
        	for (int i = 0; i < s.size(); i++) {
                for (int j = 0; j < 3; j++) {
                	if(j==0){
                		if((s.get(i))[j].length()!=10){
                			warningstr="JMBAG in row "+(i+1)+" dose not contain 10 signes.";
                			return false;
                		}
                		try{
                			Integer.parseInt((s.get(i))[j]);
                		}catch(Exception e){
                			warningstr="JMBAG in row "+(i+1)+" contains non-numeric signes.";
                			return false;
                		}
                	}else{
                		if(!((s.get(i))[j].length()>0)){
                			warningstr="Name or surname in row "+(i+1)+" not present.";
                			return false;
                		}
                		a=(s.get(i))[j];
                		a.toLowerCase();
                		for(int k=0; k<a.length();k++){
                			if(!((a.charAt(k)>='a' && a.charAt(k)<='a') || a.charAt(k)=='č' || a.charAt(k)=='ć' || a.charAt(k)=='đ' || a.charAt(k)=='š' || a.charAt(k)=='ž')){
                				warningstr="Name or surname in row "+(i+1)+" contains non-alphabetic signes.";
                				return false;
                			}
                		}
                	}
                }
        	}
        	return true;
        }
        
        public String addToDB() {
        	MySQLcon db = new MySQLcon("jdbc:mysql://localhost/mydb", "root", "a");
			ProjSec sec = new ProjSec();
			String errorstr = null;
			if(stringHolder==null)
				return "neuspjeh";
			if(checkXLSusers(stringHolder))
				return warningstr;
			for (int i = 0; i < stringHolder.size(); i++) {
            	try{
            		db.Upd("INSERT INTO Users SET idUsers='"+(stringHolder.get(i))[0]+"', Name='"+(stringHolder.get(i))[1]+"', Surname='"+(stringHolder.get(i))[2]+"', User_name='"+(stringHolder.get(i))[1]+"."+(stringHolder.get(i))[2]+"', User_password='"+sec.toMD5((stringHolder.get(i))[0])+"';");
            	}catch(Exception e){
        			errorstr += "error inputing row: "+(i+1)+"<br/>";
                }
			}
			if(errorstr == null)
				return "Sucess.";
			else
				return errorstr;
        }
}
