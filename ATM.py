class ATM:
    def __init__(self):
        self.current_balance = 2000.0
        self.saving_balance = 1000.0
        self.users = {
            11111: 111,
            11112: 222,
            11113: 333,
            11114: 444,
            11115: 111
        }
    
    def login(self):
        print("Welcome to my ATM")
        try:
            customer_num = int(input("Enter Customer Number: "))
            pin = int(input("Enter Pin Number: "))
            
            if customer_num in self.users and self.users[customer_num] == pin:
                print("Login Successful")
                return True
            else:
                print("Incorrect Customer Number or Pin Number")
                return self.login()
        except:
            print("\nEnter Only Numbers")
            return self.login()
    
    def show_menu(self):
        print("\nSelect Account Type:")
        print("1. Current Account")
        print("2. Saving Account")
        print("3. Exit")
        choice = int(input("Choice: "))
        
        if choice == 1:
            self.current_account()
        elif choice == 2:
            self.saving_account()
        elif choice == 3:
            print("Visit Again!")
        else:
            print("Invalid Choice")
            self.show_menu()
    
    def current_account(self):
        print("\nCurrent Account")
        print("1. Balance Enquiry")
        print("2. Withdraw Money")
        print("3. Deposit Money")
        print("4. Exit")
        choice = int(input("Choice: "))
        
        if choice == 1:
            print(f"Current Balance: ₹{self.current_balance:,.2f}")
            self.show_menu()
        elif choice == 2:
            amount = float(input("Enter Amount to Withdraw: "))
            if amount <= self.current_balance:
                self.current_balance -= amount
                print(f"Current Balance: ₹{self.current_balance:,.2f}")
            else:
                print("Insufficient Balance")
            self.show_menu()
        elif choice == 3:
            amount = float(input("Enter Amount to Deposit: "))
            self.current_balance += amount
            print(f"Current Balance: ₹{self.current_balance:,.2f}")
            self.show_menu()
        else:
            print("Visit Again!")
    
    def saving_account(self):
        print("\nSaving Account")
        print("1. Balance Enquiry")
        print("2. Withdraw Money")
        print("3. Deposit Money")
        print("4. Exit")
        choice = int(input("Choice: "))
        
        if choice == 1:
            print(f"Saving Balance: ${self.saving_balance:,.2f}")
            self.show_menu()
        elif choice == 2:
            amount = float(input("Enter Amount to Withdraw: "))
            if amount <= self.saving_balance:
                self.saving_balance -= amount
                print(f"Saving Balance: ${self.saving_balance:,.2f}")
            else:
                print("Insufficient Balance")
            self.show_menu()
        elif choice == 3:
            amount = float(input("Enter Amount to Deposit: "))
            self.saving_balance += amount
            print(f"Saving Balance: ${self.saving_balance:,.2f}")
            self.show_menu()
        else:
            print("Visit Again!")


if __name__ == "__main__":
    atm = ATM()
    # atm.login()  # Uncomment to enable login
    atm.show_menu()
