package ui;

import model.Habit;
import model.Tracker;

import java.util.Scanner;

public class HabitRabbitApp {
    private Tracker account;
    private Scanner input;
    private String rabbitName;
    private Habit selectedHabit;
    private boolean valid;
    int option;
    int selection;

    // EFFECTS: runs the Habit Rabbit application
    public HabitRabbitApp() {
        runApp();
    }

    // EFFECTS: processes the main program and introduction
    public void runApp() {
        boolean keepGoing = true;
        String command;
        valid = true;

        input = new Scanner(System.in);
        idleRabbit();
        introduction();

        init();

        happyRabbit();
        introTwo();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nHave a productive day!");
    }

    // EFFECTS: prints out the second part of the introduction
    private void introTwo() {
        System.out.println("Nice to meet you!");
        System.out.println("\nMy name is ");
        System.out.println("===============================================");
        System.out.println("\t\t\t" + rabbitName.toUpperCase());
        System.out.println("===============================================");
        System.out.println("\nEverything you do contributes to my health and well-being.");
    }

    // EFFECTS: prints out rabbit in idle state
    private void idleRabbit() {
        System.out.println(" ()() ");
        System.out.println(" ( O.O)");
        System.out.println(" o_(    )");
    }

    // EFFECTS: prints out rabbit in happy state
    private void happyRabbit() {
        System.out.println(" ()() ");
        System.out.println(" ( ^.^)");
        System.out.println(" o_(    )");
    }

    // EFFECTS: prints out rabbit in sad state
    private void sadRabbit() {
        System.out.println(" ()() ");
        System.out.println(" ( -.-)");
        System.out.println(" o_(    )");
    }

    // MODIFIES: Rabbit
    // EFFECTS: prints out the first  part of the introduction and scans user input for the rabbit name
    private void introduction() {
        System.out.println("Hi, I am...");
        System.out.println("===============================================");
        System.out.println("\t\t\tHabbit the Rabbit!");
        System.out.println("===============================================");
        System.out.println("I am going to help you achieve the best you!");
        System.out.println("\nFirstly, give me a name!");
        System.out.println("\nEnter name:");

        rabbitName = input.nextLine();
    }

    // EFFECTS: navigates through the app depending on the user's input
    private void processCommand(String command) {
        if (command.equals("r")) {
            doViewRabbit();
        } else if (command.equals("h")) {
            doAddHabits();
        } else if (command.equals("v")) {
            doModifyHabits();
        } else {
            System.out.println("Selection not valid; try again!");
        }
    }

    // EFFECTS: initializes new tracker with the formerly defined rabbit name
    private void init() {
        account = new Tracker(rabbitName);
    }

    // EFFECTS: prints out the main menu in the app home screen
    private void displayMenu() {
        System.out.println("\nWhat would you like to do today?");
        System.out.println("\tr -> view and modify rabbit");
        System.out.println("\tv -> view and modify habits");
        System.out.println("\th -> add habits");
        System.out.println("\tq -> log out");
    }

    // MODIFIES: rabbit
    // EFFECTS: navigates to the page where the user can view the rabbit and its status
    private void doViewRabbit() {
        rabbitStatusCheck();
        valid = true;

        while (valid) {
            if (account.getRabbitHappinessStatus()) {
                happyHappy();
                modifyRabbit();
            } else {
                sadSad();
                modifyRabbit();
            }
        }
    }

    // EFFECTS : prints out rabbit happy state and status
    private void happyHappy() {
        happyRabbit();
        System.out.println("===============================================");
        System.out.println("\t\t\t" + account.getRabbitName().toUpperCase());
        System.out.println("===============================================");
        System.out.println("Status: Happy");
        System.out.println("\nHappiness: " + account.getRabbitHappiness() + " / "
                + account.getRabbitMaxHappiness());
        System.out.println("Fitness: " + account.getLifestyleCompleted() + " / " + account.getLifestyleGoal());
        System.out.println("Diet: " + account.getDietCompleted() + " / " + account.getDietGoal());
        System.out.println("Social Life: " + account.getSocialCompleted() + " / " + account.getSocialGoal());
        System.out.println("Entertainment: " + account.getHobbyCompleted() + " / " + account.getHobbyGoal());
    }

    // EFFECTS : prints out rabbit sad state and status
    private void sadSad() {
        sadRabbit();
        System.out.println("===============================================");
        System.out.println("\t\t\t" + account.getRabbitName().toUpperCase());
        System.out.println("===============================================");
        System.out.println("Status: Sad");
        System.out.println("\nHappiness: " + account.getRabbitHappiness() + " / "
                + account.getRabbitMaxHappiness());
        System.out.println("Fitness: " + account.getLifestyleCompleted() + " / " + account.getLifestyleGoal());
        System.out.println("Diet: " + account.getDietCompleted() + " / " + account.getDietGoal());
        System.out.println("Social Life: " + account.getSocialCompleted() + " / " + account.getSocialGoal());
        System.out.println("Entertainment: " + account.getHobbyCompleted() + " / " + account.getHobbyGoal());
    }

    // EFFECTS : gives the user two options:
    //              1. modify rabbit name
    //              2. quit rabbit viewing page
    private void modifyRabbit() {
        System.out.println("Select an option: ");
        System.out.println("\t1. Modify rabbit name");
        System.out.println("\t2. Quit configuration");
        option = input.nextInt();
        if (option == 1) {
            modifyRabbitName();
        } else if (option == 2) {
            valid = false;
        }
    }

    // MODIFIES : rabbit
    // EFFECTS : modifies rabbit name based on user input
    private void modifyRabbitName() {
        System.out.println("Current name: " + account.getRabbitName());
        System.out.println("\nEnter new name:");
        input.nextLine();
        String newName = input.nextLine();
        account.modifyRabbitName(newName);
    }

