package org.fariha.serializationdeserialization.resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Safelist;

public class HtmlCleaner {
    public static void main(String[] args) {
        String dirtyHtml = """
                THE_HTML_HERE""";

        // Parse the HTML
        Document dirtyDoc = Jsoup.parse(dirtyHtml);

        // Clean the HTML using a Safelist
        Safelist safelist = Safelist.relaxed()
                .addTags("noscript", "meta")
                .addAttributes(":all", "charset", "http-equiv", "content", "href");

        Cleaner cleaner = new Cleaner(safelist);
        Document cleanDoc = cleaner.clean(dirtyDoc);

        // Beautify the cleaned HTML
        String cleanedHtml = cleanDoc.html();

        // Print the cleaned HTML
        // System.out.println("Cleaned HTML:\n" + cleanedHtml);

        // Clean and parse the HTML
        Document document = Jsoup.parse(cleanedHtml.replace("\\r\\n", "").replace("\\&quot;", "\""));

        System.out.println(document.html());

        // Extract specific elements
        String regNumber = document.select("h3:contains(A-)").text();
        String name = document.select("h3:contains(UMME HANIFA HIMU)").text();
        String regYear = document.select("li:contains(Reg. Year) h5 span").text();
        String regValidTill = document.select("li:contains(Reg. Valid Till) h5 span").text();
        String dob = document.select("div:contains(Date of Birth) h6").text();
        String bloodGroup = document.select("div:contains(Blood Group) h6").text();
        String fatherName = document.select("div:contains(Father`s Name) h6").text();
        String motherName = document.select("div:contains(Mother`s Name) h6").text();
        String regStatus = document.select("div:contains(Registration Status) h6 span").text();

        // Output cleaned data
        System.out.println("Reg. Number: " + regNumber);
        System.out.println("Name: " + name);
        System.out.println("Reg. Year: " + regYear);
        System.out.println("Valid Till: " + regValidTill);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Father's Name: " + fatherName);
        System.out.println("Mother's Name: " + motherName);
        System.out.println("Registration Status: " + regStatus);
    }
}
