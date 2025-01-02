fruits_prices = {
    "apple": 250.5,
    "banana": 60.2,
    "orange": 75.56,
    "mango": 1000.5,
    "grape": 48.0,
    "pineapple": 55.6
}


user_input = input("Enter the name of the fruit to check availability: ").lower()

	
if(user_input in fruits_prices):
    print("Yes, this is available")
else:
    print("No, this is not available")