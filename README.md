PDF Split Files Code: A Step-by-Step Guide
Table of Contents
Steps for PDF Split Files Code
Required Folders
Input Folder
Create a folder named "input" and place your source file in it.

Output Folder
An "output" folder will be created automatically, containing files named "CNIC.pdf".

Step 3: Implement the PDF Processing Code
Create Classes for PDF Extraction and Processing
PdfReaderExample.java
This class is the main Spring Boot component responsible for reading the PDF, extracting the CNIC, and saving new PDFs based on the CNIC.

CustomTextExtractionStrategy.java
This class is used to extract text from the PDF. It extends LocationTextExtractionStrategy to provide custom behaviour for text extraction.

Step 4: Running the Code
To Run this Project
Run mvn clean install
Run mvn spring-boot:run
Let me know if you need any further assistance!
