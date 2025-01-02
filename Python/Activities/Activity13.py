def sum_list(elements):
    sum = 0
    for element in elements:
       sum += element
    print("The sum of all elements is:", sum)

user_input = input("Enter a list of numbers separated by spaces: ")
numbers_list = list(map(int, user_input.split()))

sum_list(numbers_list)