# Personal-Expense-Management
 In this Java assignment, I crafted a personal expense management app with classes like User, Expense, Income, and Account. Validated DNI, handled transactions, and utilized a Java-based Main class for program execution and user interaction.


Expense Management Application
In this object-oriented programming project, I crafted a personal expense management application based on a provided class diagram. Here's a summary of the key components:

User Class:
- Managed individual user details.
- Validated DNI format using regular expressions.
- Implemented a toString function for class content.
- Restricted the use of imports.
- Expense and Income Classes:
- Both inherited from the Money class, with constructors to initialize values.
- Implemented toString functions for class content.
- Restricted the use of imports.

Account Class:
- Managed all financial transactions, handling both income and expenses.
- Received the account owner in the constructor, with an initial balance of €0.
- Implemented logic for adding income and expenses, verifying sufficient balance, and handling exceptions.
- Created functions (getGastos and getIngresos) to retrieve transactions.
- Added a toString function to display the user and balance.
- Permitted importing only the List class and the chosen class for that List.

Main Class:
- Initiated the program and followed defined steps.
- Created the user and their data, ensuring correct DNI input.
- Established the account and displayed an interactive console menu.
- Followed specific steps for each action, avoiding additional imports except for Scanner.
- Recommended creating custom methods for better organization without duplicating existing ones.
- Concluded with the application displaying the message "End of the program. Thank you for using the M03B application in the 1s2324 course."
