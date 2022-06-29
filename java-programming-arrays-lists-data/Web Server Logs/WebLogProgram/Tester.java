
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        logAnalyzer.printAll();
    }
    
    public void testUniqueIP() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        System.out.println("countUniqueIPs: " + logAnalyzer.countUniqueIPs() + "IP");
    }
    
    public void testPrintAllHigherThanNum() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog1_log");
        System.out.println("========================");
        logAnalyzer.printAllHigherThanNum(400);
    }
    
    public void testUniqueIPVisitsOnDay() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog1_log");
        System.out.println("========================");
        System.out.println("testUniqueIPVisitsOnDay: " + logAnalyzer.uniqueIPVisitsOnDay("Mar 24").size() + "IP");
    }
    
    public void testCountUniqueIPsInRange() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog1_log");
        System.out.println("========================");
        System.out.println("testCountUniqueIPsInRange: " + logAnalyzer.countUniqueIPsInRange(200,299));
    }
    
    public void testMostNumberVisitsByIP() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog3-short_log");
        System.out.println("========================");
        System.out.println("mostNumberVisitsByIP: " + logAnalyzer.mostNumberVisitsByIP(logAnalyzer.countVisitsPerIP()));
    }
    
    public void testIPsMostVisits() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog3-short_log");
        System.out.println("========================");
        System.out.println("iPsMostVisits: " + logAnalyzer.iPsMostVisits(logAnalyzer.countVisitsPerIP()));
    }
}
