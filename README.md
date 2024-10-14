#Steps for PDF Split Files Code
Required Folders:
•	Input Folder: Create a folder named "input" and place your source file in it.
•	Output Folder: An "output" folder will be created automatically, containing files named "CNIC.pdf".
#Step 3: Implement the PDF Processing Code
Create the following classes for PDF extraction and processing:
•	PdfReaderExample.java: This class is the main Spring Boot component responsible for reading the PDF, extracting the CNIC, and saving new PDFs based on the CNIC.
•	CustomTextExtractionStrategy.java: This class is used to extract text from the PDF. It extends LocationTextExtractionStrategy to provide custom behaviour for text extraction.
#Step 4: Running the Code
To run this project:
•	Run mvn clean install
•	Run mvn spring-boot:run

