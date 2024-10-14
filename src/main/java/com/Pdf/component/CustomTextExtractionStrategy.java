package com.Pdf.component;

import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;
import com.itextpdf.kernel.pdf.canvas.parser.data.TextRenderInfo;
import com.itextpdf.kernel.pdf.canvas.parser.EventType;
import com.itextpdf.kernel.pdf.canvas.parser.data.IEventData;
import com.itextpdf.kernel.geom.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohsin.shah
 */
public class CustomTextExtractionStrategy extends LocationTextExtractionStrategy {

  //  private List<Rectangle> rectangles = new ArrayList<>();



    //    @Override
//    public void eventOccurred(IEventData data, EventType type) {
//        super.eventOccurred(data, type);
//        if (data instanceof TextRenderInfo) {
//            TextRenderInfo renderInfo = (TextRenderInfo) data;
//            Rectangle rect = renderInfo.getBaseline().getBoundingRectangle();
//            rectangles.add(rect);
////            String text = renderInfo.getText();
////
////            // Print the text and the rectangle's bounds
////            System.out.println("Text in cutsom : " + text);
//
//
//        }
//    }
    private List<com.itextpdf.kernel.geom.Rectangle> rectangles = new ArrayList<>();

    @Override
    public void eventOccurred(IEventData data, EventType type) {
        super.eventOccurred(data, type);
        if (data instanceof TextRenderInfo) {
            TextRenderInfo renderInfo = (TextRenderInfo) data;
            Rectangle rect = renderInfo.getBaseline().getBoundingRectangle();
            rectangles.add(rect);
            // Additional processing can be done here if needed
        }
    }

    public List<Rectangle> getRectangles() {
        return rectangles;
    }
}
