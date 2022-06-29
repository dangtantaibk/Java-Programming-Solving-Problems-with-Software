
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;


public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<>();
     }
     
     
     // HashMap
     public HashMap<String, Integer> countVisitsPerIP() {
         HashMap<String, Integer> visitMap = new HashMap<>();
         for (LogEntry logEntry : records) {
             String key = logEntry.getIpAddress();
             int visit = 0;
             if (visitMap.containsKey(key)) {
                 visit = visitMap.get(key);
             }
             visitMap.put(key, visit + 1);
         }
         return visitMap;
     }
     
     public int mostNumberVisitsByIP(HashMap<String, Integer> visitMap) {
         int maxVisit = 0;
         for (String i : visitMap.keySet()) {
             int visit = visitMap.get(i);
             if (maxVisit < visit) {
                 maxVisit = visit;
             }
         }
         return maxVisit;
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> visitMap) {
         ArrayList<String> ips =  new ArrayList<>();
         int maxVisit = 0;
         for (String i : visitMap.keySet()) {
             int visit = visitMap.get(i);
             if (maxVisit < visit) {
                 maxVisit = visit;
                 ips = new ArrayList<>();
                 ips.add(i);
             } else if (maxVisit == visit) {
                 ips.add(i);
             }
         }
         return ips;
     }
     
     public HashMap<String, ArrayList<String>> iPsForDays() {
         HashMap<String, ArrayList<String>> ipsForDayMap = new HashMap<>();
         for (LogEntry logEntry : records) {
             SimpleDateFormat format = new SimpleDateFormat("MMM DD");
             String key = logEntry.getAccessTime().get();
             if (!ipsForDayMap.contains(logEntry.getIpAddress())) {
                 recordIps.add(logEntry.getIpAddress());
             }
         }
         
         return ipsForDayMap;
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource file = new FileResource(filename);
         for (String line : file.lines()) {
             LogEntry logEntry = WebLogParser.parseEntry(line);
             records.add(logEntry);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs() {
         ArrayList<String> recordIps = new ArrayList<>();
         for (LogEntry logEntry : records) {
             if (!recordIps.contains(logEntry.getIpAddress())) {
                 recordIps.add(logEntry.getIpAddress());
             }
         }
         return recordIps.size();
     }
     
     
     public void printAllHigherThanNum(int num) {
         for (LogEntry logEntry: records) {
             if (logEntry.getStatusCode() > num) {
                 System.out.println(logEntry);
             }
         }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
         ArrayList<String> ips = new ArrayList<>();
         for (LogEntry logEntry: records) {
             if (logEntry.getAccessTime().toString().contains(someday)) {
                if (!ips.contains(logEntry.getIpAddress())) {
                    ips.add(logEntry.getIpAddress());
                }
             }
         }
         
         return ips;
     }
     
     public int countUniqueIPsInRange(int low, int high) {
         ArrayList<String> ips = new ArrayList<>();
         for (LogEntry logEntry: records) {
             if (logEntry.getStatusCode() >= low && logEntry.getStatusCode() <= high) {
                if (!ips.contains(logEntry.getIpAddress())) {
                     ips.add(logEntry.getIpAddress());
                }
             }
            }
         return ips.size();
    }
     
     
}
