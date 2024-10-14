/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Pdf.component;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.parser.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itextpdf.kernel.pdf.canvas.parser.listener.IEventListener;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohsin.shah
 */
@Component
public class PdfReaderExample implements CommandLineRunner {

    // Path to the source PDF
    @Value("${file.source.path}")
    private String srcFilePath;

    // Directory where output PDFs will be saved
    @Value("${file.output.directory}")
    private String outputDir;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("testing...");

//        // Path to the source PDF
//        String src = "C:\\Users\\muhammad.abubakar\\Desktop\\pdf\\Pdf\\pdf\\CGT.pdf";
//
//        // Directory where output PDFs will be saved
//        String outputDir = "C:\\Users\\muhammad.abubakar\\Desktop\\pdf\\Pdf\\pdf\\output\\";

        // Ensure the output directory exists; if not, create it
        File outDir = new File(outputDir);
        if (!outDir.exists()) {
            boolean created = outDir.mkdirs();
            if (!created) {
                System.err.println("Failed to create output directory!");
                return;
            }
        }

        try {
            // Open the source PDF
            PdfDocument pdfDoc = new PdfDocument(new PdfReader(srcFilePath));

            int numberOfPages = pdfDoc.getNumberOfPages();
            System.out.println("Total Pages: " + numberOfPages);

            // Regular expression to match a 13-digit CNIC number
            Pattern pattern = Pattern.compile("\\b(\\d{13})\\b");

            for (int i = 1; i <= numberOfPages; i++) {
                // Initialize the custom strategy
                CustomTextExtractionStrategy strategy = new CustomTextExtractionStrategy();
                PdfCanvasProcessor processor = new PdfCanvasProcessor(strategy);
                PdfDocument pageDoc = new PdfDocument(new PdfReader(srcFilePath));
                processor.processPageContent(pdfDoc.getPage(i));

                // Get the extracted text
                String pageText = strategy.getResultantText();

                System.out.println("Extracted Text on Page " + i + ":");
                System.out.println(pageText);

                // Search for the CNIC number using regex
                Matcher matcher = pattern.matcher(pageText);
                String cnicNumber = null;
                if (matcher.find()) {
                    cnicNumber = matcher.group(1);
                    System.out.println("CNIC found on page " + i + ": " + cnicNumber);
                } else {
                    System.out.println("No CNIC found on page " + i);
                }

                // Determine the output filename
                String outputFilename;
                if (cnicNumber != null) {
                    outputFilename = outputDir + cnicNumber + ".pdf";
                } else {
                    outputFilename = outputDir + "page_" + i + ".pdf";
                }

                // Create a new PDF document for the single page
                PdfDocument newPdf = new PdfDocument(new PdfWriter(outputFilename));

                // Copy the current page to the new PDF
                pdfDoc.copyPagesTo(i, i, newPdf);

                // Close the new PDF document
                newPdf.close();

                System.out.println("Saved page " + i + " as " + outputFilename);
            }

            // Close the source PDF document
            pdfDoc.close();

            System.out.println("PDF processing completed successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }



//        try (PdfDocument pdfDoc = new PdfDocument(new PdfReader(src))) {
//            for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {
//                CustomTextExtractionStrategy strategy = new CustomTextExtractionStrategy();
//                PdfCanvasProcessor processor = new PdfCanvasProcessor(strategy);
//                processor.processPageContent(pdfDoc.getPage(i));
//
//                // Output the extracted text and rectangle positions
//                System.out.println("Page " + i + ": " + strategy.getResultantText());
//                System.out.println("Rectangles: " + strategy.getRectangles());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}


