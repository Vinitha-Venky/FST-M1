user_input = input("Enter a list of numbers separated by spaces: ")
numbers_tuple = tuple(map(int, user_input.split()))

print(numbers_tuple)
print("Elements that are divisible by 5:")
for num in numbers_tuple:
    if (num % 5 == 0):
        print(num)