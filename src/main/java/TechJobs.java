import java.util.*;

/**
 * Created by LaunchCode
 */
public class TechJobs {

    static Scanner in = new Scanner(System.in);

    public static void main (String[] args) {

        // Initialize our field map with key/name pairs
        HashMap<String, String> columnChoices = new HashMap<>();
        columnChoices.put("core competency", "Skill");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("position type", "Position Type");
        columnChoices.put("all", "All");

        // Top-level menu options
        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        System.out.println("Welcome to LaunchCode's TechJobs App!\n");



        // Allow the user to search until they manually quit
        while (true) {

            String actionChoice = getUserSelection("View jobs by (type 'x' to quit):", actionChoices);

            if (actionChoice == null) {
                break;
            } else if (actionChoice.equals("list")) {

                String columnChoice = getUserSelection("\nList", columnChoices);

                if (columnChoice.equals("all")) {
                    printJobs(JobData.findAll());
                } else {

                    ArrayList<String> results = JobData.findAll(columnChoice);

                    System.out.println("\n*** All " + columnChoices.get(columnChoice) + " Values ***\n");

                    // Print list of skills, employers, etc
                    for (String item : results) {
                        System.out.println(item);
                    }
                }

            } else { // choice is "search"

                // How does the user want to search (e.g. by skill or employer)
                String searchField = getUserSelection("\nSearch by:", columnChoices);

                // What is their search term?
                System.out.println("\nSearch term:");
                String searchTerm = in.nextLine();

                if (searchField.equals("all")) {
                    printJobs(JobData.findByValue(searchTerm));
                } else {
                    printJobs(JobData.findByColumnAndValue(searchField, searchTerm));


                }


            }
        }
    }

    // ﻿Returns the key of the selected item from the choices Dictionary
    private static String getUserSelection(String menuHeader, HashMap<String, String> choices) {

        int choiceIdx = -1;
        Boolean validChoice = false;
        String[] choiceKeys = new String[choices.size()];

        // Put the choices in an ordered structure so we can
        // associate an integer with each one
        int i = 0;
        for (String choiceKey : choices.keySet()) {
            choiceKeys[i] = choiceKey;
            i++;
        }

        do {

            System.out.println(menuHeader);

            // Print available choices
            for (int j = 0; j < choiceKeys.length; j++) {
                System.out.println("" + j + " - " + choices.get(choiceKeys[j]));
            }

            if (in.hasNextInt()) {
                choiceIdx = in.nextInt();
                in.nextLine();
            } else {
                String line = in.nextLine();
                boolean shouldQuit = line.equals("x");
                if (shouldQuit) {
                    return null;
                }
            }

            // Validate user's input
            if (choiceIdx < 0 || choiceIdx >= choiceKeys.length) {
                System.out.println("Invalid choice. Try again.");
            } else {
                validChoice = true;
            }

        } while(!validChoice);

        return choiceKeys[choiceIdx];
    }

    // Print a list of jobs
    private static void printJobs(ArrayList<HashMap<String, String>> someJobs) {

        if (someJobs.isEmpty()) {
                System.out.println("No Results");
        } else {
            for (HashMap<String, String> someJob : someJobs) {
                    System.out.println("*****");
                    someJob.forEach((key, value) -> System.out.println(key + ": " + value));
                    System.out.println("*****\n");
            }
        }

    }

}



















//                    someJob.forEach((key, value) -> System.out.println(JobData.findByColumnAndValue(key, value).contains(someJob)));
//                    System.out.println(JobData.findByColumnAndValue(in, in.next()));


//        for (int i = 0; i < someJobs.size(); i++) {
//            System.out.println("*****");
//            someJobs.get(i).forEach((key, value) -> System.out.println(key + ": " + value));
//            System.out.println("*****\n");
//        }

//                    System.out.println("No Results");







//            HashMap<String, String> listing = new HashMap<>();
//            listing.put("test", "one");
//            listing.put("tests", "two");
//        Set<Map.Entry<String, String> > entrySet
//                = listing.entrySet();
//        System.out.println("Entry Set: " + entrySet);
//            System.out.println(listing.values());





