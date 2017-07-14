package petadoptionconsortium;


import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Color;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.*;
import javax.swing.*;
import java.text.*;

/**
 *
 * @author Doug
 */
public class PetAdoptionConsortium {
    public static final int LOGIN_PANEL = 0;
    public static final int GUEST_MENU = 1;
    public static final int SHELTER_SEARCH = 2;
    public static final int PET_SEARCH = 3;
    public static final int EMPLOYEE_MENU = 4;
    public static final int SHELTER_SEARCH_RESULTS = 5;
    public static final int PET_SEARCH_DOG_OR_CAT = 6;
    public static final int PET_SEARCH_RESULTS = 7;
    public static final int ADD_NEW_DOG_OR_CAT = 8;
    public static final int ADD_NEW_PET = 9;
    public static final int ADD_NEW_EVENT = 10;
    public static final int LARGEST_MONTHLY_DONATIONS = 11;
    public static final int ADOPTIONS_INFORMATION_DATE = 12;
    public static final int ADOPTIONS_INFORMATION = 13;
    public static final int ASSIGN_FOSTER = 14;
    public static final int CURRENT_YEAR_PET_ADOPTIONS = 15;
    public static final int QUARTERLY_REPORT = 16;
    public static final int ADD_NEW_EVENT_SUCCESS = 17;
    public static final int ADD_NEW_PET_SUCCESS = 18;
    public static final int ASSIGN_FOSTER_SUCCESS = 19;
    
    public static int currentScreen = 0;
    public static boolean changeScreen = false;
    public static String shelterName = "";
    public static String CURRENT_MONTH;
    public static String CURRENT_DAY;
    public static String CURRENT_YEAR;
    public static final int MAX_AGE = 40;
    
    public static String CONN_STRING = "jdbc:mysql://localhost:3306/Project Revised?zeroDateTimeBehavior=convertToNull";
            
    private static Login loginPanel;
    private static GuestMenu guestMenu;
    private static ShelterSearch shelterSearch;
    private static PetSearch petSearch;
    private static EmployeeMenu employeeMenu;
    private static ShelterSearchResults shelterSearchResults;
    private static PetSearchDogOrCat petSearchDogOrCat;
    private static PetSearchResults petSearchResults;
    private static AddNewDogOrCat addNewDogOrCat;
    private static AddNewPet addNewPet;
    private static AddNewEvent addNewEvent;
    private static LargestMonthlyDonations largestMonthlyDonations;
    private static AdoptionsInformationDate adoptionsInformationDate;
    private static AdoptionsInformation adoptionsInformation;
    private static AssignFoster assignFoster;
    private static CurrentYearPetAdoptions currentYearPetAdoptions;
    private static QuarterlyReport quarterlyReport;
    private static AddNewEventSuccess addNewEventSuccess;
    private static AddNewPetSuccess addNewPetSuccess;
    private static AssignFosterSuccess assignFosterSuccess;
    
    private static CardLayout cards;
    

    public static void main(String[] args) {  
        DateFormat dateFormat = new SimpleDateFormat("M");
	Date date = new Date();
	int num = Integer.parseInt(dateFormat.format(date));
        CURRENT_MONTH = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            CURRENT_MONTH = months[num-1];
        }
        DateFormat dateFormat2 = new SimpleDateFormat("d");
        CURRENT_DAY = dateFormat2.format(date);
        DateFormat dateFormat3 = new SimpleDateFormat("YYYY");
        CURRENT_YEAR = dateFormat3.format(date);
        
        cards = new CardLayout();
        JFrame frame = new JFrame();
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(cards);
        loginPanel = new Login();
        guestMenu = new GuestMenu();
        shelterSearch = new ShelterSearch();
        petSearch = new PetSearch();
        employeeMenu = new EmployeeMenu();
        petSearchDogOrCat = new PetSearchDogOrCat();
        shelterSearchResults = new ShelterSearchResults();
        petSearchResults = new PetSearchResults();
        addNewDogOrCat = new AddNewDogOrCat();
        addNewPet = new AddNewPet();
        addNewEvent = new AddNewEvent();
        largestMonthlyDonations = new LargestMonthlyDonations();
        adoptionsInformationDate = new AdoptionsInformationDate();
        adoptionsInformation = new AdoptionsInformation();
        assignFoster = new AssignFoster();
        currentYearPetAdoptions = new CurrentYearPetAdoptions();
        quarterlyReport = new QuarterlyReport(); 
        addNewEventSuccess = new AddNewEventSuccess();
        addNewPetSuccess = new AddNewPetSuccess();
        assignFosterSuccess = new AssignFosterSuccess();

