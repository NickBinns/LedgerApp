Hello and welcome to my first capstone project. Here I will explain my project along with some of my code and show some pictures of my application.
This project is Accounting Ledger Application. the purpose of this app is that a user can input infomation and it can be saved to a file to store that input and pull infomation from there when needed
From line 14-78 is the home screen which gives the user a option to select if they want to add a deposit, make a purchase, view a reports screen and exit the application.
The picture above is the home screen with the options they can choose. If they type in "R", it will display a new screen with more options for them to choose from. I will show that with more pictures

![homeScreen](https://github.com/NickBinns/LedgerApp/assets/166635288/54ebb924-eeef-491b-a2de-f704bbd45670)

The second picture below is an example of the user inputing infomation for either option "D" or "P" since they use similar code. Once they input the infomation it will be saved to the CSV file I have linked to the code. An example of this would be seen in lines 62-75 

![depositScreen](https://github.com/NickBinns/LedgerApp/assets/166635288/85cd90ce-ce37-4615-b4c1-c76e3ed7a235)

The next picture below is the csv file I have created to accept the user input and store it for future use such as reading from it and producing output which would come from a buffreader. I had typed some data into the file beforehand to test out other code to make sure it was picking up on the data in the file

![ledgerCSV](https://github.com/NickBinns/LedgerApp/assets/166635288/b23fe423-3110-4d56-b1a2-1dab7cf7a76b)

The following picture is the ledger screen. The user has the following options to display all entries, entires with either only the deposit or payments, and a additional reports screen which allows the user to run more in-depth searches

![ledgerScreen](https://github.com/NickBinns/LedgerApp/assets/166635288/503007b9-ca97-429f-b156-c197f48bd25d)

The picture below is showing what would display if the user was to click the "All" option. It would display all the users inputs from the very first entry.

![ledgerScreenReports](https://github.com/NickBinns/LedgerApp/assets/166635288/5c1ab982-4766-4565-b70c-781eba3c12dd)

The screen below is what would display if the user chooses the "Reports" option and they can type in a number to select what they would want to do. I have provided an example of what happens if they choose to run a vendor search.

![ledgerReports](https://github.com/NickBinns/LedgerApp/assets/166635288/723891b9-df5d-4b57-b5c8-789dda423bb6)

I will not lie, this project was not easy since it was first time coding a full java project and there are some errors with my code that I will discuss but first I will show a interesting piece of code I wrote.
The picture below is what I used to accept a vendor search from the user. I was struggling with this part and had to utilize the internet for help because I thought this area of the code would be similar to what i have above but little did I know I would have to make changes. I stored the list of the input into the string value and searchTerm into a scanner so that if the user vendor input matches a vendor in the file, it would pull the infomation specific for that vendor and display it

![ledgarCoolCode](https://github.com/NickBinns/LedgerApp/assets/166635288/a2668fd7-d8f2-48bf-aad1-18f0c1763c78)

Touching back on a few errors of my application which are minor but needs work is my code is not filtering out deposits and purchases when I click on those options. From line 109-140 is the code for displaying deposits and purchases. I already see the first issue being that the code is only displaying deposits and purcahses from the amount section in the csv file which is index 4. I would need to come up with a method in which the code will only display their respective options along with when the user inputs purcahses, the number comes out as a negative. A option for that could be to change it to a float since it is money and uses decimal places and having the user input come out as a negative number. Another option could be to have the user type it in but I rather find a method that will display a negative number for the purchases.

This was my first time creating a java application and it is not perfect but with practice, my coding will get better.
