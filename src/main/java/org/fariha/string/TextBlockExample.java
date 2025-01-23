package org.fariha.string;

public class TextBlockExample {
    public static void main(String[] args) {
        String json = """
                {
                    "name": "John Doe",
                    "age": 30,
                    "address": {
                        "city": "New York",
                        "country": "USA"
                    }
                }
                """;

        System.out.println(json);
    }
}
