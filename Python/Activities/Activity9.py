
# Taking input from the user for the first list
user_input1 = input("Enter the first list of numbers separated by spaces: ")
list1 = list(map(int, user_input1.split()))

# Taking input from the user for the second list
user_input2 = input("Enter the second list of numbers separated by spaces: ")
list2 = list(map(int, user_input2.split()))

# Printing the lists
print(list1 , list2)

list3 = []
 
# Iterate through first list to get odd elements
for num in list1:
    if (num % 2 != 0):
        list3.append(num)
        
# Iterate through first list to get even elements
for num in list2:
    if (num % 2 == 0):
        list3.append(num)
 
# Print result
print("result List is:")
print(list3)