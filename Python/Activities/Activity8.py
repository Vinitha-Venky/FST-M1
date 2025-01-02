
# Taking input from the user
user_input = input("Enter a list of numbers separated by spaces: ")

# Converting the input string to a list of integers
numbers_list = list(map(int, user_input.split()))

	
# Get first element in list
firstElement = numbers_list[0]
print(firstElement)
# Get last element in list
lastElement = numbers_list[-1]
print(lastElement)
 
# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)