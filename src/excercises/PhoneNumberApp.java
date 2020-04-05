package excercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumberApp {

	public static void main(String[] args) {
		// Read a text file that will retrieve retrieve a valid phone number

		String filename = "C:\\JavaTraining\\PhoneNumber.txt";
		File file = new File(filename);
		String phoneNum = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			phoneNum = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: file not found");
		} catch (IOException e) {
			System.out.println("Error: Could not read file");
		}
		//Valid phone number:
		//10 digits long
		//Area code cannot start with 0 or 9
		//There cannot be 911 in the phone number
		try {
			if (phoneNum.length() != 10) {
				throw new TenDigitsException(phoneNum);
			}
			if ((phoneNum.substring(0,1).equals("0")) || (phoneNum.substring(0,1).equals("9"))){
				throw new AreaCodeException(phoneNum);
			}
			for (int i = 0;i<phoneNum.length()-2;i++) {
				if (phoneNum.substring(i,i+3).equals("911")){
					throw new EmergencyException(phoneNum);
				}
			}
			System.out.println(phoneNum);
		} catch (TenDigitsException e) {
			System.out.println("EROR:Phone number is not 10 digits");
			System.out.println(e.toString());
		} catch (AreaCodeException e) {
			System.out.println("EROR:Phone number can not begin with 0 or 9");
			System.out.println(e.toString());
		} catch (EmergencyException e) {
			System.out.println("EROR:Phone number can not use 911 or emergency numbers");
			System.out.println(e.toString());
		}
	}
}


class TenDigitsException extends Exception{
	String num;
	TenDigitsException(String num){
		this.num = num;
	}
	public String toString() {
		return ("TenDigitsException: " + num);
	}
}

class AreaCodeException extends Exception{
	String num;
	AreaCodeException(String num){
		this.num = num;
	}
	public String toString() {
		return ("AreaCodeException: " + num);
	}
}

class EmergencyException extends Exception{
	String num;
	EmergencyException(String num){
		this.num = num;
	}
	public String toString() {
		return ("EmergencyException: " + num);
	}
}