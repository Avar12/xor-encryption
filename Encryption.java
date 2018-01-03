package de.avar.xor;

/**
 * Created by Avar12 on 03.01.2018.
 */


import java.io.*;

/**
 * Created by Avar12 on 03.01.2018.
 */
public class Encryption {


    public Encryption() {
        System.out.println("Happy encrypting !");
    }


    public void encrypt(String input, String output, String key) throws IOException {


        InputStream in = new FileInputStream(input);
        OutputStream out = new FileOutputStream(output);

        byte[] bytekey = key.getBytes();

        //index of incoming data, should not equal -1
        int index;

        //Key-index
        int keyIndex = 0;

        //process while the index of our incoming-data does not equal -1
        while ((index = in.read()) != -1) {

            //XOR operate '^' all incoming data
            //if the data-index is longer than the key,simply modulo operate '%'
            out.write(index ^ bytekey[keyIndex % bytekey.length]);

            //Move one step further on the key index, modulo ?
            keyIndex++;
        }
    }
}
