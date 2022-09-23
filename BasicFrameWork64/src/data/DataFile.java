package data;

import java.io.FileInputStream;
import java.util.Properties;

import utilities.Xls_Reader;

public class DataFile {

	Xls_Reader d = new Xls_Reader("C:\\Testing\\wetransfer_build-xml_2022-07-10_1838\\NikulTest.xlsx");
	

	
	//Login
	public String emailWithSpecialChar = d.getCellData("Data1", "UserName", 4);
	public String wrongEmail = d.getCellData("Data1", "UserName", 3);
	public String wrongPassword = d.getCellData("Data1", "Password", 2);
	public String specialCharErr = d.getCellData("Data1", "Email Error", 5);
	public String emptyEmailErr = d.getCellData("Data1", "Email Error", 4);
	public String emptyPasswordErr = d.getCellData("Data1", "Password Error", 3);
	public String globalErr = d.getCellData("Data1", "Global Error", 2);

	//HomeTest
	
	//FooterTest
	
	//UserprofileTest
	}


