package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class UserData {

	public static String DATA_FILE = "TestData.xls";

	public static final int FIRST_NAME = 0;
	public static final int LAST_NAME = 1;
	public static final int PASSWORD = 2;
	public static final int EMAIL = 3;
	public static final int ADDRESS = 4;
	public static final int CITY = 5;
	public static final int STATE = 6;
	public static final int POSTAL_CODE = 7;
	public static final int PHONE = 8;
	public static final int ADDRESS_ALIAS = 9;

	// Method that returns total number of rows in Excel file
	public static int getNumberOfRows() {
		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			return sheet.getLastRowNum() + 1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	// Method that returns First name from Excel file
	public static String getFirstName(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(FIRST_NAME);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// Method that returns Last name from Excel file
	public static String getLastName(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(LAST_NAME);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Method that returns Password from Excel file
	public static String getPassword(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(PASSWORD);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Method that returns Email from Excel file
	public static String getEmail(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(EMAIL);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Method that returns Address from Excel file
	public static String getAddress(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(ADDRESS);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Method that returns City from Excel file
	public static String getCity(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(CITY);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Method that returns State from Excel file
	public static String getState(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(STATE);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Method that returns Postal code from Excel file
	public static String getPostalCode(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(POSTAL_CODE);
			String temp = UserField.toString();
			String zipCode = temp.substring(0, 5);

			return zipCode;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Method that returns Mobile Phone from Excel file
	public static String getMobilePhone(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(PHONE);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Method that returns Address alias from Excel file
	public static String getAddressAlias(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(ADDRESS_ALIAS);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
