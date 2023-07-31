
import java.util.Scanner;

/**
 * @author Adriel Manuel D. Fancubit
 */

public class Main {
    public static void main(String argcs[])
    {
        startingPageView startingpageview = new startingPageView();
        startingPageController startingpagecontroller = new startingPageController(startingpageview);

        //regularVM regular = new regularVM();
        int option = 1;
        int features;
        int numberofslots;
        String name;
        Scanner sc = new Scanner(System.in);

        //startingPageView startingpage = new startingPageView();

        // CREATING A VENDING MACHINE
        RegularVendingMachine vendingmachine = new RegularVendingMachine("placeholder");
        Item temp;
        String itemName;
        float itemPrice, itemCalories;
        int itemQuantity;
        int slotAdd; 
        int machine = 1;
        int addMoney;
        //

        // vending features
        int vendingContinue = 0;
        float totalCash;

        // maintenance features
        int maintenancefeatures = 1;
        String restockItem;
        int restockQuantity;

        String changePriceItem;
        float changePrice;


        while(option!=3)
        {
            option = 0; // ensure that option has reset
            
            System.out.println("Welcome to Vending Machine Factory Simulator");
            System.out.println("OPTIONS::");
            System.out.println("[1] Create a Vending Machine");
            System.out.println("[2] Test Vending machine");
            System.out.println("[3] Exit");
            System.out.print(">> ");
            option = sc.nextInt();
            sc.nextLine(); // to remove the \n
            
            

            if (option == 1)
            { 
                machine = 0;// ensure that machine has reset
                while(machine!=3)
                {
                    System.out.println("What vending machine would you like to create?");
                    System.out.println("[1] Regular Vending machine");
                    System.out.println("[2] Special Vending Machine");
                    System.out.println("[3] Return");
                    System.out.print(">> ");
                    machine = sc.nextInt();
                    sc.nextLine();

                    if (machine == 1)
                    {
                        System.out.println("Creating a Regular Vending Machine...");
                        System.out.print("What will be the name of your vending machine? ");
                        name = sc.nextLine();
                        System.out.print("with how many slots? ");
                        numberofslots = sc.nextInt();
                        sc.nextLine(); // to remove the /n

                        while(numberofslots > 20 || numberofslots < 8)
                        {   
                            if (numberofslots==0)
                            {
                                System.out.println("Error... Cannot add 0 slots");
                            }
                            else
                            {
                                System.out.println("Error. You can only add at least 8 slots, up to 20 slots");
                            }

                            System.out.print("with how many slots? ");
                            numberofslots = sc.nextInt();
                            sc.nextLine(); // to remove the /n
                        }
                    // creating new vending machine
                    vendingmachine = new RegularVendingMachine(name);
                    
                    System.out.println("Congratulations!, you just created a regular vending machine with " + vendingmachine.getMAXnumberOfSlots()+ " empty slots");
                    System.out.println("\nA vending machine needs products inside! Kindly fill out the following information to add your first item!");;
                    // adding items in the machine itself
                    // setting up items in the slot
                        do
                    {
                        if (vendingmachine.getCURRENTnumberOfSlots() < vendingmachine.getMAXnumberOfSlots())
                        {
                            System.out.print("Name: ");
                            itemName = sc.nextLine();

                            System.out.print("Price: ");
                            itemPrice = sc.nextFloat();
                            sc.nextLine();

                            while(itemPrice < 0)
                            {
                                System.out.println("Error... Must be positive");
                                System.out.print("Price: ");
                                itemPrice = sc.nextFloat();
                                sc.nextLine();
                            }

                            System.out.print("Calories: ");
                            itemCalories = sc.nextFloat();
                            sc.nextLine();

                            while(itemCalories < 0)
                            {
                                System.out.println("Error... Must be positive");
                                System.out.print("Calories: ");
                                itemCalories = sc.nextFloat();
                            }
                            System.out.print("Quantity: ");
                            itemQuantity = sc.nextInt();
                            sc.nextLine();

                            while(itemQuantity < 10 || itemQuantity > 20)
                            {
                                if (itemQuantity < 10)
                                {
                                    System.out.println("Error... Must stock at least 10 items");
                                    System.out.print("Quantity: ");
                                    itemQuantity = sc.nextInt();
                                    sc.nextLine();
                                }
                                else if (itemQuantity > 20)
                                {
                                    System.out.println("Error... Can only stock up to 20 items");
                                    System.out.print("Quantity: ");
                                    itemQuantity = sc.nextInt();
                                    sc.nextLine();
                                }
                                
                            }

                            temp = new Item(itemName,itemPrice,itemCalories);

                            int slotNumber;

                            System.out.println(" At what slot do you intend to put this item?");
                            vendingmachine.displaySlots();
                            System.out.print(">> ");
                            slotNumber = sc.nextInt();

                            while(slotNumber<0 || slotNumber > vendingmachine.getMAXnumberOfSlots())
                            {
                                System.out.print("Error... Slot does not exist");
                                System.out.print(">> ");
                                slotNumber = sc.nextInt();
                            }

                            if (vendingmachine.addSlot(temp, itemQuantity, slotNumber)) // adds the slot in the item, must return true
                            {
                                System.out.println("Loading...");
                                System.out.println("Stocking...");
                                System.out.println("Successfully Added!");
                            }   
                            else
                            {
                                System.out.println("Error"); // adding success failed
                            }

                            System.out.println("Do you wish to add another slot?");
                            System.out.println("[1] Yes");
                            System.out.println("[2] No");
                            System.out.print(">> ");
                            slotAdd = sc.nextInt();
                            sc.nextLine();
                        }
                        else
                        {
                            System.out.println("Error. You can only add up to " + vendingmachine.getMAXnumberOfSlots() + " slots");
                            slotAdd = 2;
                        }

                    }while(slotAdd== 1);

                    System.out.println("Items are now added in the machine. ");
                    System.out.println("Readying Items....");
                    System.out.println("To ensure that the launch of the vending machine is successful, ");
                    System.out.println("10 counts of each bill and coin are already loaded in the machine");
                    System.out.println("Would you like to add more money to provide change? ");
                    System.out.println("[1] Yes");
                    System.out.println("[2] No");
                    System.out.print(">> ");
                    addMoney = sc.nextInt();
                    sc.nextLine();

                        // adding denominations of money in the machine for change
                    while(addMoney == 1)
                    {
                        
                        vendingmachine.addCash(); // adds demoninations the vending machine currently hold. In default, the machine have 50 of each coin or bill
                        System.out.println("Continue Adding? ");
                        System.out.println("[1] Yes");
                        System.out.println("[2] No");
                        System.out.print(">> ");
                        addMoney = sc.nextInt();
                        sc.nextLine();
                    }
                    System.out.println("Total number of slots: " + vendingmachine.getCURRENTnumberOfSlots());
                    vendingmachine.displaySlots();;
                    System.out.println("\nVending machine money vault:::");
                    vendingmachine.printCash();

                    machine = 3;
                    }
                    else if (machine == 2)
                    {
                        System.out.println("Special vending machine under maintenance");
                    }
                    else if (machine==3)
                    {
                        System.out.println("Returning...");
                    }
                    else
                    {
                        System.out.println("Error... Invalid input");
                    }

                }
            }
            else if (option == 2)
            { 
                do{
                System.out.println("CHOOSE::");
                System.out.println("[1] Vending Features");
                System.out.println("[2] Maintenance Features");
                System.out.println("[3] Return");
                System.out.print(">> ");
                features = sc.nextInt();
                sc.nextLine();
                // checks if a real vending machine is created before trying its features
                if (vendingmachine.getName() == "placeholder" && features < 3 && features > 0)
                {
                    features = 6;
                    System.out.println("Error... No existing vending machines to test or maintain");
                }
                else if (features == 1)
                {
                    totalCash = 0;
                    System.out.println("You picked Vending Features!");
                    System.out.println("You can now test your vending machine!");
                    System.out.println("Welcome to " + vendingmachine.getName());

                    totalCash = vendingmachine.getInsertedMoney(totalCash); // gets the amount the customer will inserted in the machine

                    if (vendingmachine.doTransaction(totalCash)) // if the customer successfully transacts witht the machine
                    {
                        
                        System.out.println("Purchase Success!");
                    }


                    // options presented after making the purchase
                    do
                    {
                        System.out.println("OPTIONS:: ");
                        System.out.println("[1] Add money");
                        System.out.println("[2] Purchase another item");
                        System.out.println("[3] Get change");
                        System.out.print(">> ");
                        vendingContinue = sc.nextInt();
                        sc.nextLine();
                        

                        if (vendingContinue == 1) // add more money
                        {
                            totalCash = vendingmachine.getInsertedMoney(totalCash);
                            (vendingmachine.getCurrentTransaction()).setBalance((vendingmachine.getCurrentTransaction()).getBalance() + totalCash);
                        }
                        else if (vendingContinue == 2) // if purchase another item with the remaining cash that is still in the system
                        {
                            if (vendingmachine.doTransaction((vendingmachine.getCurrentTransaction()).getBalance())) // if the customer successfully transacts witht the machine
                            {
                                System.out.println("Purchase Success!");
                            }
                            else
                            {
                                vendingContinue = 3;
                            }
                        }

                    }while(vendingContinue != 3);

                    if (vendingContinue == 3)
                    {
                        System.out.println("Returning change...");
                        if ((vendingmachine.getCurrentTransaction()).getBalance() != 0)
                        {
                            System.out.println("Total Change: " + (vendingmachine.getCurrentTransaction()).getBalance());
                            vendingmachine.giveChange((vendingmachine.getCurrentTransaction()).getBalance());
                        }
                        else
                        {
                            System.out.println("Exact payment.. No change");
                        }
                        
                        
                        System.out.println("Exiting...");
                    }


                }
                else if(features == 2)
                {
                    maintenancefeatures = 1; // resets the input
                    while(maintenancefeatures < 8 && maintenancefeatures > 0)
                    {
                        System.out.println("You picked Maintenance Features");
                        System.out.println("What would you like to do?");
                        System.out.println("[1] Restock items");
                        System.out.println("[2] Change price");
                        System.out.println("[3] Collect earnings");
                        System.out.println("[4] Replenish money");
                        System.out.println("[5] Print transactions");
                        System.out.println("[6] Display inventory");
                        System.out.println("[7] Remove slot");
                        System.out.println("[8] Add new slot");
                        System.out.println("[9] Return");
                        System.out.print(">> ");
                        maintenancefeatures = sc.nextInt();
                        sc.nextLine();


                        switch(maintenancefeatures)
                        {
                            case 1:
                            {
                                System.out.println("Restock Items");
                                vendingmachine.displaySlots();
                                System.out.print("Enter item name: ");
                                restockItem = sc.nextLine();
                                System.out.print("By how much? ");
                                restockQuantity = sc.nextInt();
                                sc.nextLine();
                                if (vendingmachine.restockItem(restockItem,restockQuantity))
                                {
                                    System.out.println("Successfully restocked!");
                                }

                                System.out.println("Total number of slots: " + vendingmachine.getCURRENTnumberOfSlots());
                                for(int i=0;i<vendingmachine.getCURRENTnumberOfSlots();i++)
                                {
                                    System.out.println("Slot " + i + " " + (vendingmachine.getSlot(i)).getPrimaryItem().getName() + " Quantity: "+ vendingmachine.getSlot(i).getTotalRemainingItem());
                                }
                                System.out.println("Money in the bank");
                                for(int i=0;i<8;i++)
                                {
                                    System.out.println("[ " + i + "] " + (vendingmachine.getCash())[i].getValue() + " Count: " + (vendingmachine.getCash())[i].getCount());
                                }

                                break;
                            }
                            case 2:
                            {
                                System.out.println("Change Price");
                                vendingmachine.displaySlots();
                                System.out.print("Enter item name: ");
                                changePriceItem = sc.nextLine();
                                System.out.print("New price: ");
                                changePrice = sc.nextInt();
                                sc.nextLine();

                                if(vendingmachine.setNewPrice(changePrice, changePriceItem))
                                {
                                    System.out.println("Successfully Changed!");
                                }
                                else
                                {
                                    System.out.println("Cannot change price if no items stocked...");
                                }
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Collecting earnings...");
                                System.out.println("You earned P" + vendingmachine.collectEarnings());
                                
                                break;
                            }
                            case 4:
                            {
                                System.out.println("Replenish Money");
                                vendingmachine.addCash();
                                System.out.println("Successfully added!");

                                System.out.println("Total number of slots: " + vendingmachine.getCURRENTnumberOfSlots());
                                vendingmachine.displaySlots();;
                                System.out.println("Money in the bank");
                                vendingmachine.printCash();
                                break;
                            }
                            case 5:
                            {
                                System.out.println("Printing Transactions...");
                                vendingmachine.displayTransactionHistory();
                                break;
                            }
                            case 6:
                            {
                                System.out.println("Displaying inventory per slot...");
                                vendingmachine.displaySlots();
                                break;
                            }
                            case 7:
                            {
                                int removeSlot;
                                System.out.println("What slot do you intend to remove?");
                                System.out.print(">> ");
                                removeSlot = sc.nextInt();
                                sc.nextLine();
                                while( removeSlot < 1 || removeSlot > vendingmachine.getCURRENTnumberOfSlots())
                                {
                                    System.out.println("Slot does not exist...");
                                    System.out.println("What slot do you intend to remove?");
                                    removeSlot = sc.nextInt();
                                    sc.nextLine();
                                }

                                vendingmachine.removeSlot(removeSlot);
                                break;
                            }
                            case 8:
                            {
                                System.out.println("Adding new slot");
                                do
                                {
                                    if (vendingmachine.getCURRENTnumberOfSlots() < vendingmachine.getMAXnumberOfSlots())
                                    {
                                        System.out.print("Name: ");
                                        itemName = sc.nextLine();
                                        System.out.print("Price: ");
                                        itemPrice = sc.nextFloat();
                                        System.out.print("Calories: ");
                                        itemCalories = sc.nextFloat();
                                        System.out.print("Quantity: ");
                                        itemQuantity = sc.nextInt();
                                        sc.nextLine();

                                        while(itemQuantity < 10 || itemQuantity > 20)
                                        {
                                            if (itemQuantity < 10)
                                            {
                                                System.out.println("Error... Must stock at least 10 items");
                                                System.out.print("Quantity: ");
                                                itemQuantity = sc.nextInt();
                                                sc.nextLine();
                                            }
                                            else if (itemQuantity > 20)
                                            {
                                                System.out.println("Error... Can only stock up to 20 items");
                                                System.out.print("Quantity: ");
                                                itemQuantity = sc.nextInt();
                                                sc.nextLine();
                                            }
                                            
                                        }

                                        temp = new Item(itemName,itemPrice,itemCalories);

                                        if (vendingmachine.addSlot(temp, itemQuantity, 0))
                                        {
                                            System.out.println("Loading...");
                                            System.out.println("Stocking...");
                                            System.out.println("Successfully Added!");
                                        }
                                        else
                                        {
                                            System.out.println("Error");
                                        }

                                        System.out.println("Do you wish to add another slot?");
                                        System.out.println("[1] Yes");
                                        System.out.println("[2] No");
                                        System.out.print(">> ");
                                        slotAdd = sc.nextInt();
                                        sc.nextLine();
                                    }
                                    else
                                    {
                                        System.out.println("Error. You can only add up to " + vendingmachine.getMAXnumberOfSlots() + " slots");
                                        slotAdd = 2;
                                    }

                                }while(slotAdd== 1);

                            }
                        }
                    }
                }
                else if (features  == 3)
                {
                    System.out.println("Returning...");
                }
                else
                {
                    System.out.println("Error... Invalid input");
                }
                }while(features != 3);
                
            }
            else if(option==3)
            {
                System.out.println("Good bye!");
            }
            else 
            {
                System.out.println("Invalid input... Please try again.\n");
            }

        }
        
    

    sc.close();
    }
}
