package demo.app;

import spark.Spark;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Spark.get("/first", (req, res) -> "First Spark application");
    }
}
