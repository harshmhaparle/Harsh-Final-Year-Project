package com.algo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
 
 
public class Decryptor 
{ 
	public void decrypt(String fname)throws Exception{
		  SecretKey key =null;
		     
		  //creating file input stream to read from file
		  try(FileInputStream fis = new FileInputStream(fname)){
		   //creating object input stream to read objects from file
		   ObjectInputStream ois = new ObjectInputStream(fis);
		   key = (SecretKey)ois.readObject();  //reading key used for encryption
		    System.out.println(key);
		   Cipher cipher = Cipher.getInstance("AES");  //getting cipher for AES
		   cipher.init(Cipher.DECRYPT_MODE, key);  //initializing cipher for decryption with key
		   //creating file output stream to write back original contents
		   
		   try(FileOutputStream fos = new FileOutputStream(fname+".aes")){
		    //creating cipher input stream to read encrypted contents
		    try(CipherInputStream cis = new CipherInputStream(fis, cipher)){
		     int read;
		     byte buf[] = new byte[4096];
		     while((read = cis.read(buf)) != -1)  //reading from file
		      fos.write(buf, 0, read);  //decrypting and writing to file
		    }
		   }
		  }
		  
		 }
}