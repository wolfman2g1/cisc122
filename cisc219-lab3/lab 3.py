exit = False
while exit == False: # exeute until the exit signal is passed
    """Set the initial values to zero"""
    cost_per_serving = 0.0
    labor = 0.0
    rent = 0.0
    utilities = 0.0
    ads = 0.0
    selling_price = 0.0
    servings_sold = 0
    """print menu to screen"""
    def menu():
        print("------\r" + "Expenses:\n" + f"1. Cost per serving: {cost_per_serving}\n" + f"2. Labor rate per hour:{labor}\n"
             + f"3. Shop rental per month:{rent}\n" + f"4. Utilities per month:{utilities}\n"
             + f"5. Advertising budget per month:{ads}\n\n" "\n" + "Income:\n"
             + f"6. Selling price (each):{selling_price}\n" + f"7. Servings sold per month:{servings_sold}\n\n" 
             + "Analysis:\n" + "8. Profit/Loss Calculation\n" + '9. What If" analysis with 10% variance\n\n'
             + "Enter Selection (0 to Exit):\n" + "------" )

    """ calculate profit or loss"""         
    def profit():
        income = selling_price * servings_sold
        expenses = cost_per_serving + labor + rent + utilities + ads
        final = income - expenses
        per_serving = final/servings_sold
        print(f"The Ice Cream Shop will have a monthly profit/loss of {final}" + " " + f"or {per_serving} per serving")
    
    def whatif():
        income = selling_price * servings_sold
        expenses = cost_per_serving + labor + rent + utilities + ads
        """ vary expenses +- 10%"""
        print("Varying the Expenses +/-10%:\n")
        for x in range(-10,10,2):
            expense_percent = expenses * x
            expense_delta = expenses + expense_percent
            final_profit = income - expense_delta
            
            print(f"Percent: {expense_percent}" + " " + " " + f"Expenses: {expense_delta}" + " " + f"Profit/Loss: {final_profit}")
 
        """Vary income"""
        print("Varying the Income +/-10%:\n")
        for x in range(-10,10,2):
            income_percent = income * x
            income_delta = income + x
            final_income = income_delta - expenses
            print(f"Percent: {income_percent}" + " " + " " + f"Income: {income_delta}" + " " + f"Profit/Loss: {final_income}")

    
    """Run the menu when script starts"""
    menu()
    """ Pront user for input"""
    option = int(input(" Select 1-7 to change value or type n to continue: "))
    if option == 1:
        opt1 =float(input("Enter new value of Cost per serving:\n"))
        cost_per_serving = opt1
        menu()
    elif option == 2:
        opt2 =float(input("Enter new value of Labor rate per hour:\n"))
        labor = opt2
        menu()
    elif option == 3:
        opt3 = float(input("Enter new value of Shop rental per month:\n"))
        rent = opt3
        menu()
    elif option == 4:
        opt4 = float(input("Enter new value of Utilities per month:\n"))
        utilities = opt4
        menu()
    elif option == 5:
        opt5 = float(input("Enter new value of Advertising budget per month:\n"))
        ads = opt5
        menu()
    elif option == 6:
        opt6 = float(input("Enter new value of Selling price (each):\n"))
        selling_price = opt6
        menu()
    elif option == 7:
        opt7 = float(input("Enter new value of Servings sold per month:\n"))
        servings_sold = opt7
        menu()
    elif option == 8:
        profit()
        menu()       
    elif option == 9:
       whatif()
       menu()
    elif option == 0:  # set exit to True and terminate
        exit = True



