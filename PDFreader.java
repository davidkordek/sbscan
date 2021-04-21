package com.example.demo1;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFreader {

    public static void main(String[] args)throws IOException {

        //Loading an existing document
        File file = new File("C:\\Users\\David\\Desktop\\Syllabus.pdf");
        //load the file into the PDF reader.
        PDDocument doc = PDDocument.load(file);

        //converts the PDF into text
        PDFTextStripper stripper = new PDFTextStripper();

        // StringBuilder to store the extracted text
        StringBuilder sb = new StringBuilder();

        // Add text to the StringBuilder from the PDF
        sb.append(stripper.getText(doc));

        //Pattern used to find text in file
        //This pattern finds the pattern (DD/MM) in the syllabus
        Pattern p = Pattern.compile("(\\d\\d/\\d\\d)");
        Matcher m = p.matcher(sb);
        while (m.find()){//prints out the matches
            System.out.println(m.group());
        }

        //Closing the document
        if (doc != null) {
            doc.close();
        }
        System.out.println("Finished");

    }
}