        cards.addLayoutComponent(loginPanel,"Login Panel");
        cards.addLayoutComponent(guestMenu,"Guest Menu");
        cards.addLayoutComponent(shelterSearch,"Shelter Search");
        cards.addLayoutComponent(petSearch,"Pet Search");
        cards.addLayoutComponent(employeeMenu,"Employee Menu");
        cards.addLayoutComponent(shelterSearchResults, "Shelter Search Results");
        cards.addLayoutComponent(petSearchDogOrCat, "Pet Search Dog Or Cat");
        cards.addLayoutComponent(petSearchResults, "Pet Search Results");
        cards.addLayoutComponent(addNewDogOrCat, "Add New Dog Or Cat");
        cards.addLayoutComponent(addNewPet, "Add New Pet");
        cards.addLayoutComponent(addNewEvent, "Add New Event");
        cards.addLayoutComponent(largestMonthlyDonations, "Largest Monthly Donations");
        cards.addLayoutComponent(adoptionsInformationDate, "Adoptions Information Date");
        cards.addLayoutComponent(adoptionsInformation, "Adoptions Information");
        cards.addLayoutComponent(assignFoster, "Assign Foster");
        cards.addLayoutComponent(currentYearPetAdoptions, "Current Year Pet Adoptions");
        cards.addLayoutComponent(quarterlyReport, "Quarterly Report");
        cards.addLayoutComponent(addNewEventSuccess, "Add New Event Success");
        cards.addLayoutComponent(addNewPetSuccess, "Add New Pet Success");
        cards.addLayoutComponent(assignFosterSuccess,"Assign Foster Success");
        cardPanel.add(loginPanel);
        cardPanel.add(guestMenu);
        cardPanel.add(shelterSearch);
        cardPanel.add(petSearch);
        cardPanel.add(employeeMenu);
        cardPanel.add(shelterSearchResults);
        cardPanel.add(petSearchDogOrCat);
        cardPanel.add(petSearchResults);
        cardPanel.add(addNewDogOrCat);
        cardPanel.add(addNewPet);
        cardPanel.add(addNewEvent);
        cardPanel.add(largestMonthlyDonations);
        cardPanel.add(adoptionsInformationDate);
        cardPanel.add(adoptionsInformation);
        cardPanel.add(assignFoster);
        cardPanel.add(currentYearPetAdoptions);
        cardPanel.add(quarterlyReport);
        cardPanel.add(addNewEventSuccess);
        cardPanel.add(addNewPetSuccess);
        cardPanel.add(assignFosterSuccess);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(cardPanel);
        frame.pack();
        frame.setVisible(true);
        while (true) {
            System.out.print("|");
            if (changeScreen == true) {
                if (currentScreen == LOGIN_PANEL) {                    
                    cards.show(cardPanel, "Login Panel");
                }
                if (currentScreen == GUEST_MENU) {
                    cards.show(cardPanel, "Guest Menu");
                }
                if (currentScreen == SHELTER_SEARCH) {
                    cards.show(cardPanel, "Shelter Search");
                }
                if (currentScreen == PET_SEARCH) {
                    cardPanel.remove(petSearch);
                    cards.removeLayoutComponent(petSearch);
                    petSearch = new PetSearch();
                    cardPanel.add(petSearch);
                    cards.addLayoutComponent(petSearch, "Pet Search");
                    //System.exit(1);
                    cards.show(cardPanel, "Pet Search");
                }
                if (currentScreen == EMPLOYEE_MENU) {
                    cards.show(cardPanel, "Employee Menu");
                }
                if (currentScreen == SHELTER_SEARCH_RESULTS) {
                    cardPanel.remove(shelterSearchResults);
                    cards.removeLayoutComponent(shelterSearchResults);
                    shelterSearchResults = new ShelterSearchResults();
                    cardPanel.add(shelterSearchResults);
                    cards.addLayoutComponent(shelterSearchResults, "Shelter Search Results");
                    cards.show(cardPanel, "Shelter Search Results");
                }
                if (currentScreen == PET_SEARCH_DOG_OR_CAT) {
                    cards.show(cardPanel, "Pet Search Dog Or Cat");
                }
                if (currentScreen == PET_SEARCH_RESULTS) {
                    cardPanel.remove(petSearchResults);
                    cards.removeLayoutComponent(petSearchResults);
                    petSearchResults = new PetSearchResults();
                    cardPanel.add(petSearchResults);
                    cards.addLayoutComponent(petSearchResults, "Pet Search Results");
                    cards.show(cardPanel, "Pet Search Results");
                }
                if (currentScreen == ADD_NEW_DOG_OR_CAT) {
                    cards.show(cardPanel, "Add New Dog Or Cat");
                }
                if (currentScreen == ADD_NEW_PET) {
                    cardPanel.remove(addNewPet);
                    cards.removeLayoutComponent(addNewPet);
                    addNewPet = new AddNewPet();
                    cardPanel.add(addNewPet);
                    cards.addLayoutComponent(addNewPet, "Add New Pet");
                    cards.show(cardPanel, "Add New Pet");
                }
                
                if(currentScreen == ADD_NEW_EVENT) { 
                    cardPanel.remove(addNewEvent);
                    cards.removeLayoutComponent(addNewEvent);
                    addNewEvent = new AddNewEvent();
                    cardPanel.add(addNewEvent);
                    cards.addLayoutComponent(addNewEvent, "Add New Event");
                    cards.show(cardPanel, "Add New Event");
                }
                if(currentScreen == LARGEST_MONTHLY_DONATIONS) {
                    cardPanel.remove(largestMonthlyDonations);
                    cards.removeLayoutComponent(largestMonthlyDonations);
                    largestMonthlyDonations = new LargestMonthlyDonations();
                    cardPanel.add(largestMonthlyDonations);
                    cards.addLayoutComponent(largestMonthlyDonations, "Largest Monthly Donations");
                    cards.show(cardPanel, "Largest Monthly Donations");
                }
                if(currentScreen == ADOPTIONS_INFORMATION_DATE) {
                    cards.show(cardPanel, "Adoptions Information Date");
                }
                if(currentScreen == ADOPTIONS_INFORMATION) {
                    cardPanel.remove(adoptionsInformation);
                    cards.removeLayoutComponent(adoptionsInformation);
                    adoptionsInformation = new AdoptionsInformation();
                    cardPanel.add(adoptionsInformation);
                    cards.addLayoutComponent(adoptionsInformation, "Adoptions Information");
                    cards.show(cardPanel, "Adoptions Information");
                }
                if(currentScreen == ASSIGN_FOSTER) {
                    cardPanel.remove(assignFoster);
                    cards.removeLayoutComponent(assignFoster);
                    assignFoster = new AssignFoster();
                    cardPanel.add(assignFoster);
                    cards.addLayoutComponent(assignFoster, "Assign Foster");
                    cards.show(cardPanel, "Assign Foster");
                }
                if(currentScreen == CURRENT_YEAR_PET_ADOPTIONS) {
                    cardPanel.remove(currentYearPetAdoptions);
                    cards.removeLayoutComponent(currentYearPetAdoptions);
                    currentYearPetAdoptions = new CurrentYearPetAdoptions();
                    cardPanel.add(currentYearPetAdoptions);
                    cards.addLayoutComponent(currentYearPetAdoptions, "Current Year Pet Adoptions");
                    cards.show(cardPanel, "Current Year Pet Adoptions");
                }
                if(currentScreen == QUARTERLY_REPORT) {
                    cardPanel.remove(quarterlyReport);
                    cards.removeLayoutComponent(quarterlyReport);
                    quarterlyReport = new QuarterlyReport();
                    cardPanel.add(quarterlyReport);
                    cards.addLayoutComponent(quarterlyReport, "Quarterly Report");
                    cards.show(cardPanel, "Quarterly Report");
                }
                if(currentScreen == ADD_NEW_EVENT_SUCCESS) {
                    cardPanel.remove(addNewEventSuccess);
                    cards.removeLayoutComponent(addNewEventSuccess);
                    addNewEventSuccess = new AddNewEventSuccess();
                    cardPanel.add(addNewEventSuccess);
                    cards.addLayoutComponent(addNewEventSuccess, "Add New Event Success");
                    cards.show(cardPanel, "Add New Event Success");
                }
                if(currentScreen == ADD_NEW_PET_SUCCESS) {
                    cardPanel.remove(addNewPetSuccess);
                    cards.removeLayoutComponent(addNewPetSuccess);
                    addNewPetSuccess = new AddNewPetSuccess();
                    cardPanel.add(addNewPetSuccess);
                    cards.addLayoutComponent(addNewPetSuccess, "Add New Pet Success");
                    cards.show(cardPanel, "Add New Pet Success");
                }
                if(currentScreen == ASSIGN_FOSTER_SUCCESS) {
                    cardPanel.remove(assignFosterSuccess);
                    cards.removeLayoutComponent(assignFosterSuccess);
                    assignFosterSuccess = new AssignFosterSuccess();
                    cardPanel.add(assignFosterSuccess);
                    cards.addLayoutComponent(assignFosterSuccess, "Assign Foster Success");
                    cards.show(cardPanel, "Assign Foster Success");
                }
                changeScreen = false;
            }
        }
    }

}