    // MODIFIES : rabbit
    // EFFECTS : updates rabbit overall status
    private void rabbitStatusCheck() {
        account.rabbitSetHappiness();
        account.rabbitSetHappinessStatus();
        account.rabbitSetMaxHappiness();
        account.isFit();
        account.isSociable();
        account.isEntertained();
        account.isDietGood();
    }

    // EFFECTS : checks if the tracker is empty and prints out habit list
    private void doModifyHabits() {
        if (account.getHabits().size() == 0) {
            trackerEmpty();
        } else {
            habitOptions();
        }
    }

    // EFFECTS : prints list of habits and lets the user select a habit to configure
    public void habitOptions() {
        printListOfHabit();
        selection = input.nextInt();
        valid = true;

        while (valid) {
            selectedHabit = account.getHabits().get(selection - 1);
            printHabitSpecs();
            habitConfigOptions();
            option = input.nextInt();

            if (option == 1) {
                doAddProgress();
            } else if (option == 2) {
                doModifyTitle();
            } else if (option == 3) {
                doModifyDesc();
            } else if (option == 4) {
                doModifyCategory();
            } else if (option == 5) {
                valid = false;
            } else {
                System.out.println("Selection not valid; try again!");
            }
        }
    }

    // EFFECTS : prints list of existing habits
    public void printListOfHabit() {
        System.out.println("Select a habit you want to modify:\n");
        int p = 1;

        for (Habit u : account.getHabits()) {
            System.out.println("\t" + p + ". " + u.getTitle());
            p++;
        }
        System.out.println("\nEnter number here:");
    }

    // MODIFIES : habit
    // EFFECTS : add progress to selected habit
    public void doAddProgress() {
        account.progressHabit(selection - 1);
        System.out.println("Progress successfully added!");
    }

    // MODIFIES : habit
    // EFFECTS : modifies the selected habit's title
    public void doModifyTitle() {
        account.selectHabit(account.getHabits().get(selection - 1));
        System.out.println("Current name: " + account.getSelected().getTitle());
        System.out.println("\nEnter new name:");

        String newTitle = input.nextLine();
        account.getSelected().modifyTitle(newTitle);

        System.out.println("Habit name changed to " + newTitle);
    }

    // MODIFIES : habit
    // EFFECTS : modifies the selected habit's description
    public void doModifyDesc() {
        account.selectHabit(account.getHabits().get(selection - 1));
        System.out.println("Current description: " + account.getSelected().getDesc());
        System.out.println("\nEnter new description:");

        String newDesc = input.nextLine();
        account.getSelected().modifyDescription(newDesc);

        System.out.println("Habit description changed to " + newDesc);
    }

    // MODIFIES : habit
    // EFFECTS : modifies the selected habit's category
    public void doModifyCategory() {
        account.selectHabit(account.getHabits().get(selection - 1));
        System.out.println("Current category: " + account.getSelected().getCategory());
        System.out.println("\nEnter new category:");

        String newCategory = chooseCategory();
        account.getSelected().modifyCategory(newCategory);

        System.out.println("Habit category changed to " + newCategory);
    }

    // EFFECTS : prints out habit specifications
    public void printHabitSpecs() {
        System.out.println("\nTitle: " + selectedHabit.getTitle());
        System.out.println("===============================================");
        System.out.println("Description: " + selectedHabit.getDesc());
        System.out.println("Category: " + selectedHabit.getCategory());
        System.out.println("Goal: " + selectedHabit.getPerDay() + " per day");
        System.out.println("Done: " + selectedHabit.getProgress() + " times\n");
    }

    // EFFECTS : prints out option to mofify a habit
    public void habitConfigOptions() {
        System.out.println("Select an option");
        System.out.println("\t1 -> add progress (+1)");
        System.out.println("\t2 -> modify title");
        System.out.println("\t3 -> modify description");
        System.out.println("\t4 -> modify category");
        System.out.println("\t5 -> save and exit configuration");
    }

    // EFFECTS : prints out a warning that the list of habit is currently empty
    public void trackerEmpty() {
        System.out.println("The habit list is currently empty!");
        System.out.println("Add a habit!");
    }

    // MODIFIES : Tracker
    // EFFECTS: add more habits to the tracker
    private void doAddHabits() {
        input.nextLine();
        System.out.println("Enter habit title:");
        String title = input.nextLine();
        System.out.println("Enter habit description:");
        String desc = input.nextLine();
        String category = chooseCategory();
        System.out.println("Enter habit goal (must be an integer!):");
        int goal = input.nextInt();
        Habit newHabit = new Habit(title, desc, goal, category);
        account.addHabit(newHabit);
        System.out.println("Habit successfully added!");
    }

    // MODIFIES : Habit
    // EFFECTS : choose new habit's category
    private String chooseCategory() {
        boolean proceed = true;
        String category = "<Select Category>";

        while (proceed) {
            categoryOptions();

            int pick = input.nextInt();
            if (pick == 1) {
                category = "Lifestyle";
                proceed = false;
            } else if (pick == 2) {
                category = "Social";
                proceed = false;
            } else if (pick == 3) {
                category = "Diet";
                proceed = false;
            } else if (pick == 4) {
                category = "Hobby";
                proceed = false;
            } else {
                System.out.println("Selection not valid; try again!");
            }
        }
        return category;
    }

    // EFFECTS : prints out available habit categories
    public void categoryOptions() {
        System.out.println("Choose habit category:");
        System.out.println("\t1 -> Lifestyle");
        System.out.println("\t2 -> Social");
        System.out.println("\t3 -> Diet");
        System.out.println("\t4 -> Hobby");
    }
}