//        HashMap<String, String> listing = new HashMap<>();
//        String jobKey;
//        String jobValue;
//        someJobs.forEach(listing.put(jobKey, jobValue));

//        for (String key : someJobs.get(1).keySet()) {
//        }
//        String[] listing = new String[someJobs.size()];
//        someJobs.toArray(listing);
//         System.out.println(Arrays.toString(listing));

//            HashMap<String, String> listing = new HashMap<>();
//            String jobKey = someJobs.toString();
//            String jobValue = "test";
//                listing.put(jobKey, jobValue);

//        System.out.println("printJobs is not implemented yet");
//

//        System.out.println(someJobs.get(i));
//            Set<Map.Entry<String, String> > entrySet
//                    = listing.entrySet();
//            System.out.println("Entry Set: " + entrySet);

//            HashMap<String, String> data1 = new HashMap<String, String>();
//            data1.put("0",new Integer(1));
//            data1.put("1",new Integer(2));
//            data1.put("2",new Integer(3));
//            data1.put("3",new Integer(4));
//
//            HashMap<String, Integer> data2 = new HashMap<String, Integer>();
//            data1.put("10",new Integer(10));
//            data1.put("11",new Integer(20));
//            data1.put("12",new Integer(30));
//            data1.put("13",new Integer(40));
//
//            someJobs.add(data1);
//            someJobs.add(data2);
//
//
//            for (int a =0; a<someJobs.size();a++)
//            {
//                HashMap<String, Integer> tmpData = (HashMap<String, Integer>) someJobs.get(a);
//                Set<String> key = tmpData.keySet();
//                Iterator it = key.iterator();
//                while (it.hasNext()) {
//                    String hmKey = (String)it.next();
//                    Integer hmData = (Integer) tmpData.get(hmKey);
//
//                    System.out.println("Key: "+hmKey +" & Data: "+hmData);
//                    it.remove(); // avoids a ConcurrentModificationException
//                }
//
//            }








//        for (Map.Entry<String, String> job : someJobs.entrySet()) {
//            System.out.println(job.getKey() + " (" + job.getValue() + ")");
////            sum += student.getValue();
//        }




//        ArrayList<HashMap<String, String>> test = new ArrayList<HashMap<String, String>>();
//        HashMap<String, String> n = new HashMap<>();
//        n.put("a", "a");
//        n.put("b", "b");
//        someJobs.add(n);
//
//        HashMap<String, String> m = someJobs.get(0);//it will get the first HashMap Stored in array list
//
//        String strArr[] = new String[m.size()];
//        int i = 0;
//        for (HashMap<String, String> hash : someJobs) {
//            for (String current : hash.values()) {
//                strArr[i] = current;
//                i++;
//            }
//        }
//        System.out.println(n);





//        ArrayList<HashMap<String, String>> test = new ArrayList<>();
//        String sum = "";
//        for (HashMap<String, String> hash : someJobs) {
//            for (String current : hash.values()) {
//                sum = sum + current + "<#>";
//            }
//        }
//        String[] arr = sum.split("<#>");
//        System.out.println(arr);



//        for (Map.Entry<String, String> ee : someJobs.entrySet()) {
//            String key = ee.getKey();
//            String values = ee.getValue();
//
//        }
//        System.out.println(JobData.findAll(getUserSelection("enterprise"));


//        System.out.println(JobData.findAll(ArrayList<String> values));




//        ArrayList<String> test = new ArrayList<>();
//
//        for (Map.Entry<String, String> entry: JobData.findAll()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }

//        Set<Map.Entry<String,Integer>> s = couliu.entrySet();
//        for (Map.Entry<String, String> columnChoices




//        System.out.println(JobData.findAll());
//        for (Map.Entry<String, String> jobs : jobs.entrySet()) {
//            System.out.println(someJobs.getKey() + " :" + someJobs.getValue() + ")");
//            sum += student.getValue();
//        }
//       need to map key + ": " + value
//        need to print ***** on top and bottom


//        System.out.println(`*****
//        position type: Data Scientist / Business Intelligence
//        name: Sr. IT Analyst (Data/BI)
//        employer: Bull Moose Industries
//        location: Saint Louis
//        core competency: Statistical Analysis
//*****`);
