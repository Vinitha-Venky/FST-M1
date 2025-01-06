import pandas

dataframe=pandas.read_csv("Activity17.csv")
print(dataframe)

print("Usernames:")
print(dataframe["Usernames"])

print(dataframe["Usernames"][1],dataframe["Passwords"][1])

dataframe.sort_values("Usernames")
print("sorted column:")
print(dataframe["Usernames"])

dataframe.sort_values("Passwords",ascending = False)
print("sorted pass:")
print(dataframe["Passwords"])